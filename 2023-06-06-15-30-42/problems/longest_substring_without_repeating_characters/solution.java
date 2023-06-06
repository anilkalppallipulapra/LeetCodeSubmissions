class Solution {
    public int lengthOfLongestSubstring(String s) {
       if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            if (charMap.containsKey(currentChar)) {
                start = Math.max(start, charMap.get(currentChar) + 1);
            }

            charMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength; 
    }
}