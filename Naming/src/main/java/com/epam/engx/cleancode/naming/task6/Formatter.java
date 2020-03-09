package com.epam.engx.cleancode.naming.task6;

public class Formatter {

    private static final String PLUS = "+";
    private static final String PIPE = "|";
    private static final String MINUS = "-";
    private static final String UNDERSCORE = " _ ";

    public static void main(String[] args) {
        System.out.println(formatKyeValue("enable", "true"));
        System.out.println(formatKyeValue("name", "Bob"));
    }

    private static String formatKyeValue(String key, String value) {
        String content = PIPE + key + UNDERSCORE + value + PIPE + "\n";
        String frame = getFrame(content.length()).toString();
        return frame.concat(content).concat(frame);
    }

    private static StringBuilder getFrame(int repetitionsNumber) {
        StringBuilder result = new StringBuilder();
        result.append(PLUS);
        for (int i = 3; i < repetitionsNumber; i++){
            result.append(MINUS);
        }
        result.append(PLUS).append("\n");
        return result;
    }
}
