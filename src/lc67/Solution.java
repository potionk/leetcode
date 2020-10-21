package lc67;

class Solution {
    public String addBinary(String a, String b) {
        int arrSize = Math.max(a.length(), b.length());
        boolean[] aArr = new boolean[arrSize];
        boolean[] bArr = new boolean[arrSize];
        for (int i = a.length() - 1, aIdx = 0; i >= 0; i--, aIdx++) {
            aArr[aIdx] = a.charAt(i) == '1';
        }
        for (int i = b.length() - 1, bIdx = 0; i >= 0; i--, bIdx++) {
            bArr[bIdx] = b.charAt(i) == '1';
        }
        boolean carry = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arrSize; i++) {
            result.insert(0, ((aArr[i] ^ bArr[i] ^ carry) ? "1" : "0"));
            if ((aArr[i] && bArr[i]) || (bArr[i] && carry) || (aArr[i] && carry)) {
                carry = true;
            } else {
                carry = false;
            }
        }
        if (carry) {
            result.insert(0, "1");
        }
        return result.toString();
    }
}