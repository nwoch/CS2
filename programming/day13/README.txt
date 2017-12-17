You should copy in your graph implementation from day11 including the DiGraphReader.
You will use your graph implementation to support implementing two different path finding algorithms.
DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface.
BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files.
Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
Graph.java         - A class for a directed graph data structure
INode.java         - An interface for nodes used by IGraph instances
Node.java          - A class for a node in a graph
IEdge.java         - An interface for edges used by IGraph instances
Edge.java          - A class for an edge in a graph
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
graphfile.cs2      - A simple graph file for a basic test
DepthFirstSearcher.java - A class for searching graphs by depth first
BreadthFirstSearcher.java - A class for searching graphs by breadth first
IDict.java         - An interface for a dictionary data structure
Dict.java - A class that implements a dictionary backed by a list
DictLink.java      - A class that implements list nodes for a dictionary
IList.java         - An interface for a list implementation
DoubleLinkList.java - A class that implements a doubly-linked list. Both head and tail cells are null
IDLink.java        - An interface for the link cells in a doubly linked list
DLink.java         - A class that implements doubly-linked list nodes
IQueue.java        - An interface for a generic fixed length queue
Queue.java         - A class that represents a fixed-length array queue
OverFlowException.java - Exception for when a fixed length structure's capacity is exceeded
UnderFlowException.java - Exception for when a fixed length structure is empty
