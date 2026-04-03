/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start 
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 

class Solution {
    public List<List<Integer>> threeSum(int[] nums) { 
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: sort array

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            // Early termination: if current number > 0, no triplet can sum to 0
            if (nums[i] > 0) break;

            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // need larger sum
                } else {
                    right--; // need smaller sum
                }
            }
        }
        return result;        
    }
}
// @lc code=end

