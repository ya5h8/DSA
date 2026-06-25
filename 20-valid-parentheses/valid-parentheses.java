class Solution {
    public boolean isValid(String s) {
        
        char[] character = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char current : character){
            if(current == '(' || current == '{' || current == '['){
                stack.push(current);
            }
            else if(current == ')' || current == '}' || current == ']'){
                if(stack.isEmpty()){
                    return false;

                }
                char topElement = stack.peek();

                if ((current == ')' && topElement == '(') ||
                    (current == '}' && topElement == '{') ||
                    (current == ']' && topElement == '[')) {
                    
                    
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
    
