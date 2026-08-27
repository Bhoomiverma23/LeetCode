class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int i = target.length() - 1; i >= 0; i--) {
            int cur = target.charAt(i) - 'a';
            count[cur]++;
            boolean ok = true;
            for (int x : count) {
                if (x < 0) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            int next = -1;
            for (int c = cur + 1; c < 26; c++) {
                if (count[c] > 0) {
                    next = c;
                    break;
                }
            }
            if (next == -1) continue;
            count[next]--;
            StringBuilder ans = new StringBuilder(target.substring(0, i));
            ans.append((char) ('a' + next));
            for (int c = 0; c < 26; c++) {
                while (count[c]-- > 0) {
                    ans.append((char) ('a' + c));
                }
            }
            return ans.toString();
        }
        return "";
    }
}