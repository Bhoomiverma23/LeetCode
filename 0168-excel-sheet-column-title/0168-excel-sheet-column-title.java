class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder ans = new StringBuilder();
        while(columnNumber>0){
            columnNumber--;
            int r = columnNumber%26;
            ans.append((char)(r+'A'));
            columnNumber=columnNumber/26;
        }
        return ans.reverse().toString();
    }
}