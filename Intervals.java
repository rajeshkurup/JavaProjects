import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collections;
import java.lang.Exception;

public class Intervals {

    public static class Interval implements Comparable<Interval> {

        private int start;
        private int end;

        public Interval(int start, int end) throws Exception {
            if(start < 0 || end < 0 || start >= end) {
                throw new Exception("invalid interval");
            }
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + this.start + "," + this.end + "]";
        }

        @Override
        public int compareTo(Interval obj) {
            if(this.end == obj.start) {
                return 0;
            } else if(this.start < obj.start) {
                return -1;
            } else {
                return 1;
            }
        }

    }

    private List<Interval> intervals = new ArrayList<>();

    @Override
    public String toString() {
        String result = "[";
        for(Interval interval : intervals) {
            result += interval.toString() + ",";
        }
        return result.substring(0, result.length() - 1) + "]";
    }

    private void rearrange() {
        Collections.sort(intervals);
        int size = intervals.size();
        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                if(intervals.get(i).end >= intervals.get(j).start) {
                    if(intervals.get(i).end < intervals.get(j).end) {
                        intervals.get(i).end = intervals.get(j).end;
                    }
                    intervals.remove(j);
                    size = intervals.size();
                } else {
                    break;
                }
            }
        }
    }

    public void addInterval(int start, int end) throws Exception {
        boolean isMerged = false;
        for(Interval interval : intervals) {
            if(start <= interval.end && start >= interval.start) {
                interval.end = interval.end > end ? interval.end : end;
                isMerged = true;
                break;
            } else if(end <= interval.end && end >= interval.start) {
                interval.start = interval.start < start ? interval.start : start;
                isMerged = true;
                break;
            }
        }

        if(!isMerged) {
            intervals.add(new Interval(start, end));
        }

        rearrange();
    }

    public static void main(String[] args) {

        Intervals intervals = new Intervals();

        try {
            intervals.addInterval(10, 40);
            intervals.addInterval(20, 60);
            intervals.addInterval(5, 12);
            intervals.addInterval(70, 80);
            intervals.addInterval(15, 20);
            intervals.addInterval(90, 100);
            intervals.addInterval(1, 4);
            intervals.addInterval(2, 5);
            intervals.addInterval(91, 99);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println(intervals.toString());
    }
    
}
