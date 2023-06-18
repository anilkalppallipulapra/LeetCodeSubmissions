class Solution:
    mod = 10**9 + 7

    def sb(self, x):
        ans = 0
        while x > 0:
            if x & 1:
                ans += 1
            x = x >> 1
        return ans

    def __init__(self):
        self.dp = [[-1] * 15 for _ in range(1 << 14)]

    def func(self, idx, nums, mask, prev):
        if idx == len(nums):
            return 1 if self.sb(mask) == len(nums) else 0

        way1 = 0

        if self.dp[mask][prev + 1] != -1:
            return self.dp[mask][prev + 1]

        if prev == -1:
            for i in range(len(nums)):
                if mask & (1 << i):
                    continue
                else:
                    newMask = mask | (1 << i)
                    way1 = (way1 + self.func(idx + 1, nums, newMask, i)) % self.mod
        else:
            for i in range(len(nums)):
                if mask & (1 << i):
                    continue
                else:
                    if nums[i] % nums[prev] == 0 or nums[prev] % nums[i] == 0:
                        newMask = mask | (1 << i)
                        way1 = (way1 + self.func(idx + 1, nums, newMask, i)) % self.mod

        self.dp[mask][prev + 1] = way1
        return self.dp[mask][prev + 1]

    def specialPerm(self, nums):
        mask = 0
        return self.func(0, nums, mask, -1) % self.mod