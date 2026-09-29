class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == goal.charAt(0)) {
            boolean match = true;
            for (int j = 0; j < s.length(); j++) {
                int index = (i + j) % s.length();
                if(s.charAt(index) != goal.charAt(j)){
                    match = false;
                    break;
                }   
            }
            if(match){
                return true;
            }
        }
    }
    return false;
        
    }
}