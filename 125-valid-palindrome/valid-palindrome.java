class Solution {
    public boolean isPalindrome(String s) {
        String completelyJoined = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] chars = completelyJoined.toCharArray();

        int left = 0;
        int right = chars.length -1;
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
           left++;
           right--;

        }
       return true;
    }
}