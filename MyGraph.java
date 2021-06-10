/*
 * MyGraph Project 
 * Gurumanpreet Singh
 * Project #6
 * CMSC 256-901 Spring 2020
 * This program reads in a graph from a file and does various operations
 */
package cmsc256;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyGraph<V> extends UnweightedGraph<V> {

	public MyGraph() {
		
	}
	
	/*
	 * This constructor makes a graph from the vertices array and edges array
	 */
	public MyGraph(V[] vertices, int[][] edges) {
		super(vertices,edges);
	}
	
	/*
	 * This constructor makes a graph from a vertices list and edges list
	 */
	public MyGraph(List<V> vertices, List<Edge> edges) {
		super(vertices,edges);
	}
	
	/*
	 * This constructor makes a graph from a list of edges and vertices
	 */
	public MyGraph(List<Edge> edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	
	/*
	 * This constructor makes a graph from an array of edges and 3 vertices
	 */
	public MyGraph(int[][] edges, int numberOfVertices) {
		super(edges, numberOfVertices);
	}
	
	/*
	 * This method returns a boolean true or false whether the graph is connected or 
	 * not connected.
	 */
	public boolean isGraphConnected(String fileName) throws FileNotFoundException {
		if(fileName == null) { 		//return false if the file is null
			return false;
		}
		
		Scanner scan = null;
		//creating the vertices and edges arraylists
		ArrayList<Integer> vertices = new ArrayList<>(); 
		ArrayList<Edge> edges = new ArrayList<>();
		
		try {
			scan = new Scanner(new File(fileName));
		}catch (Exception e) {
			throw new FileNotFoundException("File not found");
		}
		
		int numberOfVertices;
		numberOfVertices = scan.nextInt();
		
		scan.nextLine();
		for(int i=0; i<numberOfVertices; i++) {
			Scanner input = new Scanner(scan.nextLine());
			int vertex = input.nextInt();
			vertices.add(vertex);
			while(input.hasNextInt()) {
				edges.add(new Edge(vertex, input.nextInt()));
			}
			input.close();
		}
		scan.close();
		if(numberOfVertices == 1) {
			return false;
		}
		//instance of UnweightedGraph
		UnweightedGraph<Integer> graph = new UnweightedGraph<>(vertices,edges);
		graph.printEdges();		//displays all edges
		if(graph.dfs(0).getNumberOfVerticesFound() == numberOfVertices) {
			return true;
		}else if(graph.dfs(0).getNumberOfVerticesFound() == 1) {	
			throw new NumberFormatException();
		}else {
			return false;
		}
	}

	/*
     * This method returns a list of the connected components of the graph
     * Each element in the list is another list that contains the vertices for that connected part
     */
    public List<List<Integer>> getConnectedComponents(){
    	boolean[] traversed = new boolean[vertices.size()];		//creates the array
    	List<List<Integer>> pairs = new ArrayList<>();		//creates an arraylist for the connected components
    	for (int i = 0; i < vertices.size(); i++) {
    	    if(!traversed[i]) {
    	    	List<Integer> traverseList = getConnectedComponents(i, traversed);		//compiling the list of components
    	    	Collections.sort(traverseList);		//sorting the list
    	    	pairs.add(traverseList);		//compiling into one list
    	    }
    	}
    	return pairs;
    	
    }
    
    /*
     * This method returns a list of the connected components of the graph
     * Each element in the list is another list that contains the vertices for that connected part
     */
    public List<Integer> getConnectedComponents(int v, boolean[] covered) {
    	List<Integer> searchOrder = new ArrayList<Integer>();
    	LinkedList<Integer> stack = new LinkedList<>();
    	stack.push(v);   	
    	while(!stack.isEmpty()) {		//loop runs while the stack is not empty
    		int top = stack.pop();		//stores the top value (v)
    		if(!covered[top]) {
    			searchOrder.add(top);
			    covered[top] = true;
			    for (int i : getNeighbors(top)) {
			    	if (!covered[i]) {
			    		stack.push(i);
			    	}
			    }
		    }
    	}
    	return searchOrder;
    }
    
    /*
     * This method returns a List<Integer> that contains all the vertices in a path
     * from u to v in order
     * If there is no path from u to v, the method returns null
     */
    public List<Integer> getPath(int u, int v){
    	SearchTree tree = bfs(u);
    	ArrayList<Integer> path = new ArrayList<>();
    	if(u == v) {
    		path.add(u);
    		return path;
    	}
    	
    	if(tree.getParent(v) == -1) {
    		return null;
    	}
    	while (v != -1) {
    		path.add(v);
    		v = tree.getParent(v);
    		System.out.println(v);
    		System.out.println(path);
    	}
    	Collections.reverse(path);
    	return path;
    }
    
    /*
     * This method determines if there is a cycle in the graph 
     * Returns true if there is a cycle in this instance of MyGraph 
     */
    public boolean isCyclic() {
    	for (int i = 0; i < vertices.size(); i++) {
    		if(isCyclic(i)) {
    			return true;
    		}
    	}
    	return false;
    }
    private boolean isCyclic(int v) {
    	List<Integer> searchOrder = new ArrayList<Integer>();
    	int[] parent = new int[vertices.size()];
    	for (int i = 0; i < parent.length; i++) {
    		parent[i] = -1;
    	}
    	boolean[] isVisited = new boolean[vertices.size()];
    	return isCyclic(v, v, parent, searchOrder, isVisited);
    }
    private boolean isCyclic(int first, int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
    	searchOrder.add(v);
    	isVisited[v] = true;
    	for (int i : getNeighbors(v)) {
    		if (!isVisited[i]) {
    			parent[i] = v;
    			int[] newParent = Arrays.copyOf(parent, parent.length);
    			boolean[] newIsVisited = Arrays.copyOf(isVisited, parent.length);
    			@SuppressWarnings("unchecked")
				List<Integer> newSearchOrder = (List<Integer>) ((ArrayList<Integer>)searchOrder).clone();
    			if(isCyclic(first, i, newParent, newSearchOrder, newIsVisited)) {
    				return true;
    			}
    		} 
    		else if(first == i) {
    			if(searchOrder.size() > 2) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    /*
     * This method finds a cycle in the graph that starts at vertex u
     * Returns a list that contains all the vertices in a cycle starting from u
     * Returns null if there is no cycle in this instance of MyGraph 
     */
    public List<Integer> findCycle(int u){
    	List<Integer> searchOrder = new ArrayList<Integer>();
    	int[] parent = new int[vertices.size()];
    	boolean[] isVisited = new boolean[vertices.size()];
    	for (int i = 0; i < parent.length; i++) {
    		parent[i] = 1;
    	}
    	
    	return findCycle(u, u, parent, searchOrder, isVisited);
    }
    private List<Integer> findCycle(int first, int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited) {
    	searchOrder.add(v);
    	isVisited[v] = true;
    	for (int i : getNeighbors(v)) {
    		if (!isVisited[i]) {
    			parent[i] = v;
    			int[] newParent = Arrays.copyOf(parent, parent.length);
    			boolean[] newIsVisited = Arrays.copyOf(isVisited, parent.length);
    			@SuppressWarnings("unchecked")
    			List<Integer> newSearchOrder = (List<Integer>) ((ArrayList<Integer>)searchOrder).clone();
    			List<Integer> result = findCycle(first, i, newParent, newSearchOrder, newIsVisited);
    			if(result != null) {
    				return result;
    			}
    		} 
    		else if(first == i) {
    			if(searchOrder.size() > 2) {
    				return searchOrder;
    			}
    		}
    	}
    	return null;
    }  
  
}
