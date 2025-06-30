package Lab1c1;

import java.util.*;

public class Lab1c1_beam_divergence {

    static class Interval implements Comparable<Interval> {
        double start, end;
        Interval(double s, double e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Interval other) {
            return Double.compare(this.start, other.start);
        }
    }

    public static double widestLitAngle(List<double[]> lights) {
        List<Interval> intervals = new ArrayList<>();

        // Step 1: Normalize and split wrap-around intervals
        for (double[] light : lights) {
            double start = normalize(light[0]);
            double end = normalize(light[1]);

            if (start <= end) {
                // Normal interval
                intervals.add(new Interval(start, end));
            } else {
                // Wrap-around interval, split into two
                intervals.add(new Interval(start, 360));
                intervals.add(new Interval(0, end));
            }
        }

        // Step 2: Sort intervals by start angle
        Collections.sort(intervals);

        // Step 3: Merge overlapping/adjacent intervals
        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (next.start <= current.end) {
                // Overlaps or adjacent → merge
                current.end = Math.max(current.end, next.end);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current);

        // Step 4: Handle circular merge between last and first interval
        if (merged.size() > 1) {
            Interval first = merged.get(0);
            Interval last = merged.get(merged.size() - 1);

            // Check if last.end overlaps with first.start + 360
            if (last.end >= 360) last.end -= 360;
            if (first.start <= last.end) {
                // Merge circular intervals
                double newStart = last.start;
                double newEnd = Math.max(first.end + 360, last.end + (last.end < first.start ? 360 : 0));
                merged.set(0, new Interval(newStart, newEnd));
                merged.remove(merged.size() - 1);
            }
        }

        // Step 5: Compute the max interval length (mod 360)
        double maxLength = 0;
        for (Interval interval : merged) {
            double length = interval.end - interval.start;
            if (length < 0) length += 360;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    private static double normalize(double angle) {
        angle %= 360;
        if (angle < 0) angle += 360;
        return angle;
    }

    // Example usage
    public static void main(String[] args) {
        List<double[]> lights = Arrays.asList(
            new double[]{350, 20},
            new double[]{10, 90},
            new double[]{150, 210}
        );

        double widest = widestLitAngle(lights);
        System.out.println("Widest lit angle: " + widest + " degrees");
        // Expected output: 100.0 degrees
    }
}
