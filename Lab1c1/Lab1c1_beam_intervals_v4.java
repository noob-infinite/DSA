package Lab1c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab1c1_beam_intervals_v4 {
public static List<int[]> mergeBeams(List<int[]> beams) {
    if (beams.isEmpty()) return Collections.emptyList();

    List<int[]> linearized = new ArrayList<>();

    for (int[] beam : beams) {
        int start = beam[0], end = beam[1];

        if (start == end) {
            // Special case: beam covers the entire circle
            return List.of(new int[]{0, 0});
        } else if (start < end) {
            // Normal beam
            linearized.add(new int[]{start, end});
        } else {
            // Wrap-around beam (flattened)
            linearized.add(new int[]{start, end + 360});
        }
    }

    // Sort beams by start angle
    linearized.sort(Comparator.comparingInt(a -> a[0]));

    List<int[]> merged = new ArrayList<>();
    int[] current = linearized.get(0);

    for (int i = 1; i < linearized.size(); i++) {
        int[] next = linearized.get(i);

        if (current[1] >= next[0]) {
            // ✅ Merge overlapping intervals by extending the current one
            current[1] = Math.max(current[1], next[1]);
        } else {
            merged.add(current);
            current = next;
        }
    }
    merged.add(current); // Add the final merged interval

    // Map back to [0, 360)
    List<int[]> result = new ArrayList<>();
    for (int[] interval : merged) {
        int start = interval[0] % 360;
        int end = interval[1] % 360;
        if (start == end) {
            // Special case: merged back to full circle
            return List.of(new int[]{0, 0});
        }
        result.add(new int[]{start, end});
    }

    return result;
}
    static void demo_1() {
        List<int[]> beams = Arrays.asList(new int[]{10, 90},
            new int[]{70, 100},
            new int[]{150, 210}
        );
        List<int[]> merged = mergeBeams(beams);

        for (int[] beam : merged) {
            System.out.println(Arrays.toString(beam));
        }
    }
    static void demo_2() {
        List<int[]> beams = Arrays.asList(new int[]{70, 100},
            new int[]{150, 180},
            new int[]{160, 185}, new int[] {350,60}
        ); 
        List<int[]> merged = mergeBeams(beams);

        for (int[] beam : merged) {
            System.out.println(Arrays.toString(beam));
        }
    }
    static void demo_3() {
        List<int[]> beams = Arrays.asList(new int[]{10, 210},
            new int[]{210, 10}
        ); 
        List<int[]> merged = mergeBeams(beams);

        for (int[] beam : merged) {
            System.out.println(Arrays.toString(beam));
        }
    }
    static void demo_4() {
        // List<int[]> beams = Arrays.asList(new int[]{10, 210},
        //     new int[]{180, 30}
        // );
        // -illegal -> {10,210} + {180,30} overlapped on wrap around 
        List<int[]> beams = Arrays.asList(new int[]{10, 10},
            new int[]{20, 20}
        );
        List<int[]> merged = mergeBeams(beams);

        for (int[] beam : merged) {
            System.out.println(Arrays.toString(beam));
        }
    }

    public static void main(String[] args) {
        System.out.println("demo_1");
        demo_1();
        System.out.println("demo_2");
        demo_2();
        System.out.println("demo_3");
        demo_3();
        System.out.println("demo_4");
        demo_4();        
    }
}
