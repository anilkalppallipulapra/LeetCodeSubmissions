class Solution {
    public int minFlips(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) return 0;
        int flips = 0;
        boolean bitA = (a & 1) != 0;
        boolean bitB = (b & 1) != 0;
        boolean bitC = (c & 1) != 0;
        if (bitC) {
            if (!bitA && !bitB) flips++;
        } else {
            if (bitA) flips++;
            if (bitB) flips++;
        }
        return flips + minFlips(a >> 1, b >> 1, c >> 1);
    }
}