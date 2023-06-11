class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1; // left boundary for binary search
        int right = maxSum; // right boundary for binary search
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = calculateSum(n, index, mid);

            if (sum <= maxSum) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;

    }
    private long calculateSum(int n, int index, int value) {
        long leftSum = calculateTriangleSum(
            value - 1, Math.min(index, value - 1));
        long rightSum = calculateTriangleSum(
            value - 1, Math.min(n - index - 1, value - 1));

        long sum = (long) value + leftSum + rightSum;

        if (index >= value)
            sum += index - value + 1;
        if (n - index - 1 >= value)
            sum += n - index - value;

        return sum;
    }

    private long calculateTriangleSum(int base, int height) {
        return (long) height * (base - height + 1) + (long) height * (height - 1) / 2;
    }
}