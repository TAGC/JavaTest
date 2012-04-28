package videogame;

public abstract class Entity {
	
	protected String name;
	protected int lifePoints = 0;

	public Entity(String name, int lifePoints) {
		assert(lifePoints >= 0);
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public final boolean isAlive() {
		return lifePoints > 0;
	}
	
	public final int applySpell(SpellCaster spellCaster) {
		int strength, damage;
		
		strength = spellCaster.getStrength();
		damage = propagateDamage(strength);
		
		return damage;
	}
	
	protected abstract int propagateDamage(int damageAmount);

	public abstract int minimumStrikeToDestroy();
	
	@Override
	public String toString() {
		String stringRep;
		stringRep = String.format("%s(%s)", name, lifePoints);
		return stringRep;
	}
	
}
