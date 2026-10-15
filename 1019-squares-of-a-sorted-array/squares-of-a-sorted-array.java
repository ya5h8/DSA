class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int num : nums){
            if(num >= 0)
                pos.add(num);
            else
                neg.add(num);
        }
        if(neg.isEmpty()){
            int[] result = new int[pos.size()];
            for(int i = 0; i< pos.size(); i++){
                result[i] = pos.get(i) * pos.get(i);
            }
            return result;
        }
        if(pos.isEmpty()){
            int[] result = new int[neg.size()];
            for(int i = 0; i<neg.size();i++){
                result[i] = neg.get(i) * neg.get(i);
            }
            Arrays.sort(result);
            return result;
        }
        int i =0; 
        int j = 0; 
        int k =0;
        int n1= pos.size();
        int n2 = neg.size();
        int[] result = new int[n1+n2];

        for( i = 0; i<n1; i++){
            pos.set(i, pos.get(i) * pos.get(i));
        }
        for( i = 0; i<n2; i++){
            neg.set(i, neg.get(i) * neg.get(i));
        }
        Collections.reverse(neg);
        i =0;
        j=0;
        
        while(i < neg.size() && j < pos.size()){
            if(neg.get(i) <= pos.get(j)){
                result[k++] = neg.get(i++);
            }else{
                result[k++] = pos.get(j++);
            }
        }
        while(i < neg.size()){
            result[k++] = neg.get(i++);
        }
        while(j < pos.size()){
            result[k++] = pos.get(j++);
        }
        return result;
    }
}