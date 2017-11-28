import java.util.Scanner;

public class boj_7576 {

	static int N,M;
	static int Tomato[][];
	static boolean visited[][];
	static final int empty = -1;
	static final int tomato = 1;
	static final int non_tomato = 0;
	static final int WALL = 9999;
	static int total_tomato;
	static int day;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		Tomato = new int[N+2][M+2];
		visited = new boolean[N+2][M+2];
		int j;
		
		for(int i=0;i<=N+1;i++) {
			for(j=0;j<=M+1;j++) {
				if(i==0 || i==N+1) Tomato[i][j] = WALL;
			}
			if(j==0 || j==M+1) Tomato[i][j]= WALL;
		}
		
		
		for(int i=1;i<=N;i++) {
			for(j=1;j<=M;j++) {
				Tomato[i][j] = sc.nextInt();
				if(Tomato[i][j]==tomato) {
					total_tomato++;
					visited[i][j]=true;
				}
				}
		}
		while(total_tomato==N*M) {
			bfs()
		}
		
		
	}
}
