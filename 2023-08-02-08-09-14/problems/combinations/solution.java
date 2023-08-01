class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(
        int n, 
        int k, 
        int start, 
        List<Integer> current, 
        List<List<Integer>> result) {
        if (current.size() == k) { 
            // Make a copy of the current combination
            result.add(new ArrayList<>(current)); 
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            findCombinations(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}