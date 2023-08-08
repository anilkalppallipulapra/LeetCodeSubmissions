class Solution {
     public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] digitToLetters = {
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        List<String> result = new ArrayList<>();
        generateCombinations(digits, 0, "", result, digitToLetters);
        return result;
    }

    private void generateCombinations(
            String digits, int index, String current, List<String> result, String[] digitToLetters) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        int digit = digits.charAt(index) - '2';
        String letters = digitToLetters[digit];

        for (int i = 0; i < letters.length(); i++) {
            generateCombinations(digits, index + 1, current + letters.charAt(i), result, digitToLetters);
        }
    }
}