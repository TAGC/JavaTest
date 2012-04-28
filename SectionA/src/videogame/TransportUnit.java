package videogame;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TransportUnit extends Entity {
	
	private Set<Entity> entities;
	private final int damageDecayCoef = 2;
	
	public TransportUnit(String name, int lifePoints) {
		super(name, lifePoints);
		entities = new HashSet<Entity>();
	}

	@Override
	public int minimumStrikeToDestroy() {
		int min_damage_needed, damage_needed;
		
		min_damage_needed = lifePoints;
		for(Entity contained_entity : entities) {
			damage_needed = contained_entity.minimumStrikeToDestroy()
			                                 * damageDecayCoef;
			if (damage_needed > min_damage_needed) {
				min_damage_needed = damage_needed;
			}
		}
		return min_damage_needed;
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
		
		for(Entity contained_entity : entities) {
			deduction += contained_entity.propagateDamage(
					(int)(damageAmount * 0.5));
		}
		return deduction;
	}
	
	public void add(Entity entity) {
		entities.add(entity);
	}
	
	@Override
	public String toString() {
		String stringRep;
		String contained_units = Arrays.deepToString(entities.toArray());
		stringRep = String.format("%s transporting: %s", super.toString(),
				contained_units);
		return stringRep;
	}
	
}