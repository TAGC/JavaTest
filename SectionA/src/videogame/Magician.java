package videogame;

public class Magician extends Entity implements SpellCaster {
	
	private final int strengthCoefficient = 2;
	
	public Magician(String name, int lifePoints) {
		super(name, lifePoints);
	}

	@Override
	public int minimumStrikeToDestroy() {
		return lifePoints;
	}

	@Override
	protected int propagateDamage(int damageAmount) {
		int deduction;
		
		if (lifePoints - damageAmount >= 0) {
			deduction = damageAmount;
		} else {
			deduction = lifePoints;
		}
		
		lifePoints -= deduction;
		return deduction;
	}
	
	@Override
	public String toString() {
		String stringRep;
		stringRep = super.toString();
		return stringRep;
	}

	@Override
	public int getStrength() {
		return lifePoints * strengthCoefficient;
	}
}
