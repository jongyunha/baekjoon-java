package 문자열;

import java.util.Scanner;

public class Str11721 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int start = 0;
        while (start < s.length() - 10) {
            System.out.println(s.substring(start, start + 10));
            start += 10;
        }
        System.out.println(s.substring(start, s.length()));
    }
}
