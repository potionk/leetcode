package lc14;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int minLen = strs[0].length();
        int tcNum = strs.length;
        int idx = -1;
        for (int i = 0; i < minLen; i++) {
            boolean isSame = true;
            int target = strs[0].charAt(i);
            for (int j = 1; j < tcNum; j++) {
                if (target != strs[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                idx = i;
            } else {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= idx; i++) {
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}