package io;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public String getUserInputURL() {
        System.out.print("URL> ");
        return sc.nextLine();
    }
}
