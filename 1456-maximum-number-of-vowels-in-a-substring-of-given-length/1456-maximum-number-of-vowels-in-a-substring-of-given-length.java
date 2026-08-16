class Solution {
    public boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public int maxVowels(String s, int k) {
        int len = s.length();
        int i = 0;
        int j = 0;
        int maxValue = 0;
        int count = 0;
        while(j<len){
            if(isVowel(s.charAt(j))){
                count++;
            }
            if(j-i+1==k){
                maxValue = Math.max(maxValue,count);
                if(isVowel(s.charAt(i))){
                    count--;
                }
                i++;
            }
            j++;
        }
        return maxValue;
    }
}