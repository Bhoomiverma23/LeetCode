class Solution {
    public String reverseWords(String s) {
        String reversed = new StringBuilder(s.trim()).reverse().toString();
        String[] words = reversed.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i != words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}