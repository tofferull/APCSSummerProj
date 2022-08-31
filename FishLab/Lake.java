package FishLab;

import java.util.ArrayList;

public class Lake {
    private String name;
    private int length, width, depth;
    private ArrayList<Fish> fishes;
    /*
     * Name of the Lake
        Length, Width and Depth of the lake
        An array of the fish in the lake.
     */
    public Lake(String name, int length, int width, int depth, int numOfFish) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.depth = depth;
        fishes = new ArrayList<>(numOfFish);
    }

    public void addFish(String type, double size, double weight) {
        fishes.add(new Fish(type, size, weight));
    }
    
    public boolean findFish(String name) {
        for (Fish fish : fishes) {
            if (fish.getName().equals(name)) 
                return true;
        }
        return false;
    }
}
