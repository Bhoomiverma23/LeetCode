class Solution {
    public String reverseVowels(String s) {
        StringBuilder st = new StringBuilder();
        int len = s.length();
        for(int i = 0 ; i<len ; i++){
            if(s.charAt(i) == 'A' || s.charAt(i) ==  'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U' || s.charAt(i) == 'a' ||s.charAt(i) ==  'e' || s.charAt(i) == 'i' || s.charAt(i) ==  'o' || s.charAt(i) == 'u'){
              st.append(s.charAt(i));
            }
        }
        st.reverse();
        StringBuilder ans = new StringBuilder(s);
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' ||
                s.charAt(i) == 'I' || s.charAt(i) == 'O' ||
                s.charAt(i) == 'U' || s.charAt(i) == 'a' ||
                s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                ans.setCharAt(i, st.charAt(j));
                j++;
            }
        }
        return ans.toString();
    }
}