/*
 * @lc app=leetcode id=12 lang=cpp
 *
 * [12] Integer to Roman
 */
#include <string>
using namespace std;
// @lc code=start
class Solution {
public:
    string intToRoman(int num) {
        static const int values[] = {1000, 900, 500, 400, 100, 90,
                         50, 40, 10, 9, 5, 4, 1};
        static const string symbols[] = {"M","CM","D","CD","C","XC",
                         "L","XL","X","IX","V","IV","I"};

        string roman; 
        roman.reserve(10); // pre-allocate enough space
        
        for (int i = 0; i < 13; i++) {
            int count = num / values[i];
            num %= values[i];

            if (symbols[i].size() == 1) {
                roman.append(count, symbols[i][0]); // efficient for single-char
            } else {
                for (int j = 0; j < count; j++) {
                    roman += symbols[i]; // append multi-char symbols
                }
            }
        }
        return roman;
    }
};
// @lc code=end

