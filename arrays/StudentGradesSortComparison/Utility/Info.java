package arrays.StudentGradesSortComparison.Utility;

public class Info implements Comparable<Info> {
    private double num;
    private String name;

    public Info(double num, String name) {
        this.num = num;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public double getNum() {
        return num;
    }

    @Override public int compareTo(Info data) {
        if(num < data.num)
          return -1;
        else if(data.num < num)
            return 1;
        return 0;
    }

}