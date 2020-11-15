package lc224;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(1+(4+5+2)-3)+(6+8)";
        int result = solution.calculate(s);
        System.out.println(result);
    }

    public int calculate(String s) {
        ArrayList<String> inputList = new ArrayList<>();
        int sLen = s.length();
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (isNum(c)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(c);
                    while (i + 1 < sLen && isNum(s.charAt(i + 1))) {
                        sb.append(s.charAt(i + 1));
                        i++;
                    }
                    inputList.add(sb.toString());
                } else {
                    inputList.add(c + "");
                }
            }
        }
        return calPrefix(toPostfix(inputList));
    }

    public boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public String[] toPostfix(ArrayList<String> input) {
        Stack<String> result = new Stack<>();
        Stack<String> operator = new Stack<>();
        int inputLen=input.size();
        for (int i = 0; i < inputLen; i++) {
            switch (input.get(i)) {
                case "+":
                case "-":
                    while (!operator.isEmpty() && !operator.peek().equals("(")) {
                        result.push(operator.pop());
                    }
                    operator.push(input.get(i));
                    break;
                case "(":
                    operator.push(input.get(i));
                    break;
                case ")":
                    while (!operator.peek().equals("("))
                        result.push(operator.pop());
                    operator.pop();
                    break;
                default:
                    result.push(input.get(i));
            }
            if (i == inputLen - 1) {
                while (operator.size() != 0)
                    result.push(operator.pop());
            }
        }
        Object[] result2Array = result.toArray();
        String[] output = new String[result2Array.length];
        for (int i = 0; i < result2Array.length; i++) {
            output[i] = result2Array[i]+"";
        }
        return output;
    }

    public static int calPrefix(String[] output) {
        Stack<Integer> stack = new Stack<>();
        for (String c : output) {
            int b;
            int a;
            switch (c) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                default:
                    stack.push(Integer.parseInt(c));
            }
        }
        return stack.get(0);
    }
}