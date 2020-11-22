package lc1410;

class Solution {
    public String entityParser(String text) {
        char[] textArr = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        int len = textArr.length;
        for (int i = 0; i < len; i++) {
            if (textArr[i] == '&') {
                StringBuilder mark = new StringBuilder();
                mark.append(textArr[i]);
                while (i + 1 < len) {
                    i++;
                    mark.append(textArr[i]);
                    if (textArr[i] == ';') {
                        break;
                    }
                }
                String markStr = mark.toString();
                switch (markStr) {
                    case "&quot;":
                        sb.append("\"");
                        break;
                    case "&apos;":
                        sb.append("\'");
                        break;
                    case "&amp;":
                        sb.append("&");
                        break;
                    case "&gt;":
                        sb.append(">");
                        break;
                    case "&lt;":
                        sb.append("<");
                        break;
                    case "&frasl;":
                        sb.append("/");
                        break;
                    default:
                        sb.append(markStr);
                }
            } else {
                sb.append(textArr[i]);
            }

        }
        return sb.toString();
    }
}