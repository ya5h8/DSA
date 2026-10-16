class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 1;
        }
        int hlen = haystack.length();
        int nlen = needle.length();

        for(int i = 0; i <= hlen - nlen; i++){
            if(haystack.substring(i,i+nlen).equals(needle)){
            return i;
            }
        }
        return -1;

    }
}