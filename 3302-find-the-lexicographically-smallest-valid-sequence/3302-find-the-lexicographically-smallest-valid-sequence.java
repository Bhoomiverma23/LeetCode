class Solution{
    public int[] validSequence(String word1,String word2){
        int n=word1.length();
        int m=word2.length();

        int[] suf=new int[n+1];
        int j=m-1;

        for(int i=n-1;i>=0;i--){
            if(j>=0&&word1.charAt(i)==word2.charAt(j)){
                j--;
            }
            suf[i]=j+1;
        }

        int[] ans=new int[m];
        int k=0;
        boolean used=false;

        for(int i=0;i<n&&k<m;i++){
            if(word1.charAt(i)==word2.charAt(k)){
                ans[k]=i;
                k++;
            }
            else if(!used&&suf[i+1]<=k+1){
                ans[k]=i;
                k++;
                used=true;
            }
        }

        if(k==m)return ans;
        return new int[0];
    }
}