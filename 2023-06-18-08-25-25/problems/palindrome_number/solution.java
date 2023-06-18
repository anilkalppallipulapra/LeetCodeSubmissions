class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) { 
            return false;
        } else {
            int temp = x;
            int rever = 0;
            while (temp > 0) {
                rever = rever * 10 + temp % 10;
                temp /= 10;
            }
            return rever == x;
        }
    }
}