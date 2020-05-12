# TSPHeuristics

Implemented the nearest neighbor and “twice around the tree” minimum spanning tree
heuristics. 
Was given starter code containing an implementation of a GUI in Java. 
One can run this through java SalesmanViewer [# vertices].

The classes Point2D and Line2D take on the role of vertices and edges,
In the SalesmanViewer class, the MST and tour are stored in two edge lists
public ArrayList<Line2D> tree;
public ArrayList<Line2D> tour;

Both algorithms fill the tour edge list with the edges that make up the tour. 
For the “twice around the tree” heuristic, implemented a graph data structure that stores all the edges of the graph (for every pair of vertices, where there is an edge whose weight is the Euclidean distance between those two points) and use it to
calculate both the minimum spanning tree and the resulting “shortcut tour.” 
Pressing the button on the GUI will cause the program to first run a (currently empty) method
to compute the MST, and then pass that information to a (currently empty) method
that computes the DFS tour. The GUI has an option for toggling whether the tree is visible.
