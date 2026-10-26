class Solution {
    public int reverse(int x) {
        int no = 0;

        while(x != 0){
            int lastdigit = x % 10;

            if(no > Integer.MAX_VALUE / 10 || (no == Integer.MAX_VALUE && lastdigit > 7)){
                return 0;
            }

            if(no < Integer.MIN_VALUE / 10 || (no == Integer.MIN_VALUE/10 && lastdigit < -8)){
                return 0;
            }

            no = no * 10 + lastdigit;
            x = x / 10;  
        }
        return no;
    }
}