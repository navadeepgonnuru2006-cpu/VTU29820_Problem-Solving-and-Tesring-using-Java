class Solution {
    public int dayOfYear(String date) {
        // Parse year, month, and day from the fixed positions
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));

        // Days in each month for a non-leap year
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Adjust for leap year
        if (isLeapYear(year)) {
            daysInMonth[1] = 29;
        }

        // Sum days from previous months
        int dayOfYear = day;
        for (int i = 0; i < month - 1; i++) {
            dayOfYear += daysInMonth[i];
        }

        return dayOfYear;
    }

    private boolean isLeapYear(int year) {
        // A year is a leap year if it is divisible by 4, 
        // except for end-of-century years which must be divisible by 400.
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
