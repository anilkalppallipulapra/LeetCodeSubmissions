public class Solution {
    public bool IsPalindrome(string s) {
        return s.ToLower()
        .Where(char.IsLetterOrDigit)
        .SequenceEqual(s.ToLower()
            .Where(char.IsLetterOrDigit)
            .Reverse());
    }
}