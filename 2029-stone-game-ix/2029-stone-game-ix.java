class Solution {
    public boolean stoneGameIX(int[] stones) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int n = stones.length;
        for (int i = 0; i < n; i++) {
            if (stones[i] % 3 == 0) {
                count0++;
            } else if (stones[i] % 3 == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        if (count0 % 2 == 0) {
            if (count1 > 0 && count2 > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Math.abs(count1 - count2) > 2) {
                return true;
            } else {
                return false;
            }
        }
    }
}