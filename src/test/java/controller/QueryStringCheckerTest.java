package controller;

import com.example.weblab2.web.controller.request.QueryStringChecker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueryStringCheckerTest {
    @Test
    @DisplayName("Строка подходит1")
    public void test1() {
        String q = "x=1&y=1&r=1&type=%22only_r%22";
        assertTrue(new QueryStringChecker().check(q));
    }

    @Test
    @DisplayName("Строка подходит2")
    public void test2() {
        String q = "x=1&y=1&r=1&type=%22full%22";
        assertTrue(new QueryStringChecker().check(q));
    }

    @Test
    @DisplayName("Строка подходит3")
    public void test3() {
        String q = "x=%2212312%22&y=%22vova%22&r=1&type=%22full%22";
        assertTrue(new QueryStringChecker().check(q));
    }

    @Test
    @DisplayName("Строка не подходит1")
    public void test4() {
        String q = "x=1&y=1&r=1&type=%22only_%22";
        assertFalse(new QueryStringChecker().check(q));
    }

    @Test
    @DisplayName("Строка не подходит2")
    public void test5() {
        String q = "x=1&y=1&r=1&type=full%22";
        assertFalse(new QueryStringChecker().check(q));
    }

    @Test
    @DisplayName("Строка не подходит3")
    public void test6() {
        String q = "x=%2212312%22&y=%22vova%22&r=1";
        assertFalse(new QueryStringChecker().check(q));
    }
}
