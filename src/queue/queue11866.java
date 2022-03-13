package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class queue11866 {

    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        StringBuilder builder = new StringBuilder();
        builder.append("<");

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            int count = 0;
            while (count < k - 1) {
                int target = queue.poll();
                queue.addLast(target);
                count++;
            }
            int first = queue.poll();
            builder.append(first).append(", ");
        }
        builder.append(queue.poll()).append(">");

        bw.write(builder.toString());
        bw.flush();
        bw.close();
    }
}
