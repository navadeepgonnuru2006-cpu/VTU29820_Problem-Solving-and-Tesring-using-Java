class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Total days count starting from known reference date: Jan 1, 1971 (Friday)
        int totalDays = 0;

        // 1. Add days for all full years passed since 1971
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // 2. Add days for all full months passed in the current year
        for (int m = 0; m < month - 1; m++) {
            if (m == 1 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += daysInMonth[m];
            }
        }

        // 3. Add remaining days in the current month
        totalDays += day - 1;

        // Since Jan 1, 1971 was a Friday (index 5 in our array):
        int dayIndex = (5 + totalDays) % 7;

        return daysOfWeek[dayIndex];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
