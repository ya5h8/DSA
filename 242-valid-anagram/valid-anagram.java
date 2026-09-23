class Solution {
    public boolean isAnagram(String s, String t) {
        s= s.toLowerCase();
        t= t.toLowerCase();
        char[] ch = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch);
        Arrays.sort(ch2);
        if(Arrays.equals(ch,ch2)){
            return true;
        }else{
            return false;
        }

        
    }
}