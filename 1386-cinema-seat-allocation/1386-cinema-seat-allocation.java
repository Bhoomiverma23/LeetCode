import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowSeats = new HashMap<>();

        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            rowSeats.put(row, rowSeats.getOrDefault(row, 0) | (1 << col));
        }

        int totalFamilies = (n - rowSeats.size()) * 2;

        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);

        for (int mask : rowSeats.values()) {
            boolean leftAvailable = (mask & leftMask) == 0;
            boolean rightAvailable = (mask & rightMask) == 0;
            boolean middleAvailable = (mask & middleMask) == 0;

            if (leftAvailable && rightAvailable) {
                totalFamilies += 2;
            } else if (leftAvailable || rightAvailable || middleAvailable) {
                totalFamilies += 1;
            }
        }

        return totalFamilies;
    }
}