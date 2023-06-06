class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        std::unordered_set<int> uniqueNums;
        for (int i = 0; i < nums.size(); ++i) {
            if (uniqueNums.count(nums[i]) > 0) {
                return true;
            }
            
            uniqueNums.insert(nums[i]);
        }
        return false;
    }
};