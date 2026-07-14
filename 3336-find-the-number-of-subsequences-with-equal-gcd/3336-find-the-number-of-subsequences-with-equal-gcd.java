class Solution {
    int MOD=1000000007;

    public int gcd(int a,int b){
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }

    public int subsequencePairCount(int[] nums){
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int[][] dp=new int[max+1][max+1];
        dp[0][0]=1;

        for(int num:nums){
            int[][] next=new int[max+1][max+1];

            for(int g1=0;g1<=max;g1++){
                for(int g2=0;g2<=max;g2++){
                    if(dp[g1][g2]==0) continue;

                    next[g1][g2]=(next[g1][g2]+dp[g1][g2])%MOD;

                    int newG1=(g1==0)?num:gcd(g1,num);
                    next[newG1][g2]=(next[newG1][g2]+dp[g1][g2])%MOD;

                    int newG2=(g2==0)?num:gcd(g2,num);
                    next[g1][newG2]=(next[g1][newG2]+dp[g1][g2])%MOD;
                }
            }

            dp=next;
        }

        int ans=0;
        for(int g=1;g<=max;g++){
            ans=(ans+dp[g][g])%MOD;
        }
        return ans;
    }
}