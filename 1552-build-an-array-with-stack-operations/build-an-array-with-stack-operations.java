class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> op = new ArrayList<>();
        int currentNum = 1;
        int idx = 0;

        while(idx < target.length){
            if(target[idx] == currentNum){
                op.add("Push");
                idx++;
            }else{
                op.add("Push");
                op.add("Pop");
            }
            currentNum++;
        }
        return op;
    }
}