This directory contains the java source files for a data structure representing Lists. A list is a data structure for holding an arbitrary sequence of items. Linked lists and array lists are two common ways to implement lists.

You should implement an array list with class name ArrayList
You should implement a singlely linked list with name SingleLinkList
You should implement a doublely linked list with name DoubleLinkList

Files:
IList.java  - An interface for lists based on the list operations from the 11/29 lecture
ISLink.java - An interface that your link cells for SingleLinkList must implement
IDLink.java - An interface that your link cells for DoubleLinkList must implement
SLink.java  - A class that implements singlely-linked list nodes
DLink.java  - A class that implements doubly-linked list nodes
ArrayList.java - A class that implement a List backed by an array that is resized as needed
SingleLinkList.java - A class that implement a singlely-linked list. Head cell is null; tail cell contains a value
DoubleLinkList.java - A class that implement a doubly-linked list. Both head and tail cells are null
Test.java   - A fairly good but incomplete test suite (e.g. insert is not tested well)
TestFailedException.java - An exception thrown when a test failure is detected
