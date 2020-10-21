package lc392;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";
        String t = "ahbgdc";
        boolean result = solution.isSubsequence(s, t);
        System.out.println(result);
    }

    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        if (sArr.length == 0) {
            return true;
        }
        char[] tArr = t.toCharArray();
        int sIdx = 0;
        for (char c : tArr) {
            if (sIdx >= sArr.length) {
                break;
            }
            if (sArr[sIdx] == c) {
                sIdx++;
            }
        }
        return sArr.length == sIdx;
    }
}