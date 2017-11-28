import java.util.*;

public class boj_4963 {
	static int w,h;
	static final int earth = 1;
	static final int sea = 0;
	static final int WALL = 9999;
	static int Map[][];
	static int total;
	static int xx[] = {-1,1,0,0,-1,1,-1,1};
	static int yy[] = {0,0,-1,1,1,-1,-1,1};
	static boolean visited[][];
	
	public static void dfs(int x,int y) {
		if(visited[x][y]) return;
		if(Map[x][y]==sea) return;
		if(Map[x][y]==WALL) return;
		
		visited[x][y]=true;
				
		for(int i=0;i<8;i++) 
			dfs(x+xx[i],y+yy[i]);
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
		w = sc.nextInt();
		h = sc.nextInt();
		total = 0;
		if(w==0 && h==0) break;
		Map = new int[h+2][w+2];
		visited = new boolean[h+2][w+2];
		
		for(int i=0;i<=h+1;i++) 
			for(int j=0;j<=w+1;j++)
				Map[i][j]=WALL;
		
		for(int i=1;i<=h;i++) 
			for(int j=1;j<=w;j++)
				Map[i][j] = sc.nextInt();
		
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=w;j++) {
				if(!visited[i][j] && Map[i][j]==earth) {
					dfs(i,j);
					total++;
				}
			}
		}
		System.out.println(total);
		}
		
		
		
	}
}
