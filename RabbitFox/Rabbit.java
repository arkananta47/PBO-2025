
/**
 * Write a description of class rabbit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.List;
public class Rabbit extends Animal
{
    public Rabbit(Field field, Location location) {
        super(field, location);
    }
    
    @Override
    public void act(List<Animal> newAnimals) {
        if (isAlive()) {
            Location newLocation = getField().freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }
}