package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class queue18258 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        LinkedList queue = new LinkedList();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String s = line.split(" ")[0];
            if (s.equals("push")) {
                int x = Integer.parseInt(line.split(" ")[1]);
                queue.add(x);
            } else if (s.equals("front")) {
                if (queue.isEmpty()) {
                    builder.append("-1\n");
                } else {
                    builder.append(queue.getFirst()).append("\n");
                }
            } else if (s.equals("back")) {
                if (queue.isEmpty()) {
                    builder.append("-1\n");
                } else {
                    builder.append(queue.getLast()).append("\n");
                }
            } else if (s.equals("size")) {
                builder.append(queue.size()).append("\n");
            } else if (s.equals("pop")) {
                if (queue.isEmpty()) {
                    builder.append("-1\n");
                } else {
                    builder.append(queue.pollFirst()).append("\n");
                }
            } else if (s.equals("empty")) {
                if (queue.isEmpty()) {
                    builder.append("1\n");
                } else {
                    builder.append("0\n");
                }
            }
        }
        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }
}
