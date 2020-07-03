package miniProject_java;

public class Element {
	String name; // 이름
	int hp; // 현재 체력
	int maxHp; // 최대 체력
	int damage; // 공격력

	public Element(String name, int hp, int maxHp, int damage) {
		this.name = name;
		this.hp = hp;
		this.maxHp = maxHp;
		this.damage = damage;
	}

	public void attack(Element enemy) {
		System.out.println(this.name + "가 " + this.damage + "만큼 공격했다!");
		enemy.hp -= this.damage;
		System.out.println(enemy.name + " 체력 : " + enemy.hp + "/" + enemy.maxHp);
	}

	public boolean isLive() {
		if (hp < 1) {
			return true;
		} else {
			return false;
		}
	}
	
}
