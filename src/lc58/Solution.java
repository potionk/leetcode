package lc58;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] splitS = s.split(" ");
        if (splitS.length == 0) {
            return 0;
        }
        return splitS[splitS.length - 1].length();
    }
}