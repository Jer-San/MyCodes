import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> tChars = new HashMap<>();
        HashMap<Character, Integer> sChars = new HashMap<>();

        for (char c : t.toCharArray()) {
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);
        }

        int left = 0, matched = 0, minLen = Integer.MAX_VALUE, startIdx = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            sChars.put(rightChar, sChars.getOrDefault(rightChar, 0) + 1);

            if (tChars.containsKey(rightChar) && sChars.get(rightChar).equals(tChars.get(rightChar))) {
                matched++;
            }
            while (matched == tChars.size()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }
                char leftChar = s.charAt(left);
                sChars.put(leftChar, sChars.get(leftChar) - 1);
                
                if (tChars.containsKey(leftChar) && sChars.get(leftChar) < tChars.get(leftChar)) {
                    matched--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIdx, startIdx + minLen);
    }
}
