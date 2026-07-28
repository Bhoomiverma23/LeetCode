class Solution {
    public String smallestPalindrome(String s) {
      int n = s.length();
      int mid = n/2;
      char ch[] = s.toCharArray();
      Arrays.sort(ch,0,mid);
      for(int i = 0 ; i<mid ; i++){
        ch[n-1-i] = ch[i];
      }  
      return new String(ch);
    }
}