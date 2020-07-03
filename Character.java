package miniProject_java;

import java.util.ArrayList;
import java.util.Scanner;

public class Character extends Element {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> inven = new ArrayList<String>();
	ArrayList<String> equip = new ArrayList<String>();
	
	int level; // 레벨
	double exp; // 경험치
	double maxExp; // 달성 경험치
	int gold; // 소지금
	int addDam; // 츠가 공격력


	public Character(String name, int level, int hp, int maxHp, int damage, double exp, double maxExp, int gold) {
		super(name, hp, maxHp, damage);
		this.level = level;
		this.exp = exp;
		this.maxExp = maxExp;
		this.gold = gold;
	}

	public void levelUp() {
		level += 1;
		maxHp += 10;
		hp = maxHp;
		damage += 5;
		exp -= 100;
		System.out.println("\n레벨이 올랐습니다!\n최대 체력 + 5, 공격력 + 3");
		if (level >= 10) {
			System.out.println("\n레벨 10 달성!\n이것으로 튜토리얼을 끝냅니다.");
			System.exit(0);
		}
	}
	
	public void reSet() {
		hp = 100;
		maxHp = 100;
		damage = 10;
		level = 1;
		exp = 0;
		gold = 0;
		if (inven.size() != 0) {
			for (int i = 0; i < inven.size(); i++) {
				inven.remove(i);
			}
		}
		if (equip.size() != 0) {
			for (int i = 0; i < equip.size(); i++) {
				equip.remove(i);
			}
		}
	}
	
	public void buyItem(Item item) {
		if (gold >= item.price) {
			System.out.println(item.name + "을 구입했습니다.\n");
			gold -= item.price;
			inven.add(item.name);
		} else {
			System.out.println("소지금이 부족합니다.\n마을로 돌아갑니다.\n");
		}
	}
	
	public void useItem() {
		System.out.println("\n사용할 아이템 번호 입력\n");
		int itemNo = sc.nextInt();
		System.out.println(inven.get(itemNo - 1) + "를 사용했습니다.\n");
		if(inven.size() != 0) {
			if (inven.get(itemNo - 1).equals("체력 회복 물약")) {
				hp += 30;
			}
			else if (inven.get(itemNo - 1).equals("낡은 철검")) {
				damage += 5;
			} else if (inven.get(itemNo - 1).equals("양산형 철검")) {
				damage += 20;
			} else {
				damage += 50;
			}
		}		
		if(!inven.get(itemNo - 1).equals("체력 회복 물약")) {
			equip.add(0,inven.get(itemNo-1));
		}
		inven.remove(itemNo - 1);
	}
	
	public void setItem() {
		System.out.println("\n[착용중 장비]");
		if (equip.size() == 0) {
			System.out.println("없음");
		} else {
			for (int i = 0; i < equip.size(); i++) {
				System.out.println(equip.get(i));
			}
		}
	}

}

