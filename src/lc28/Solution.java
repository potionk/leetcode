package lc28;

class Solution {
    public int strStr(String haystack, String needle) {
        char[] haystackCharArr = haystack.toCharArray();
        char[] needleCharArr = needle.toCharArray();
        if (haystackCharArr.length == 0 && haystackCharArr.length == needleCharArr.length) {
            return 0;
        }
        for (int i = 0; i <= haystackCharArr.length - needleCharArr.length; i++) {
            boolean isFind = true;
            for (int j = 0; j < needleCharArr.length; j++) {
                if (haystackCharArr[i + j] != needleCharArr[j]) {
                    isFind = false;
                    break;
                }
            }
            if (isFind) {
                return i;
            }
        }
        return -1;
    }
}