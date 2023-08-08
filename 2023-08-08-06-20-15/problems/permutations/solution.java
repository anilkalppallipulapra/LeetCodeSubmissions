class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutations(new ArrayList<>(), nums, result);
        return result;
    }

    private void generatePermutations(List<Integer> currentPermutation, int[] remainingNums, List<List<Integer>> result) {
        if (remainingNums.length == 0) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        
        for (int i = 0; i < remainingNums.length; i++) {
            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(remainingNums[i]);

            int[] newRemaining = new int[remainingNums.length - 1];
            for (int j = 0, k = 0; j < remainingNums.length; j++) {
                if (j != i) {
                    newRemaining[k++] = remainingNums[j];
                }
            }

            generatePermutations(newPermutation, newRemaining, result);
        }
    }
}