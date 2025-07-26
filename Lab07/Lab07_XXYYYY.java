package Lab07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Lab07.pack.*;

public class Lab07_XXYYYY { 
    static void task_01() {
        System.out.println("task_01");
        int[] a = {1,5,11,5};
        int[] b = {1,5,30};
        int[] c = {1,2,3,5};
        EqualsSubsets sol = new EqualsSubsets();
        System.out.println( sol.canPartition_Recurse(a) );
        System.out.println( sol.canPartition_Memoiz(a) ); 
        System.out.println( sol.canPartition_DP(a) );
        System.out.println( sol.canPartition_Recurse(b) );
        System.out.println( sol.canPartition_Memoiz(b) );
        System.out.println( sol.canPartition_DP(b) );
        System.out.println( sol.canPartition_Recurse(c) );
        System.out.println( sol.canPartition_Memoiz(c) );
        System.out.println( sol.canPartition_DP(c) );     
    }
    static void task_02() {
        System.out.println("task_02");
        List<Integer> set = new ArrayList<>(Arrays.asList(1,2,3));
        Subsets sol = new Subsets();
        sol.printAllSubsets_Recurse(set);
        System.out.println("-----");
        sol.printAllSubsets_DP(set);
        sol.printAllSubsets_DP_v2(set);
    }
static void task_03() {
    int [][] grid = {  {0,0,0,0},
                        {0,1,0,0},
                        {0,0,0,1},
                        {1,0,0,0} };
    GridPaths sol = new GridPaths();
    System.out.println("number of paths: " + sol.numberOfPaths(grid) );
}
    public static void main(String[] args) {
        task_01();
        task_02();
        task_03();
    }
}
