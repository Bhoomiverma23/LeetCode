class Solution {
    public String reverseVowels(String s) {
        StringBuilder st = new StringBuilder(s);
        int len = s.length();
        int left = 0;
        int right = len-1;
        while(left<right){
            while(left<right && !isVowel(st.charAt(left))){
                left++;
            }
            while(left<right && !isVowel(st.charAt(right))){
                right--;
            }
            char temp = st.charAt(left);
            st.setCharAt(left, st.charAt(right));
            st.setCharAt(right, temp);
            left++;
            right--;
        }
        return st.toString();
    }
    public boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}