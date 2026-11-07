class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, (map.get(num) + 1));
            }
        }
       PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a,b) -> map.get(b) - map.get(a)
       );
       
       for(int key : map.keySet()){
        pq.add(key);
       }
       int[] result = new int[k];
       for(int i =0; i < k; i++){
        result[i] = pq.poll();
       }
       return result;

    }
}