class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }

        Set<Integer> IntersectionSet = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
            IntersectionSet.add(num);
            }
        }

        int[] result = new int[IntersectionSet.size()];
        
        int index = 0;
        for(int num : IntersectionSet){
            result[index++]=num;
        }

        return result;

    }
}