import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        // Fill tMap with the frequency of characters in t
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int have = 0, need = tMap.size(); // `need` is the number of unique characters in `t`
        int minLen = Integer.MAX_VALUE, resultStartIndex = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);

            if (tMap.containsKey(c) && sMap.get(c).equals(tMap.get(c))) {
                have++; // We count `have` only when the exact match occurs
            }

            // Try to shrink the window when `have` == `need`
            while (have == need) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    resultStartIndex = start;
                }

                // Remove the leftmost character
                char leftChar = s.charAt(start);
                sMap.put(leftChar, sMap.get(leftChar) - 1);

                if (tMap.containsKey(leftChar) && sMap.get(leftChar) < tMap.get(leftChar)) {
                    have--; // If a necessary character is removed, reduce `have`
                }

                start++;
            }

            end++;
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(resultStartIndex, resultStartIndex + minLen);
    }
}
