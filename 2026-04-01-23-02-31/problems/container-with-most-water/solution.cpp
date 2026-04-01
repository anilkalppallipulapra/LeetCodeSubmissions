/*
 * @lc app=leetcode id=11 lang=cpp
 *
 * [11] Container With Most Water
 */

#include <vector>
#include <algorithm>
using namespace std;

// @lc code=start
class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0, right = height.size() - 1;
        int max_area = 0;

        while (left < right) {
            int width = right - left;
            int area = min(height[left], height[right]) * width;
            max_area = max(max_area, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;    
    }
};
// @lc code=end

