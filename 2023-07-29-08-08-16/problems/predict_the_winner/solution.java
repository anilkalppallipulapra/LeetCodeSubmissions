class Solution {
    public boolean PredictTheWinner(int[] nums) {
            return PredictTheWinner(nums, 0, nums.length-1) >= 0;
    }
    
    private int PredictTheWinner(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        return Math.max(nums[i] - PredictTheWinner(nums, i+1, j), nums[j] - PredictTheWinner(nums, i, j-1));
    }
}