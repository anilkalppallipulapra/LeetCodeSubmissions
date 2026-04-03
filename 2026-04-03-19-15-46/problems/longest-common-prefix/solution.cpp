/*
 * @lc app=leetcode id=14 lang=cpp
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
#include <string>
#include <vector>
using namespace std;
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.empty()) return "";

        // Start with the first string as the prefix
        string prefix = strs[0];

        // Compare with each string in the array
        for (int i = 1; i < strs.size(); i++) {
            // Shrink prefix until it matches the beginning of strs[i]
            while (strs[i].find(prefix) != 0) {
                prefix = prefix.substr(0, prefix.size() - 1);
                if (prefix.empty()) return "";
            }
        }
        return prefix;        
    }
};
// @lc code=end

