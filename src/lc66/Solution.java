package lc66;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] == 9) {
            digits[digits.length - 1]++;
            int idx = digits.length - 1;
            while (digits[idx] == 10) {
                digits[idx] = 0;
                idx--;
                if (idx >= 0) {
                    digits[idx]++;
                } else {
                    int[] exDigits = new int[digits.length + 1];
                    System.arraycopy(digits, 0, exDigits, 1, digits.length);
                    exDigits[0] = 1;
                    return exDigits;
                }
            }
            return digits;
        } else {
            digits[digits.length - 1]++;
            return digits;
        }
    }
}