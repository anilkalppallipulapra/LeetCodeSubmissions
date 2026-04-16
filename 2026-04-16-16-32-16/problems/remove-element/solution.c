/*
 * @lc app=leetcode id=27 lang=c
 *
 * [27] Remove Element
 */

// @lc code=start
int removeElement(int* nums, int numsSize, int val) {
    int k = 0; // index for elements not equal to val
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }
    return k;
}
// @lc code=end

