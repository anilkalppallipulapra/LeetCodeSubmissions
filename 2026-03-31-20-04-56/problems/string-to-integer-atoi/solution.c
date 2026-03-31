/*
 * @lc app=leetcode id=8 lang=c
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
int myAtoi(char* s) {
    int i = 0;
    int sign = 1;
    long result = 0;

    // Step 1: Skip leading whitespace (manual check instead of isspace)
    while (s[i] == ' ' || s[i] == '\t' || s[i] == '\n') i++;

    // Step 2: Handle sign
    if (s[i] == '+' || s[i] == '-') {
        sign = (s[i] == '-') ? -1 : 1;
        i++;
    }

    // Step 3: Read digits (manual check instead of isdigit)
    while (s[i] >= '0' && s[i] <= '9') {
        int digit = s[i] - '0';

        // Step 4: Overflow check BEFORE updating result
        if (result > (INT_MAX - digit) / 10) {
            return (sign == 1) ? INT_MAX : INT_MIN;
        }

        result = result * 10 + digit;
        i++;
    }

    return (int)(sign * result);
}
// @lc code=end

