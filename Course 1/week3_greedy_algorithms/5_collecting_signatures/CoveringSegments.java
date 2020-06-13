import java.util.*;

class Segment {
    int start, end;

    Segment(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class SegmentComparator implements Comparator<Segment>{
    @Override
    public int compare(Segment o1, Segment o2) {
        return Integer.compare(o1.end, o2.end);
    }
}

public class CoveringSegments {

    private static ArrayList<Integer> optimalPoints(Segment[] segments) {
        ArrayList<Integer> points = new ArrayList<>();
        Arrays.sort(segments, new SegmentComparator());

        int point = segments[0].end;
        points.add(point);

        for (Segment s: segments)
            if (point < s.start || point > s.end)
                points.add(point = s.end);

        return points;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        ArrayList<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
