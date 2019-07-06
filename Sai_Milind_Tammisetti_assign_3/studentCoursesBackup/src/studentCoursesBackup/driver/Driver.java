package studentCoursesBackup.driver;

import  studentCoursesBackup.util.Results;
import  studentCoursesBackup.util.MyLogger;
import  studentCoursesBackup.util.FileProcessor;
import  studentCoursesBackup.util.TreeBuilder;
import  studentCoursesBackup.myTree.Node;
    
/**
 * @author Sai Milind Tammisetti
 *
 */
    
    public class Driver {
	
	public static void main(String[] args) {
	    
	    /*
	     * As the build.xml specifies the arguments as argX, in case the
	     * argument value is not given java takes the default value specified in
	     * build.xml. To avoid that, below condition is used
	     */

	    // FIXME: update this if statement for this assignment
	    if ( (args.length != 5) || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")|| args[3].equals("${arg3}")|| args[4].equals("${arg4}")) {
		    
		    System.err.println("Error: Incorrect number of arguments. Program accepts 6 argumnets.");
		    System.exit(0);
	    } // end of if
	    
	  	String inputf = args[0];
		String outputf1 = args[1];
		String outputf2 = args[2];
		String outputf3 = args[3];
		String Debug = args[4];
	    
	    int dbglvl = Integer.parseInt(Debug);

		if(dbglvl <0 || dbglvl > 4){
			System.out.println("Enter proper dbg option from 1 to 4 \n");
			System.out.println("0:RELEASE, 1:SHOW ERROR IF ENCOUNTERED, 2:SHOW RESULT TO STDOUT 3:PRINT WHEN CHANGE IN STATE 4:PRINT WHENEVER CONSTRUCTOR IS CALLED \n");
			System.exit(0);
		}
		else {

			obj.setDebugValue(dbglvl);
			System.out.println("debug level set to "+dbglvl);
		}

		String input;
		ArrayList<String> store = new ArrayList<>();
		FileProcessor fp = new FileProcessor(inputf);
		while ((input = fp.readLine()) != null) {
			{
				store.add(input);
			}
		}

		ArrayList<Node> node = new ArrayList<>();
		TreeBuilder trees = new TreeBuilder(0);
		int size = store.size();
		for(int i=0; i<size; i++){
			Node nodes = new Node();
			node.add(nodes);
		}

		for(int i=0; i<store.size(); i++){
			String str;
			str = store.get(i);
			String [] mystr = str.split(":");
			Node check = new Node();
				int elem = Integer.parseInt(mystr[0]);
				check = trees.returnTreeList().get(0).SearchNode(elem);
				if(check == null){
					node.get(i).newNode(elem, mystr[1]);
					trees.returnTreeList().get(0).insert(node.get(i));
					Node bkpnode1 = node.get(i).clone(elem, mystr[1]);
					Node bkpnode2 = node.get(i).clone(elem, mystr[1]);
					trees.returnTreeList().get(1).insert(bkpnode1);
					trees.returnTreeList().get(2).insert(bkpnode2);
					node.get(i).registerObs(bkpnode1);
					node.get(i).registerObs(bkpnode2);
				} else {
					check.update(check, mystr[1]);
				}
				//System.out.println(mystr[j]);
			}

		Results res1 = new Results(outputf1);
		trees.returnTreeList().get(0).inorderRec(res1);
		res1.writeResults();
		res1.closeMyFile();
		Results res2 = new Results(outputf2);
		trees.returnTreeList().get(1).inorderRec(res2);
		res2.writeResults();
		res2.closeMyFile();
		Results res3 = new Results(outputf3);
		trees.returnTreeList().get(2).inorderRec(res3);
		res3.writeResults();
		res3.closeMyFile();

	}  // end public static void main
    }  // end public class Driver
