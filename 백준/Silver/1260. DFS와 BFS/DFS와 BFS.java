import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] link;
	static boolean[] visited;
	static int M;
	static int N;
	static int V;
	static Queue<Integer> queue = new LinkedList<>();

	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		link = new int[N + 1][N + 1];


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			link[x][y] = 1;
			link[y][x] = 1;
		}

		visited = new boolean[N + 1];
		dfs(V);
		sb.replace(sb.length() - 1, sb.length(), "");

		sb.append("\n");

		visited = new boolean[N + 1];
		bfs(V);


		System.out.println(sb.replace(sb.length() - 1, sb.length(), ""));

	}

	public static void dfs(int start) {

		sb.append(start).append(" ");
		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (link[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int start) {

		sb.append(start).append(" ");
		visited[start] = true;

		for (int i = 1; i <= N; i++) {
			if (link[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			bfs(queue.poll());
		}
	}

}


