class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int leftpointer = 0  ;
        int rightpointer = n-1;
        int maxArea = 0;
        while(leftpointer<rightpointer){
            int length = Math.min(height[leftpointer],height[rightpointer]);
            int breadth = rightpointer-leftpointer;
            int area = length * breadth;
            maxArea = Math.max(maxArea,area); 
            if (height[leftpointer] < height[rightpointer]) {
                leftpointer++;
            } else {
                rightpointer--;
            }    
        }
        return maxArea;
    }
}