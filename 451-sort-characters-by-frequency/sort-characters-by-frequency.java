import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch,map.get(ch)+1);
            }
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        chars.sort((a,b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for(char ch : chars){
            int count = map.get(ch);
            for(int i = 0; i < count; i++){
                sb.append(ch);

            }
        }
        return sb.toString();
    }
}