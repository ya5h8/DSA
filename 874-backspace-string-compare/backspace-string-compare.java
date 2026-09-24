import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch != '#'){
                stackS.push(ch);
            }else if(!stackS.isEmpty()){
                stackS.pop();
            }
        }
        
        for(char ch : t.toCharArray()){
            if(ch != '#'){
                stackT.push(ch);
            }else if(!stackT.isEmpty()){
                stackT.pop();
            }
        }
        
        return stackS.equals(stackT);
    }
}
