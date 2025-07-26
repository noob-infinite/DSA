package Lab07.pack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public void printAllSubsets_Recurse(List<Integer> set) {
        generateSubsetsRecurse(set, 0, new ArrayList<>());
        System.out.println();
    }

    private void generateSubsetsRecurse(List<Integer> set, int index, List<Integer> current) {
        if (index == set.size()) {
            System.out.print(current + ",");
            return;
        }
        current.add(set.get(index));
        generateSubsetsRecurse(set, index + 1, current);
        current.remove(current.size() - 1);
        generateSubsetsRecurse(set, index + 1, current);
    }    
    public void printAllSubsets_Recurse_withList(List<Integer> set) {
        obvious_backtrack(set, 0, new ArrayList<>());
    }
    private void obvious_backtrack(List<Integer> set, int index, List<Integer> current) {
        if (index == set.size()) {
            System.out.println(new ArrayList<>(current)); // print copy
            return;
        }
        // include current element
        current.add(set.get(index));
        obvious_backtrack(set, index + 1, current);

        // exclude current element (backtrack)
        current.remove(current.size() - 1);
        obvious_backtrack(set, index + 1, current);
    }
    public void printAllSubsets_DP(List<Integer> set) {
        int n = set.size();
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(set.get(j));
                }
            }
            System.out.print(subset + ",");
        }
        System.out.println();
    }
    public static void printAllSubsets_DP_v2(List<Integer> set) {
        int n = set.size();
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            StringBuilder sb = new StringBuilder("[");
            boolean first = true;

            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    if (!first) sb.append(", ");
                    sb.append(set.get(j));
                    first = false;
                }
            }

            sb.append("]");
            System.out.println(sb.toString());
        }
    } 
}