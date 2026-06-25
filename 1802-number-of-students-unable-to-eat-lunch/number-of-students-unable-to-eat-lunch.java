import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }
        
        int sandwichIndex = 0;
        int consecutiveRejections = 0;
        
        while (!studentQueue.isEmpty() && consecutiveRejections < studentQueue.size()) {
            int currentStudent = studentQueue.peek();
            int currentSandwich = sandwiches[sandwichIndex];
            
            if (currentStudent == currentSandwich) {
                studentQueue.poll();
                sandwichIndex++;
                consecutiveRejections = 0; 
            } else {
                studentQueue.add(studentQueue.poll());
                consecutiveRejections++;
            }
        }
        
        return studentQueue.size();
    }
}
