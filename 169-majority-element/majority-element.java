class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        if (map.isEmpty()) return -1; 
        Integer maxKey = null;
        for(Integer key: map.keySet()){
                if (maxKey == null || map.get(key) > map.get(maxKey)) {
                maxKey = key;
            }

        }
        return maxKey;
        
    }
}