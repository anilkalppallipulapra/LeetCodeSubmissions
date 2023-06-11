class Solution {
    public int findNonMinOrMax(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        // Find the minimum and maximum values in the array
        for (int num : nums) {
            if (num < minVal) {
                minVal = num;
            }
            if (num > maxVal) {
                maxVal = num;
            }
        }
        // Find any number that is not the minimum or maximum
        for (int num : nums) {
            if (num != minVal && num != maxVal) {
                return num;
            }
        }
        // Return -1 if there is no such number
        return -1; 
    }
}