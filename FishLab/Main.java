package FishLab;

public class Main {
    public static void main(String[] args) {
        Lake LOF = new Lake("lotsOfFish", 100, 50, 25, 250);
        LOF.addFish("catfish", 15, 2.5);
        LOF.addFish("carp", 10, 3.1);
        boolean isFound = LOF.findFish("catfish");
        if (isFound) System.out.println("we found your fish");
        else System.out.println("your fish is not in the lake");

        String a = "a";
        String b = a.charAt(0) + "";
    }
}
