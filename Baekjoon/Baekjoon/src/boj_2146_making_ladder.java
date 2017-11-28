/*
 * boj.kr/2146 다리 만들기 문제.
 * 
 * 한 섬과 다른 섬을 잇는 다리 하나만을 만든다.
 * 
 * 그 다리의 길이는 매우 짧아야 한다.
 * 
 * 맵의 크기는 NxN
 * 
 * dfs로 맨 처음 맵을 돌면서, 섬의 갯수를 파악하고
 * 
 * bfs로 영역을 확장시킨다음 dfs로 한 번 또 돌면서 섬의 갯수 파악.
 * 
 * 섬의 갯수가 처음보다 줄어들면 이어진 것으로 추정.
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
			if(Map[nx][ny]==1) dfs(nx,ny);	// 다음 위치가 육지라면, dfs로 돌아준다.
			else if(Map[nx][ny]==0 && !v.contains(new Point(x,y))) {	// 인접 부분에 바다가 있다면,
				v.add(new Point(x,y));	// v에 해당 좌표를 넣어주고,
				Land.add(land_num);	// 라벨링을 해준다.
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
				if(!visited[i][j] && Map[i][j]==1) {	// 방문하지 않은 육지인 경우
					++land_num;	// 섬의 번호를 늘려주고, dfs로 돌면서 라벨링 및 바다에 근접한 육지를 찾아준다.
					dfs(i,j);		
				}
			}
		}
		if(land_num==1) {
			System.out.println("0");	// 섬이 하나 밖에 없다면, 0을 출력한다.
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
