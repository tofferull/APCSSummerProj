package arrays.SpellChecker;

public class Word implements Comparable<Word> {
    private int strength;
    private String word;
    public Word(String word) {
        this.word = word;
        strength = 0;
    }
    public void increaseStrength() {
        strength++;
    }
    public void addStrength(int num) {
        strength += num;
    }
    public int getStrength() {
        return strength;
    }
    public String getWord() {
        return word;
    }
    @Override 
    public int compareTo(Word word) {
        if(strength > word.strength)
          return -1;
        else if(word.strength < strength)
            return 1;
        return 0;
    }

}
