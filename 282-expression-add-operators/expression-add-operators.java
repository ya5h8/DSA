import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String num, 
                           int target, int index, long eval, long prevCalculated) {
        
        if (index == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long curr = Long.parseLong(part);
            int len = path.length();

            if (index == 0) {
                path.append(part);
                backtrack(result, path, num, target, i + 1, curr, curr);
                path.setLength(len);
            } else {
                for (char op : new char[]{'+', '-', '*'}) {
                    path.append(op).append(part);
                    
                    switch (op) {
                        case '+':
                            backtrack(result, path, num, target, i + 1, eval + curr, curr);
                            break;
                        case '-':
                            backtrack(result, path, num, target, i + 1, eval - curr, -curr);
                            break;
                        case '*':
                            backtrack(result, path, num, target, i + 1, 
                                      (eval - prevCalculated) + (prevCalculated * curr), 
                                      prevCalculated * curr);
                            break;
                    }
                    
                    path.setLength(len); 
                }
            }
        }
    }
}
