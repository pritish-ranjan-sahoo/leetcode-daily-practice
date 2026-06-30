class Solution {
    public int myAtoi(String str) {
        String s = str.trim();
        if (s == null || s.length()==0) return 0;

        int i = 0, n = s.length();
        int sign = 1;
        char c = s.charAt(i);
        if (c == '+' || c == '-') {
            sign = (c == '-') ? -1 : 1;
            i++;
        }
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';
            if (res > max / 10 ||
               (res == max / 10 && d > max % 10)) {
                return sign == 1 ? max : min;
            }
            res = res * 10 + d;
            i++;
        }
        return sign * res;
    }
}
