package com.hubery.formatter.my;

public class SelectElementsWrapperBuilder {
    private final String COMMA_DELIMITER = ", ";
    private final int asLen;
    private final int maxLineLen;
    private final String nextLinePrefix;
    StringBuilder sb = new StringBuilder();
    StringBuilder line = new StringBuilder();

    public SelectElementsWrapperBuilder(int asLen, int maxLineLen, String nextLinePrefix) {
        this.asLen = asLen;
        this.maxLineLen = maxLineLen;
        this.nextLinePrefix = nextLinePrefix;
    }

    public String getText() {
        if (line.length() > 0) {
            sb.append(line);
        }
        //删除最后一个,
        if (line.length() > 0) {
            sb.delete(sb.length() - COMMA_DELIMITER.length(), sb.length());
        }
        return sb.toString();
    }

    public void addText(String selectAsItem) {
        if (selectAsItem.length() > asLen
                || line.length() + selectAsItem.length() > maxLineLen
                || selectAsItem.indexOf("SELECT") > 0) {
            sb.append(line).append(selectAsItem.indexOf("SELECT") > 0 ? "\n" : "").append(nextLinePrefix);
            line.delete(0, line.length());
        }
        line.append(selectAsItem).append(COMMA_DELIMITER);
    }
}
