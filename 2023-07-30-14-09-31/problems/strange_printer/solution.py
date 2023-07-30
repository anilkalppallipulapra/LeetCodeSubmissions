class Solution:
    def strangePrinter(self, s: str) -> int: 
        n = len(s)
        dp = [[float('inf')] * n for _ in range(n)]

        # Base case: substrings of length 1 require 1 turn
        for i in range(n):
            dp[i][i] = 1

        # Loop over all substring lengths
        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1

                # If the substring has the same characters, we can merge them into a single turn
                if s[i] == s[j]:
                    dp[i][j] = dp[i][j - 1]
                else:
                    # Try to split the substring at every possible position
                    for k in range(i, j):
                        dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j])

        return dp[0][n - 1]