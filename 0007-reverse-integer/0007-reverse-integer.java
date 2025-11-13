public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        int x1 = 123;
        int x2 = -123;
        int x3 = 120;
        int x4 = 1534236469; // Example that overflows, should return 0

        System.out.println("Input: " + x1 + " -> Output: " + sol.reverse(x1)); // Output: 321
        System.out.println("Input: " + x2 + " -> Output: " + sol.reverse(x2)); // Output: -321
        System.out.println("Input: " + x3 + " -> Output: " + sol.reverse(x3)); // Output: 21
        System.out.println("Input: " + x4 + " -> Output: " + sol.reverse(x4)); // Output: 0 (overflow)
    }
}

class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;   // Extract the last digit
            x /= 10;            // Remove the last digit

            // Check for overflow and underflow before adding the new digit
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0; // Overflow
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0; // Underflow
            }

            rev = rev * 10 + pop; // Append the digit
        }
        return rev;
    }
}
