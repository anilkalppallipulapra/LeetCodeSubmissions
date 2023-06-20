from typing import List

class Solution:
    @staticmethod
    def kRadiusAverages(nums: List[int], k: int) -> List[int]:
        n = len(nums)
        # Initialize the output array with -1s
        avgs = [-1] * n  
        window_sum = sum(nums[:2 * k + 1])
        for i in range(k, n - k):
            window_size = 2 * k + 1
            if window_size > 0:
                avgs[i] = window_sum // window_size
            # Update the window sum by subtracting the element 
            # that goes out of the window and adding the element 
            # that comes into the window
            if i - k >= 0:
                window_sum -= nums[i - k]
            if i + k + 1 < n:
                window_sum += nums[i + k + 1]

        return avgs

    def getAverages(self, nums: List[int], k: int) -> List[int]:
        return self.kRadiusAverages(nums, k)
