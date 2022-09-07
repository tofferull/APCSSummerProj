package arrays.SortComparison;

public class Timer {
    private long start, end, diff;
    public Timer() {
        start = System.currentTimeMillis();
    }

    public long endTimer(String msg) {
        end = System.currentTimeMillis();
        diff = end - start;
        System.out.println(msg+" took: "+diff+" ms");
        return diff;
    }
}
