class Solution {
    public int maxProduct(int n) {
        int max1 = 0;
        int max2 = 0;
        while(n>0){
            int product = n%10;
            n/=10;
            if (product>= max1) {
                max2 = max1;
                max1 = product;
            } else if (product > max2) {
                max2 = product;
            }
        }
        return max1*max2;
    }
}