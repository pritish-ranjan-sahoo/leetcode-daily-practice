class Solution {
    public boolean canPartition(int[] nums) {
        int max = nums[0];
        int sum=0;
        for(int num : nums){
            sum+=num;
            max = Math.max(max,num);
        }

        if(sum%2 == 1) return false;

        sum/=2;
        // Arrays.sort(nums);
        int n = nums.length;
        boolean [][] dp = new boolean[n+1][sum+1];
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = true;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                } else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}