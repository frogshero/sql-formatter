package com.hubery.formatter;

import org.junit.jupiter.api.Test;

public class StringBuilderTest {
    @Test
    public void test() {
        StringBuilder sb = new StringBuilder();
        sb.append("sadf");
        sb.append("4356");
        //sb.length==8
        sb.deleteCharAt(sb.length());
        System.out.println(sb.toString());
    }
}
