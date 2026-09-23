class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currsum = 0;
        for(int start = 0; start < nums.length; start++){
            currsum += nums[start];
            maxsum = Math.max(currsum, maxsum);
            if(currsum < 0){
                currsum = 0;
            }
        }
        return maxsum;
        
    }
}