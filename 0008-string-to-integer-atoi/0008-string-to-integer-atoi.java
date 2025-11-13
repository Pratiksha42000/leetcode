class Solution {
    public int myAtoi(String s) {
        // Step 1: Handle empty string
        if (s == null || s.length() == 0) return 0;

        int i = 0, n = s.length();
        long result = 0;
        int sign = 1;

        // Step 2: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 3: Handle sign if present
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 4: Convert digits into number
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // Step 5: Check for overflow before multiplying further
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Step 6: Apply sign and return result
        result *= sign;

        // Clamp the result within 32-bit integer range
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) result;
    }
}
