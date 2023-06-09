class Solution:
    def largestAltitude(self, gain: List[int]) -> int: 
        n = len(gain)
        prefixSum = [0] * (n + 1)  # Initialize prefix sum array
        maxAltitude = 0

        for i in range(1, n + 1):
            prefixSum[i] = prefixSum[i - 1] + gain[i - 1]
            maxAltitude = max(maxAltitude, prefixSum[i])

        return maxAltitude