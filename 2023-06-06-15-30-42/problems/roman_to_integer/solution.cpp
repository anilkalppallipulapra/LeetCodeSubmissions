class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> romanDict{
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        int result = 0;
        int n = s.length();
        int prevValue = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currValue = romanDict[s[i]];

            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }

            prevValue = currValue;
        }

        return result;
    }
};