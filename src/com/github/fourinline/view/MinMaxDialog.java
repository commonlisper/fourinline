package com.github.fourinline.view;

import java.util.Scanner;

public class MinMaxDialog implements Dialog<Integer> {
    private final String title;
    private final String error;
    private final int min;
    private final int max;
    private final Scanner scanner;

    public MinMaxDialog(String title, String error, int min, int max) {
        this.title = title;
        this.error = error;
        this.min = min;
        this.max = max;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Integer input() {
        System.out.println(title);

        while (true) {
            System.out.print("Enter integer in  range [" + min + ", " + max + "]: ");
            int answer = scanner.nextInt();

            if (answer < min || answer > max) {
                System.out.println(error);
                continue;
            }

            return answer;
        }
    }
}
