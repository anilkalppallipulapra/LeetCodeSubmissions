class Solution {
public:
    int minimumDeleteSum(string s1, string s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 1D vector to store the minimum ASCII sum 
        // of deleted characters.
        vector<int> dp(n + 1, 0);

        // Fill the vector using a bottom-up approach.
        for (int j = n - 1; j >= 0; j--) {
            dp[j] = dp[j+1] + s2[j];
        }

        for (int i = m - 1; i >= 0; i--) {
            // Store the value of dp[i+1][j+1] (diagonal element)
            int prev_diag = dp[n]; 
            // Update dp[i][n] with the appropriate value for the last column.
            dp[n] += s1[i]; 

            for (int j = n - 1; j >= 0; j--) {
                if (s1[i] == s2[j]) {
                    // Store the current value of dp[i][j] (before updating it)
                    int temp = dp[j]; 
                    dp[j] = prev_diag;
                    // Update prev_diag with the new value for the next iteration.
                    prev_diag = temp; 
                } else {
                    // Store the current value of dp[i][j] (before updating it)
                    int temp = dp[j]; 
                    dp[j] = min(dp[j] + s1[i], dp[j+1] + s2[j]); 
                    // Update prev_diag with the new value for the next iteration.
                    prev_diag = temp; 
                }
            }
        }

        return dp[0];
    } 
};