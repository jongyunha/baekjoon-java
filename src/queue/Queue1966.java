package queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue1966 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      LinkedList<int[]> q = new LinkedList<>(); // Queue로 활용 할 연결리스트
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
      }

      int count = 0;

      while (!q.isEmpty()) {

        int[] front = q.poll();
        boolean isMax = true;

        for (int i = 0; i < q.size(); i++) {

          // 처음 뽑은 원소보다 큐에 있는 1번재 원소가 중요도가 클 경우
          if (front[1] < q.get(i)[1]) {

            // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
            q.offer(front);
            for (int j = 0; j < i; j++) {
              q.offer(q.poll());
            }

            isMax = false;
            break;
          }
        }

        // front 원소가 가장 큰 원소가 아니엿으므로 다음 반복문으로 넘어감
        if (!isMax) {
          continue;
        }

        // front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
        count++;
        if (front[0] == M) {
          break;
        }
      }
      sb.append(count).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}
