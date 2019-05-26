package Application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Find cycle in directed graph");
		System.out.println("----------------------------");
		
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the number of nodes in the graph");
			int numberOfNodes = scanner.nextInt();
			Graph graph = new Graph(numberOfNodes);
			for(int index = 0; index < numberOfNodes; index++) {
				System.out.println("Enter the number of adjacent vertices for this vertex"
						+ " "+(index));
				int adjVertexCount = scanner.nextInt();
				for(int adjVertexIndex = 0; adjVertexIndex < adjVertexCount; adjVertexIndex++) {
					System.out.println("Enter the adjacent matrix");
					graph.SetEdge(index, scanner.nextInt());
				}
			}
			graph.FindIfGraphHasCycle();
		}catch(Exception exception) {
			System.out.println("Thrown exception is "+exception.getMessage());
		}
	}
}
