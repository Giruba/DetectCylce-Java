package Application;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	private int numberOfVertices;
	private LinkedList<Integer> []adjacencyList;
	
	public Graph(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
		adjacencyList = new LinkedList[this.numberOfVertices];
		for(int index = 0; index < this.numberOfVertices; index++) {
			adjacencyList[index] = new LinkedList<Integer>();
		}
	}
	
	public void SetGraphVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}
	
	public void SetGraphAdjacencyList(LinkedList<Integer> []adjList) {
		this.adjacencyList = adjList;
	}
	
	public void SetEdge(int sourceVertex, int destinationVertex) {
		this.adjacencyList[sourceVertex].add(destinationVertex);
	}
	
	public int GetGraphVertices() {
		return this.numberOfVertices;
	}
	
	public LinkedList<Integer>[] GetGraphAdjacencyList(){
		return this.adjacencyList;
	}
	
	public LinkedList<Integer> GetAdjacencyListOfAVertex(int vertex){
		return this.adjacencyList[vertex];
	}
	
	public void FindIfGraphHasCycle() {
		boolean []visited = new boolean[this.numberOfVertices];
		boolean[] recursionArray = new boolean[this.numberOfVertices];
		
		for(int index = 0; index < this.numberOfVertices; index++) {
			if(HasGraphACycle(index, visited, recursionArray)) {
				System.out.println("Graph has a cycle!");
				return;
			}
		}
		System.out.println("Graph does not have a cycle!");
	}
	
	public boolean HasGraphACycle(int vertex, boolean []visited, boolean []recursionArray) {
		
		if(recursionArray[vertex]) {
			return true;
		}
		
		if(visited[vertex]) {
			return false;
		}
		
		visited[vertex] = recursionArray[vertex] = true;
		
		Iterator<Integer> adjListIterator = this.adjacencyList[vertex].iterator();
		while(adjListIterator.hasNext()) {
			if(HasGraphACycle(adjListIterator.next(), visited, recursionArray)) {
				return true;
			}
		}
		//End of recurion - set recursion entry false
		recursionArray[vertex] = false;
		
		return false;
	}
}
