import java.util.Scanner;


public class boj_1991_Tree_Traversal {
	
	private static int N;
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		String temp = sc.next();
		
		int next=0;
		
		for(int i=0;i<3;i++) {
			System.out.printf("%c ",temp.charAt(2));
		}
	}
}
