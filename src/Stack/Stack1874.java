package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Stack1874 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<String> solution(int n, LinkedList<Integer> numbers) {
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        int count = 1;
        while (!numbers.isEmpty()) {
            if (stack.isEmpty()) {
                stack.push(count++);
                answer.add("+");
            } else {
                int last = stack.peek();
                int first = numbers.getFirst();
                if (last == first) {
                    numbers.removeFirst();
                    stack.pop();
                    answer.add("-");
                } else {
                    if (count > n) {
                        return null;
                    }
                    stack.push(count++);
                    answer.add("+");
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }

        List<String> result = solution(n, numbers);
        if (result == null) {
            System.out.println("NO");
        } else {
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

}
