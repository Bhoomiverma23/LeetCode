class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int count = 0;
        int len = 101; 
        String ans = ""; 
        for(int r = 0; r < s.length(); r++) {
            if(s.charAt(r) == '1'){
                count++;
            } 
            while(count == k) {
                if(len > r - l + 1) {
                    len = r - l + 1; 
                    ans = s.substring(l, r + 1); 
                } else if(len == r - l + 1) {
                    if(ans.compareTo(s.substring(l, r + 1)) > 0) {
                        ans = s.substring(l , r + 1); 
                    } 
                }
                if(s.charAt(l++) == '1'){
                    count--;
                }
            }
        }
        return ans;  
    }
}