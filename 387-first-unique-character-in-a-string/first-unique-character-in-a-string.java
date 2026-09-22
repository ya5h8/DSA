class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] c = s.toCharArray();
        for(char ch : c){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch, map.get(ch)+1);

            }
        } 
         for(int i = 0; i < s.length(); i++){ 
            if(map.get(s.charAt(i)) == 1){ 
                return i; 
            } 
        } 
        
        return -1; 
    }
}