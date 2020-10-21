package lc468;

class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() == 0) {
            return "Neither";
        }
        String s = String.valueOf(IP.charAt(IP.length() - 1));
        String[] splitIP = IP.split("\\.");
        if (splitIP.length == 4) {
            if (!isValidate(s, 4)) {
                return "Neither";
            }
            for (int i = 0; i < 4; i++) {
                if (!isValidate(splitIP[i], 4)) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else {
            if (!isValidate(s, 6)) {
                return "Neither";
            }
            splitIP = IP.split(":");
            if (splitIP.length == 8) {
                for (int i = 0; i < 8; i++) {
                    if (!isValidate(splitIP[i], 6)) {
                        return "Neither";
                    }
                }
                return "IPv6";
            } else {
                return "Neither";
            }
        }
    }

    public boolean isValidate(String s, int version) {
        if (version == 4) {
            try {
                int i = Integer.parseInt(s);
                if ((i != 0 && s.charAt(0) == '0') || (s.length() != 1 && i == 0)) {
                    return false;
                }
                return i <= 255 && i >= 0;
            } catch (Exception e) {
                return false;
            }
        } else {
            int sLen = s.length();
            s = s.toLowerCase();
            if (sLen > 4 || sLen <= 0) {
                return false;
            } else {
                for (int i = 0; i < sLen; i++) {
                    char sc = s.charAt(i);
                    if (!((sc >= '0' && sc <= '9') || (sc >= 'a' && sc <= 'f'))) {
                        return false;
                    }
                }
                return true;
            }
        }
    }
}