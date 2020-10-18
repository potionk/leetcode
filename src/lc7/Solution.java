package lc7;

class Solution {
    public int reverse(int x) {
        long result;
        if (x < 0) {
            result = Long.parseLong("-" + reverseString((x + "").substring(1)));
        } else {
            result = Long.parseLong(reverseString((x + "")));
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }

    public String reverseString(String s) {
        return String.valueOf(new StringBuffer().append(s).reverse());
    }
}