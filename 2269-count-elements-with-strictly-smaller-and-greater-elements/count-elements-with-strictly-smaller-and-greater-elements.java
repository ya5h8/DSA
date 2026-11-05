class Solution {
    public int countElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            if(num < min){
                min = num;
            }
            if(num > max){
                max = num;
            }
        }
        int start = 0;
        int count = 0;
        while(start < nums.length){
            if(nums[start] < max && nums[start] > min){
                count++;
            }
            start++;

        }
        return count;
        
    }
}