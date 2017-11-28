// น้มุ 9466น๘

import java.util.*;

public class boj_9466 {

	private static int arr[];
	private static int people;
	private static boolean visited[];
	private static int total;
	
	public static void dfs(int cur,int parent) {
		if(visited[cur]) {
			if(parent==cur);
			else {
				arr[parent]=0;
				total=1;
			}
			return;
		}
		visited[cur]=true;
		total++;
		dfs(arr[cur],parent);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			total=0;
			people = sc.nextInt();
			arr = new int[people+1];
			visited = new boolean[people+1];
			for(int i=1;i<=people;i++)
				arr[i] = sc.nextInt();
			
			for(int i=1;i<=people;i++) 
				if(!visited[i]) dfs(i,i);
			
			System.out.println(people-total);
		}
	}
}
