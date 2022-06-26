package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author jongyunha created on 22. 4. 8.
 */
public class Queue1021 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer token = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());

        LinkedList<Integer> circularQueue = new LinkedList<>();
        LinkedList<Integer> bucket = new LinkedList<>();
        LinkedList<Integer> targets = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < n; i++) {
            circularQueue.add(i + 1);
        }

        token = new StringTokenizer(br.readLine());
        while (token.hasMoreTokens()) {
            int temp = Integer.parseInt(token.nextToken());
            bucket.add(temp);
        }

        Integer target = bucket.pollFirst();

        while (target != null) {
            if (circularQueue.getFirst() == target) {
                circularQueue.pollFirst();
                target = bucket.pollFirst();
                continue;
            }

            int idx = circularQueue.indexOf(target);
            if (circularQueue.size() / 2 >= idx) {
                circularQueue.addLast(circularQueue.pollFirst());
            } else {
                circularQueue.addFirst(circularQueue.pollLast());
            }
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
