package lc42;

class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int[] rightMax = new int[height.length];
        int[] leftMax = new int[height.length];
        int max = height[0];
        leftMax[0] = max;
        for (int i = 1; i < len; i++) {
            leftMax[i] = (max = Math.max(max, height[i]));
        }
        max = height[len - 1];
        rightMax[len - 1] = max;
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = (max = Math.max(max, height[i]));
        }
        int answer = 0;
        for (int i = 0; i < len; i++) {
            int wall = Math.min(rightMax[i], leftMax[i]);
            if (height[i] < wall) {
                answer += wall - height[i];
                height[i] = wall;
            }
        }
        return answer;
    }
}