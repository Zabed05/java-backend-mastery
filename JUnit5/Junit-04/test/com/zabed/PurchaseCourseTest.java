package com.zabed;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.learning.dao.JavaCourse;
import com.zabed.service.*;

public class PurchaseCourseTest {
    @Test
    void testProceedWithCourse() {

        PurchaseCourse pc = new PurchaseCourse();
        boolean status = pc.proceedWithCourse(new JavaCourse());
        assertTrue(status);

        // assertFalse(status);
    }
}
