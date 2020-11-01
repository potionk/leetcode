package lc151;

class Solution {
    public String reverseWords(String s) {
        String[] split=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=split.length-1; i>=0; i--){
            if(split[i].length()!=0){
                sb.append(split[i]+" ");
            }
        }
        return sb.toString().trim();
    }
}