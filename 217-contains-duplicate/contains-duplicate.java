class Solution {
    public boolean containsDuplicate(int[] nums) {
       Set<Integer> set1 = new HashSet<>();
       for(int num : nums){
        if(!set1.contains(num)){
            set1.add(num);
        }else{
            return true;
        }
       }
       return false;
    }
}