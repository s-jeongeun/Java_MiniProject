package miniProject_java;

public class Item {
	String name;
	int price;

	public Item(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}

class Potion extends Item {
	int recovery;

	public Potion(String name, int price, int recovery) {
		super(name, price);
		this.recovery = recovery;
	}
}

class Weapon extends Item {
	int damage;

	public Weapon(String name, int price, int damage) {
		super(name, price);
		this.damage = damage;
	}
}

class OldSword extends Weapon{
	public OldSword(String name, int price, int damage) {
		super(name, price, damage);
	}
}

class Sword extends Weapon{
	public Sword(String name, int price, int damage) {
		super(name, price, damage);
	}
}

class MasterSword extends Weapon{
	public MasterSword(String name, int price, int damage) {
		super(name, price, damage);
	}
}





