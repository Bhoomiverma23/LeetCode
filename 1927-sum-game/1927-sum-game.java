class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftsum = 0;
        int rightsum = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0 ; i<n/2 ; i++){
            if(num.charAt(i) == '?'){
                count1++;
            }
            else{
                leftsum += num.charAt(i)-'0';
            }
        }
        for(int i = n/2 ; i<n ; i++){
            if(num.charAt(i) == '?'){
                count2++;
            }
            else{
                rightsum += num.charAt(i)-'0';
            }
        }
        int totalcount = count1+count2;
        if(totalcount % 2 == 1){
            return true;
        }
        return 2 * (leftsum - rightsum) != 9*(count2-count1);
    }
}