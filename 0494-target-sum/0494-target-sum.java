class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // Arrays.sort(nums);
        int count = 0, sum = 0;

        for(int num : nums) {
            if(num==0) count++;
            sum+=num;
        }
        if((sum+target) % 2==1) return 0;
        target = Math.abs(target);
        int row = nums.length;
        int col = (sum+target)/2;
        int [][] dp = new int[row+1][col+1];

        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }

        for(int i =1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++) {
                if(nums[i-1]!= 0 && nums[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[row][col]*(int) Math.pow(2,count);
    }
}