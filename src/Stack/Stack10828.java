package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Stack10828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            if (line.equals("push")) {
                stack.push(sc.nextInt());
            }

            if (line.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(stack.peek()).append("\n");
                }
            }

            if (line.equals("size")) {
                sb.append(stack.size()).append("\n");
            }

            if (line.equals("empty")) {
                sb.append(stack.isEmpty() ? 1 : 0).append("\n");
            }

            if (line.equals("pop")) {
                if (stack.empty()) {
                    sb.append("-1\n");
                } else {
                    int pop = stack.pop();
                    sb.append(pop).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

}
