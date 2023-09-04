

package finalProject;

import java.util.Iterator;
import java.util.Scanner;


public class Driver {
	static Scanner myScan = new Scanner(System.in);
	static DictionaryInterface<String, String> myProfile = new HashedDictionary<>();
	static UndirectedGraph<String> myGraph = new UndirectedGraph<>();
	
	static String jen = "Jen";
	static String joe = "Joe";
	static String jon = "Jon";
	static String huu = "Age: 24 yrs old, phone: 555-999-6666, location: Los Gatos";
	
	public static void Profile() {
		
		String huu = "Huu";
		
		System.out.println("Your profile: ");
		myProfile.add(huu, "Huu, 24 yrs old, phone: 555-999-6666, location: Los Gatos");
		display(myProfile);
		
		System.out.println("Update your profile? Press 1: Yes and press 0: No");
		String myScan_profile = myScan.nextLine();
		if(myScan_profile.equals( "0")) {
			System.out.println("Profile: ");
			display(myProfile);
			return;}
		else {
			System.out.println("New data");
			String myScan_profile2 = myScan.nextLine();
			myProfile.add(huu, myScan_profile2);
			System.out.println("\nNew Profile:");
			display(myProfile);
			}
	
	}

	public static void Person()
	{
		
		StackInterface<String> path = new LinkedStack<>();
		DictionaryInterface<String, String> nameList = new HashedDictionary<>();
		
		System.out.println("Recommend friends:");
		System.out.println("#1: Jen, 24 yrs old, 555-888-9999");
		System.out.println("#2: Joe, 25 yrs old, 555-888-9977");
		System.out.println("#3: Jon, 26 yrs old, 555-888-9988\n");
		
		
		//ADD PROCEDURE
		System.out.println("Add friends? yes: press: 99 OR no: press -99");
		
		int myScan0 = myScan.nextInt();
		
		while(myScan0 == 99) {
			System.out.println("Enter number to select friends or press 4 to exit: ");
			int myScan1 = myScan.nextInt();
			
			if(myScan1==1) {
				myGraph.addVertex(jen);
				myGraph.addEdge(huu, jen);
				System.out.println("\nJenny was added in your list");
				nameList.add(jen, " 24 yrs old, 555-888-9999");
			}
		
			if(myScan1==2) {
				myGraph.addVertex(joe);
				myGraph.addEdge(huu, joe);
				System.out.println("\nJoey was added in your list");
				nameList.add(joe, " 25 yrs old, 555-888-9977");
			}
		
			if(myScan1==3) {
				myGraph.addVertex(jon);
				myGraph.addEdge(huu, jon);
				System.out.println("\nJonny was added in your list");
				nameList.add(jon, " 26 yrs old, 555-888-9988");
			}
		
			if(myScan1== 4) 
				break;
		
		}
		
		
		System.out.println("\nUpdated! " + myGraph.getNumberOfVertices() + 
				"  people in your list\n");	
		System.out.println("Want to see Huu's friends? 1. Yes   2. No");
		
		int checkFriend = myScan.nextInt();
		boolean ok = true;
		if(checkFriend == 1) {
			display(nameList);	
			}
		
		
		
		//REMOVE PROCEDURE
		System.out.println("Remove friends? Press: 9 OR No changes? Press: -9");
		
		int myScan3 = myScan.nextInt();
		if(myScan3==-9) {
			System.out.println("\nUpdated! " + nameList.getSize() + 
					"  people in your list, as follows:\n");
			display(nameList);
			//break;
		}
		while (myScan3 == 9) {
			System.out.println("Enter number# to remove friends or press 4 to exit:");
			int myScan4 = myScan.nextInt();
			if(myScan4==1) {
				nameList.remove(jen);
				System.out.println("\nRemoved Jen! Current list: \n");
				display(nameList);
			}
			
			else if (myScan4==2) {
				nameList.remove(joe);
				System.out.println("\nRemoved Joe! Current list: \n");
				display(nameList);
			}
			
			else if (myScan4==3) {
				nameList.remove(jon);
				System.out.println("\nRemoved Jon! Current list: \n");
				display(nameList);
			}
		
			else if (myScan4 ==4) break;
			
			
		
//
//		System.out.println("\nUpdated! " + nameList.getSize() + 
//				"  people in your list, as follows:\n");
//		display(nameList);
		
		}
		
		
		//CHECK ONLINE PROCEDURE
		System.out.println("Check current status? 1: Yes Or 2: No");
		int checkOnl = myScan.nextInt();
		
		while(checkOnl==1) {
			
		DictionaryInterface<String, String> onlineStatus = new HashedDictionary<>();
		
		String jenStatus = "Jen";
		String joeStatus = "Joe";
		String jonStatus = "Jon";
		//onlineStatus.add(jen, "Age: 24, phone: 555-888-9999, location: San Francisco. Status: Online");
		if(nameList.contains("Jen"))
			
			onlineStatus.add(jenStatus, "Online");
		if(nameList.contains("Joe"))
			onlineStatus.add(joeStatus, "Offline");
		
		if(nameList.contains("Jon"))
			onlineStatus.add(jonStatus, "Offline");
		
		display(onlineStatus);
		System.out.println("Press 4: Exit");
		int quitChoice = myScan.nextInt();
		if(quitChoice==4)
			break;
		
		}
		
	}
	
	
	public static void main(String[] args)
	{ 
		Profile();
		Person();
	}  // end main
	
    public static void setGraphFig28_18a()
    {
      setVerticesFig28_18a(); // Graph cleared before setting vertices
      setEdgesFig28_18a();
    } 
   
   public static void checkVertexAndEdgeCount(int numberOfVertices, int numberOfEdges)
   {
      System.out.println("\nNumber of vertices = " + myGraph.getNumberOfVertices() +
                         " (should be " + numberOfVertices + ")");
      System.out.println("Number of edges = " + myGraph.getNumberOfEdges() +
                         " (should be " + numberOfEdges + ")");
   } // end checkVertexAndEdgeCount
   
//	public static void testEdgesFig28_18a()
//	{
//      // Check existing edges
//		boolean ok = true;
//		ok = checkEdge(huu, jen, ok);	
//		ok = checkEdge(huu, jon, ok);	
//		ok = checkEdge(huu, joe, ok);	
//		ok = checkEdge(jen, jon, ok);	
//		ok = checkEdge(jen, joe, ok);
//		ok = checkEdge(jon, joe, ok);
//
//      // Check some non-existing edges
//		
//		if (ok)
//			System.out.println("Yes they are friends");	
//		else 
//			System.out.println("They are not friends");
//	} // end testEdgesFig28_18a

	private static boolean checkEdge(String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (!myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if
	
		return check;
	} // end checkEdge
	
	private static boolean checkNoEdge(String vertex1, String vertex2, boolean ok)
	{
		boolean check = ok;	
	 	if (myGraph.hasEdge(vertex1, vertex2))	
	 	{
			System.out.println("hasEdge error " + vertex1 + " " + vertex2);
			check = false;
		} // end if
	
		return check;
	} // end checkNoEdge
	

//	public static void testDFS(String v)
//	{
//		System.out.println("\n\nDepth-First Traversal beginning at vertex " + v + ": ");
//		QueueInterface<String> dfs = myGraph.getDepthFirstTraversal(v);
//		
//		printQueue(dfs);
//	} // end testDFS	
//

		
	public static void setVerticesFig28_18a()
	{
		//myGraph.clear();

		myGraph.addVertex(jen);
		
		myGraph.addVertex(jon);
		myGraph.addVertex(joe);

	} // end setVerticesFig28_18a

	public static void setEdgesFig28_18a()
	{
		myGraph.addEdge(jen, joe, 1);
		myGraph.addEdge(jen, jon, 1);
		myGraph.addEdge(huu, jen, 1);
		myGraph.addEdge(huu, jon, 1);
		myGraph.addEdge(huu, joe, 1);
		myGraph.addEdge(jon, joe, 1);
	}


/* Since additions are made to the end of each edge list, 
   these lists appear as follows:
		A: B -> D -> E
		B: E
		C: B
		D: G
		E: F -> H
		F: C -> H
		G: H
		H: I
		I: F
   We can predict the BFS and DFS traversals knowing this. */
	 // end setEdgesFig28_18a
	public static void display(DictionaryInterface<String, String> dictionary){
	Iterator<String> keyIterator   = dictionary.getKeyIterator();
	Iterator<String> valueIterator = dictionary.getValueIterator();

	while (keyIterator.hasNext() && valueIterator.hasNext())
		System.out.println(keyIterator.next() + " : " + valueIterator.next());
	System.out.println();
	} // end display
	
	public static void printStack(StackInterface<String> s)
	{
		while (!s.isEmpty())
			System.out.print(s.pop() + " ");
		System.out.println();
	} // end printStack
	
	public static void printQueue(QueueInterface<String> q)
	{
		while (!q.isEmpty())
			System.out.print(q.dequeue() + " ");
		System.out.println(" Actual");
	} // end printQueue
}
