class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxpile = 0;
        for (int pile : piles) {
            if (maxpile < pile) {
                maxpile = pile;
            }
        }
        
        int left = 1;
        int right = maxpile;
        int answer = maxpile;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; 
            
            long totalHours = 0;
            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid; 
            }
            
            if (totalHours <= h) {
                answer = mid;      
                right = mid - 1;   
            } else {
                left = mid + 1;    
            }
        }
        
        return answer;
    }
}
