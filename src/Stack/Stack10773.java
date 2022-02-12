package Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack10773 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int solution(List<Integer> nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        List<Integer> inputs = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            inputs.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(solution(inputs));
    }

}
