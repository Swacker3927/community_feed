package org.fastcampus.common;

import java.time.LocalDate;

public class TimeCalculator {
    private TimeCalculator() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDate getDateDaysAgo(int daysAgo) {
        LocalDate currDate = LocalDate.now();
        return currDate.minusDays(daysAgo);
    }
}
