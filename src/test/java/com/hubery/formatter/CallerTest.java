package com.hubery.formatter;

public class CallerTest {
    private String javaClz =
            "public class HelloWorld {                      " +
            "   private String aa;                          " +
            "   private Test123 bb;                         " +
            "   private String mm() {                       " +
            "       return aa;                              " +
            "   }                                           " +

            "   public static void main(String[] args) {    " +
            "      System.out.println(\"Hello, World\");    " +

            "      HelloWorld hw = new HelloWorld();        " +
            "      hw.aa = \"ffffff\";                      " +
            "       System.out.println(bb.mm());            " +
            "   }                                           " +
            "}                                              ";


}
