class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int: 
        return self.quick_select(nums, 0, len(nums) - 1, k - 1)

    def partition(self, nums, low, high):
        pivot = nums[high]
        i = low - 1
        
        for j in range(low, high):
            if nums[j] >= pivot:
                i += 1
                nums[i], nums[j] = nums[j], nums[i]
        
        nums[i + 1], nums[high] = nums[high], nums[i + 1]
        return i + 1

    def quick_select(self, nums, low, high, k):
        if low <= high:
            pivot_index = self.partition(nums, low, high)
            
            if pivot_index == k:
                return nums[pivot_index]
            elif pivot_index < k:
                return self.quick_select(nums, pivot_index + 1, high, k)
            else:
                return self.quick_select(nums, low, pivot_index - 1, k)