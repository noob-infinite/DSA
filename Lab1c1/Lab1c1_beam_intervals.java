package Lab1c1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lab1c1_beam_intervals {
    public static List<int[]> mergeBeams(List<int[]> beams) {
        if (beams.isEmpty()) return Collections.emptyList();

        // Sort by start angle
        beams.sort(Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = beams.get(0);

        for (int i = 1; i < beams.size(); i++) {
            int[] next = beams.get(i);
            if (current[1] >= next[0]) {  // Overlap
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current);
                current = next;
            }
        }
        merged.add(current); // Add the last one

        return merged;
    }
    static void demo_1() {
        // List<int[]> beams = Arrays.asList(new int[]{10, 90},
        //     new int[]{70, 100},
        //     new int[]{150, 210}
        // );
        // List<int[]> beams = Arrays.asList(new int[]{70, 100},
        //     new int[]{150, 180},
        //     new int[]{160, 185}, new int[] {350,60}
        // );        
        // List<int[]> beams = Arrays.asList(new int[]{10, 210},
        //     new int[]{180, 30}
        // );
        // List<int[]> beams = Arrays.asList(new int[]{10, 210},
        //     new int[]{210, 10}
        // );        
        
    int n = 3;
    int [] data = {10, 90, 70, 100, 150, 210};
    List<int[]> beams = new ArrayList<>();
    for (int i = 0; i < 2*n; i+=2) {
        beams.add(new int[] {data[i],data[i+1]});
    }
    List<int[]> merged = mergeBeams(beams);

    for (int[] beam : merged) {
        System.out.println(Arrays.toString(beam));
    }
}
    public static void main(String[] args) {
        demo_1();
    }
}
/*
  // widest
  sort(v.begin(), v.end());
//   for (int i = 0; i < n; i++) {
//     cout << v[i].first << " " << v[i].second << " -> ";
//   } cout << endl;
  start_deg = v[0].first;
  end_deg = v[0].second;
  for (int i = 1; i < n; i++) {    
    if (end_deg >= v[i].first) {
        end_deg = v[i].second;
        // continue;
    } else {
        start_deg = v[i].first;
        end_deg = v[i].second;
    }
    widest = max(widest, end_deg - start_deg);    
  }
  cout << widest;
 */
