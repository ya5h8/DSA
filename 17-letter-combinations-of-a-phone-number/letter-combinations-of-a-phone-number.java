import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] KEYPAD = {
        "",     
        "",     
        "abc",  
        "def",  
        "ghi",  
        "jkl",  
        "mno",  
        "pqrs", 
        "tuv",  
        "wxyz"  
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digitChar = digits.charAt(index);
        String letters = KEYPAD[digitChar - '0'];

        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));       
            backtrack(result, digits, current, index + 1); 
            current.deleteCharAt(current.length() - 1);  
        }
    }
}
