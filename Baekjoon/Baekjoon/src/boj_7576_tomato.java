import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.awt.Point;

public class boj_7576_tomato {
	private static int N, M; // N행 M열
	private static int Map[][];
	private static boolean visited[][];
	private static char state;
	private static int total;
	private static int xx[] = { -1, 1, 0, 0 };
	private static int yy[] = { 0, 0, -1, 1 };

	private static Queue<Point> A = new LinkedList<Point>();
	private static Queue<Point> B = new LinkedList<Point>();

	public static void bfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + xx[i];
			int ny = y + yy[i];
			if (nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1)
				continue;
			if (visited[nx][ny])
				continue;
			if (Map[nx][ny] == 0) {
				Map[nx][ny] = 1;
				visited[nx][ny] = true;
				if (state == 'A')
					A.add(new Point(nx, ny));
				else if (state == 'B')
					B.add(new Point(nx, ny));
			}
		}

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		Map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Map[i][j] = sc.nextInt();
				if (Map[i][j] == 1)
					A.add(new Point(i, j));
			}
		}

		while (!A.isEmpty() || !B.isEmpty()) {
			if(A.size()==N*M) {
				System.out.println(0);
				return;
			}
			if (B.isEmpty()) {
				while (!A.isEmpty()) { // A가 비워져 있지 않다면
					state = 'B';
					int x = A.peek().x;
					int y = A.peek().y;
					A.poll();
					bfs(x, y);
				}
			}
			else if (A.isEmpty()) {
				while (!B.isEmpty()) { // B가 비워져 있지 않다면
					state = 'A';
					int x = B.peek().x;
					int y = B.peek().y;
					B.poll();
					bfs(x, y);
				}
			}
			total++;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(Map[i][j]==0)
				{
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(total-1);
	}
}