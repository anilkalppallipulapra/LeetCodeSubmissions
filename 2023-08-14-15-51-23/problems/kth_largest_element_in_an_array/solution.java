class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            } else if (pivotIndex < k - 1) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1; // Return an appropriate value if k is out of bounds
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] >= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}