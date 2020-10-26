package lc20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sCharArray = s.toCharArray();
        int sCharArrayLen = s.length();
        for (int i = 0; i < sCharArrayLen; i++) {
            switch (sCharArray[i]) {
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    stack.push(sCharArray[i]);
            }
        }
        return stack.isEmpty();
    }
}