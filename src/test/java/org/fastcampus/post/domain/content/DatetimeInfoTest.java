package org.fastcampus.post.domain.content;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatetimeInfoTest {
    @Test
    void givenDatetimeInfo_whenUpdateEditDatetime_thenIsEditedIsTrue() {
        //  given
        DatetimeInfo datetimeInfo = new DatetimeInfo();

        //  when
        datetimeInfo.updateEditDatetime();
        boolean isEdited = datetimeInfo.isEdited();

        //  then
        assertTrue(isEdited);
    }
}
