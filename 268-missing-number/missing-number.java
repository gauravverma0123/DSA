class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length+1;
        int excepted=n*(n-1)/2;
        int sum=0;
        for(int i=0;i<n-1;i++){
            sum += nums[i];
        }
        return excepted-sum;
    }
}