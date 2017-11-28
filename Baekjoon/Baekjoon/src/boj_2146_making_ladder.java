/*
 * boj.kr/2146 �ٸ� ����� ����.
 * 
 * �� ���� �ٸ� ���� �մ� �ٸ� �ϳ����� �����.
 * 
 * �� �ٸ��� ���̴� �ſ� ª�ƾ� �Ѵ�.
 * 
 * ���� ũ��� NxN
 * 
 * dfs�� �� ó�� ���� ���鼭, ���� ������ �ľ��ϰ�
 * 
 * bfs�� ������ Ȯ���Ų���� dfs�� �� �� �� ���鼭 ���� ���� �ľ�.
 * 
 * ���� ������ ó������ �پ��� �̾��� ������ ����.
 */
import java.util.Scanner;
import java.util.Vector;
import java.awt.Point;


public class boj_2146_making_ladder {
	
	private static int N;
	private static int Map[][];
	private static boolean visited[][];
	private static int xx[] = {-1,1,0,0};
	private static int yy[] = {0,0,-1,1};
	private static Vector<Point> v = new Vector<>();
	private static Vector<Integer> Land = new Vector<>();
	private static int land_num;
	
	public static void dfs(int x,int y) {
		if(visited[x][y]) return;
		visited[x][y]=true;
		
		for(int i=0;i<4;i++) {
			int nx = x+xx[i];
			int ny = y+yy[i];
			if(nx<0 || ny<0 || nx>N-1 || ny>N-1) continue;
			if(Map[nx][ny]==1) dfs(nx,ny);	// ���� ��ġ�� �������, dfs�� �����ش�.
			else if(Map[nx][ny]==0 && !v.contains(new Point(x,y))) {	// ���� �κп� �ٴٰ� �ִٸ�,
				v.add(new Point(x,y));	// v�� �ش� ��ǥ�� �־��ְ�,
				Land.add(land_num);	// �󺧸��� ���ش�.
			}
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				Map[i][j]=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && Map[i][j]==1) {	// �湮���� ���� ������ ���
					++land_num;	// ���� ��ȣ�� �÷��ְ�, dfs�� ���鼭 �󺧸� �� �ٴٿ� ������ ������ ã���ش�.
					dfs(i,j);		
				}
			}
		}
		if(land_num==1) {
			System.out.println("0");	// ���� �ϳ� �ۿ� ���ٸ�, 0�� ����Ѵ�.
			return;
		}
		int min = 10000;
		
		for(int i=0;i<v.size();i++) {
			for(int j=i+1;j<v.size();j++) {
				if(Land.get(i)==Land.get(j)) continue;
				else {
					int distance = Math.abs(v.get(i).x - v.get(j).x)+Math.abs(v.get(i).y - v.get(j).y) - 1;
					//System.out.printf("land (from : %d,to : %d), distance : %d\n", Land.get(i),Land.get(j),distance);
					if(min>distance) min = distance;
				}
			}
		}
		System.out.println(min);
	}
}
