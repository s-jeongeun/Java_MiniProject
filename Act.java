package miniProject_java;

import java.util.Scanner;

public class Act {
	Scanner sc = new Scanner(System.in);
	Character ch = new Character("모험가", 1, 100, 100, 10, 0, 100, 0);
	Monster wolf = new Wolf("늑대", 20, 20, 15);
	Monster orc = new Orc("오크", 45, 45, 20);
	Monster ogre = new Ogre("오우거", 100, 100, 40);
	Item po = new Potion("체력 회복 물약", 100, 30);
	Item so1 = new OldSword("낡은 철검", 200, 5);
	Item so2 = new Sword("양산형 철검", 1000, 20);		
	Item so3 = new MasterSword("고급 철검", 5000, 50);

	public void startGame() {
		int command = 99;
		while (command != 0) {
			System.out.println("1. 모험을 떠난다\n2. 상태창을 확인한다\n3. 인벤토리를 확인한다\n4. 상점에 간다\n5. 여관에 간다\n0. 게임 종료");
			command = sc.nextInt();
			if (command > 5) {
				System.out.println("잘못된 입력입니다.\n");
			} else {
				switch (command) {
				case 1:
					adventure();
					break;
				case 2:
					status();
					break;
				case 3:
					inventory();
					break;
				case 4:
					shop();
					break;
				case 5:
					restInn();
					break;
				}
			}
		}
		System.out.println("게임 종료");
	}

	public void status() {
		System.out.println("====================");
		System.out.println("[상태창]");
		System.out.println(" 직업 : 모험가");
		System.out.println(" 레벨 : " + ch.level);
		System.out.println(" 공격력 : " + ch.damage);
		System.out.println(" 체력 : " + ch.hp + "/" + ch.maxHp);
		System.out.println(" 경험치 : " + (Math.round((ch.exp) * 100) / 100.0));
		System.out.println(" 소지금 : " + ch.gold);
		ch.setItem();	
		System.out.println("====================");
	}

	public void inventory() {
		System.out.println("====================");
		System.out.println("[보유 아이템]");
		if (ch.inven.size() == 0) {
			System.out.println("없음");
		} else {
			for (int i = 0; i < ch.inven.size(); i++) {
				System.out.println(i + 1 + ". " + ch.inven.get(i));
			}
			ch.useItem();
		}
		System.out.println("====================");
		startGame();
	}
	

	public void restInn() {
		System.out.println("~ 여관  ~");
		System.out.println("휴식을 취하시려면 100골드가 필요합니다.\n휴식을 취하시겠습니까?\n");
		System.out.println("1. 휴식을 취한다\n2. 마을로 돌아가기");
		int command = sc.nextInt();
		switch (command) {
		case 1:
			if(ch.gold <100) {
				System.out.println("소지금이 부족합니다.\n마을로 돌아갑니다.\n");
				startGame();
			} else {
				System.out.println("체력이 회복되었습니다.");
				System.out.println("====================");
				System.out.println(" 체력 : + " + (ch.maxHp - ch.hp));
				System.out.println("====================");
				ch.hp = ch.maxHp;
				ch.gold -= 100;
			}
			break;
		case 2:
			startGame();
		}
	}
	
	public void shop() {
		System.out.println("~ 상점  ~");
		System.out.println("1. 아이템 구매하기\n2. 아이템 판매하기\n3. 마을로 돌아가기");
		int command = sc.nextInt();
		switch (command) {
		case 1:
			System.out.println("\n~ 아이템 목록 ~");
			System.out.println("1. " + po.name + "\t가격 : " + po.price + "골드");
			System.out.println("2. " + so1.name + "\t가격 : " + so1.price + "골드");
			System.out.println("3. " + so2.name + "\t가격 : " + so2.price + "골드");
			System.out.println("4. " + so3.name + "\t가격 : " + so3.price + "골드");
			command = sc.nextInt();
			switch (command) {
				case 1:
					ch.buyItem(po);				
					break;
				case 2:
					ch.buyItem(so1);	
					break;
				case 3:
					ch.buyItem(so2);
					break;
				case 4:
					ch.buyItem(so3);
					break;
			}
			break;
		case 2:
			System.out.println("판매할 아이템이 없습니다.");
			break;
		case 3:
			startGame();
		}
	}	


	public void adventure() {

		if (ch.level < 5) {
			System.out.println("1. 마을 부근\n2. 광활한 평야(미탐사 지역)\n3. 미지의 숲(미탐사 지역)\n4. 마을로 돌아가기");
			int command = sc.nextInt();
			switch (command) {
			case 1:
				stageOne();
				break;
			case 2:
				System.out.println("모험 불가 지역입니다.(레벨 5이상 가능)");
				adventure();
				break;
			case 3:
				System.out.println("모험 불가 지역입니다.(레벨 8이상 가능)");
				adventure();
				break;
			case 4:
				System.out.println("마을로 돌아왔습니다.");
				startGame();
				break;
			}
		} 
		else if (ch.level > 4 && ch.level < 8) {
			System.out.println("1. 마을 부근\n2. 광활한 평야\n3. 미지의 숲(미탐사 지역)\n4. 마을로 돌아가기");
			int command = sc.nextInt();
			switch (command) {
			case 1:
				stageOne();
				break;
			case 2:
				stageTwo();
				break;
			case 3:
				System.out.println("모험 불가 지역입니다.(레벨 8이상 가능)\n4. 마을로 돌아가기");
				adventure();
				break;
			case 4:
				System.out.println("마을로 돌아왔습니다.");
				startGame();
				break;
			}
		} else {
			System.out.println("1. 마을 부근\n2. 광활한 평야\n3. 미지의 숲");
			int command = sc.nextInt();
			switch (command) {
			case 1:
				stageOne();
				break;
			case 2:
				stageTwo();
				break;
			case 3:
				stageThree();
				break;
			case 4:
				System.out.println("마을로 돌아왔습니다.");
				startGame();
				break;
			}
		}
	}

	public void stageOne() {
		System.out.println("야생의 늑대를 발견했다!");
		System.out.println("1. 공격한다   2. 도망간다   3. 상태창 확인");
		int command = sc.nextInt();

		switch (command) {
		case 1:
			fight(ch, wolf);
			break;
		case 2:
			run(wolf);
			break;
		case 3:
			status();
			stageOne();
			break;
		}
	}

	public void stageTwo() {
		System.out.println("야생의 오크를 발견했다!");
		System.out.println("1. 공격한다   2. 도망간다   3. 상태창 확인");
		int command = sc.nextInt();

		switch (command) {
		case 1:
			fight(ch, orc);
			break;
		case 2:
			run(orc);
			break;
		case 3:
			status();
			stageTwo();
			break;
		}
	}

	public void stageThree() {
		System.out.println("야생의 오우거를 발견했다!");
		System.out.println("1. 공격한다   2. 도망간다   3. 상태창 확인");
		int command = sc.nextInt();

		switch (command) {
		case 1:
			fight(ch, ogre);
			break;
		case 2:
			run(ogre);
			break;
		case 3:
			status();
			stageThree();
			break;
		}
	}
	
	public void fight(Character player, Monster mob) {
		while (player.hp > 0 && mob.hp > 0) {
			player.attack(mob);
			mob.attack(player);
		}
		if (player.isLive()) {
			System.out.println("\nGAME OVER");
			System.out.println("처음부터 다시 시작하시겠습니까?");
			System.out.println("1. 네\t2. 아니오");
			int command = sc.nextInt();
			switch (command) {
			case 1:
				ch.reSet();		
				startGame();
				break;
			case 2:
				System.out.println("게임 종료");
				System.exit(0);
				break;
			}
		} else {
			System.out.println("\n" + mob.name + "가 죽었습니다.");
			double getExp = ((Math.random() * 10) + 31);
			getExp = (Math.round((getExp) * 100) / 100.0);
			player.exp += getExp;
			System.out.println("경험치 " + getExp + "를 획득했습니다.");
			int getGold = (int) ((Math.random() * 100) + 100);
			player.gold += getGold;
			System.out.println(getGold + "골드를 획득했습니다.");
			if (player.exp >= player.maxExp) {
				player.levelUp();
			}
			System.out.println("\n모험을 무사히 끝냈습니다.");
			mob.hp = mob.maxHp;
			adventure();
		}
	}

	public void run(Monster mob) {
		System.out.println(mob.name + "으로부터 도망쳤다!");
		adventure();
	}

}
