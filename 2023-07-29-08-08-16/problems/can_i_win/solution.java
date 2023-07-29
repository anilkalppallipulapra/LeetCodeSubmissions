class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        
        Map<Integer, Boolean> memo = new HashMap<>();
        int chosen = 0;
        return canWin(maxChoosableInteger, desiredTotal, chosen, memo);
    }
    
    private boolean canWin(
        int maxChoosableInteger, 
        int desiredTotal, 
        int chosen, 
        Map<Integer, Boolean> memo) {
        if (desiredTotal <= 0) {
            return false;
        }
        
        if (memo.containsKey(chosen)) {
            return memo.get(chosen);
        }
        
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            // Check if the number i is not chosen yet            
            if ((chosen & mask) == 0) {             
                int newChosen = chosen | mask;
                if (!canWin(
                    maxChoosableInteger, 
                    desiredTotal - i, 
                    newChosen, 
                    memo)) {
                    memo.put(chosen, true);
                    return true;
                }
            }
        }
        
        memo.put(chosen, false);
        return false;
    }
}