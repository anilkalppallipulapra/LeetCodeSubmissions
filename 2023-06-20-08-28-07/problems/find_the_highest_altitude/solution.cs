public class Solution {
    public int LargestAltitude(int[] gain) {
        int n = gain.Length;
        int[] prefixSum = new int[n + 1];
        int maxAltitude = 0;

        for (int i = 1; i <= n; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + gain[i - 1];
            if (prefixSum[i] > maxAltitude)
            {
                maxAltitude = prefixSum[i];
            }
        }

        return maxAltitude;
    }
}