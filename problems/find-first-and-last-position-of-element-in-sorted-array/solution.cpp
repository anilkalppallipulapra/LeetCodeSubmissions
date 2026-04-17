/*
 * @lc app=leetcode id=34 lang=cpp
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
private:
    int binarySearch(const vector<int>& nums, int target, bool findFirst) {
        int left = 0, right = nums.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1; // Continue searching in the left half
                } else {
                    left = mid + 1; // Continue searching in the right half
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        return {binarySearch(nums, target, true),
                binarySearch(nums, target, false)};
    }
};
// @lc code=end

