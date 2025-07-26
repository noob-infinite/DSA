package Lab07.pack;

public class EqualsSubsets {
    public boolean canPartition_Recurse(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        return canPartitionRecurseHelper(arr, 0, total / 2);
    }

    private boolean canPartitionRecurseHelper(int[] arr, int index, int sum) {
        if (sum == 0) return true;
        if (index >= arr.length || sum < 0) return false;
        return canPartitionRecurseHelper(arr, index + 1, sum - arr[index]) ||
               canPartitionRecurseHelper(arr, index + 1, sum);
    }    

    public boolean canPartition_Memoiz(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        Boolean[][] memo = new Boolean[arr.length][total / 2 + 1];
        return memoizHelper(arr, 0, total / 2, memo);
    }

    private boolean memoizHelper(int[] arr, int index, int sum, Boolean[][] memo) {
        if (sum == 0) return true;
        if (index >= arr.length || sum < 0) return false;
        if (memo[index][sum] != null) return memo[index][sum];
        memo[index][sum] = memoizHelper(arr, index + 1, sum - arr[index], memo) ||
                           memoizHelper(arr, index + 1, sum, memo);
        return memo[index][sum];
    }    
    public boolean canPartition_DP(int[] arr) {
        int total = 0;
        for (int num : arr) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : arr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }
    public boolean canPartition_DP_optimized(int[] arr) {
    int total = 0;
    for (int num : arr) total += num;

    if (total % 2 != 0) return false; // cannot partition if total is odd

    int target = total / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true; // sum 0 is always possible (empty subset)

    for (int num : arr) {
        // iterate backwards to prevent overwriting earlier results
        for (int j = target; j >= num; j--) {
            dp[j] = dp[j] || dp[j - num];
        }
    }

    return dp[target];
    }
}