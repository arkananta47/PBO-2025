
/**
 * Write a description of class simulator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.List;
public class Simulator
{
    private Field field;
    private List<Animal> animals;
    
    public Simulator(int depth, int width){
        field = new Field(depth, width);
        animals = new ArrayList<>();
        populate();
    }
    
    public void simulate(int steps) {
        for (int step = 1; step <= steps; step++){
            List<Animal> newAnimals = new ArrayList<>();
            System.out.println("Step " + step + " Foxes: " + count(Fox.class) + " Rabbits: " + count(Rabbit.class));
            field.print2d();
            
            for (Animal animal: new ArrayList<>(animals)) {
                animal.act(newAnimals);
                if (!animal.isAlive()) animals.remove(animal);
            }
            animals.addAll(newAnimals);
        }
    }
    
    private void populate(){
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                double rand = Math.random();
                Location loc = new Location(row, col);
    
                if (rand < 0.08) {          
                    Fox fox = new Fox(field, loc);
                    animals.add(fox);
                } else if (rand < 0.18) {   
                    Rabbit rabbit = new Rabbit(field, loc);
                    animals.add(rabbit);
                } else {
                    field.clear(loc);
                }
            }
        }
    }
    
    private int count(Class cls) {
        int c = 0;
        for (Animal a : animals)
            if (cls.isInstance(a)) c++;
        return c;
    }

}