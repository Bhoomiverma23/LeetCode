class Solution {
    public boolean isAlphaNumeric(char ch){
        ch = Character.toLowerCase(ch);
        if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z')) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!isAlphaNumeric(s.charAt(start))) {
                start++;
                continue;
            }
            if (!isAlphaNumeric(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}