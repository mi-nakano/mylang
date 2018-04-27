package jp.mizunaka.mylang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleTest {
    @Test
    public void test() {
        assertEquals("hello", Sample.hello());
    }
}
