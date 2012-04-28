package videogame;

public class GameReport {

	public static void main(String[] args) {

		TransportUnit t1, t2;
		Magician m1, m2, m3, m4, m5, m6, m7;
		Entity[] check_dead, check_alive;
		
		t1 = new TransportUnit("Falkor", 2500);
		t2 = new TransportUnit("Shadowfax", 350);
		
		m1 = new Magician("Ged", 300);
		m2 = new Magician("Dumbledore", 200);
		m3 = new Magician("Saruman", 600);
		m4 = new Magician("Harry", 18);
		m5 = new Magician("Gandalf", 950);
		m6 = new Magician("Gargamel", 200);
		
		t1.add(m1);
		t1.add(m2);
		t1.add(m3);
		t1.add(t2);
		t2.add(m4);
		t2.add(m5);
		
		System.out.println("Initially: " + t1);
		t1.applySpell(m6);
		System.out.println("After attack from " + m6.name + ": " + t1);
		m7 = new Magician("Twilight Sparkle", 
				t1.minimumStrikeToDestroy() / 2);
		t1.applySpell(m7);
		System.out.println("After Twilight's attack: " + t1);
		
		check_dead  = new Entity[]{t1, t2, m1, m2, m3, m4, m5};
		check_alive = new Entity[]{m6, m7};
		
		System.out.println();
		
		if (checkConditionHolds(check_dead, false)) {
			System.out.println("CheckDead test passed");
		} else {
			System.out.println("CheckDead test failed");
		}
		
		if (checkConditionHolds(check_alive, true)) {
			System.out.println("CheckAlive test passed");
		} else {
			System.out.println("CheckAlive test failed");
		}
	}
	
	public static boolean checkConditionHolds(Entity[] entities, 
			boolean condition) {
		for (Entity entity : entities) {
			if (entity.isAlive() != condition) {
				return false;
			}
		}
		return true;
	}

}
