package FishLab;

public class Fish {
    private String type;
    private double size, weight;
    /*
    Type of fish (carp, catfish, etc..)
    Size of the fish (inches long)
    Weight of the fish(in pounds)
    */
    public Fish(String type, double size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    } 
    public String getName() {
        return type;
    }   
}
