/**
 *Aditya Gand  Period 3
 * Time Taken: 30 minutes
 *Comments: This lab got me really confused. I tried to emulate the
 *the sample program with the first column aligned to the left but
 *I could not get the exact image without violating some of the
 *requirements. So I did what I assumed to be correct, I did not
 *align the first column to the left, and now the picture looks
 *exactly the same. The lab should state if it wants things aligned
 *or not(in opinion).
 *
 */

import java.util.Scanner;

public class GroceryList {

	double list1;
	double list2;
	double list3;
	double list4;
	double list5;
	Scanner in = new Scanner(System.in);

    public GroceryList() {
    }


    public void ask(){
    	System.out.print("Enter item #1: ");
    	list1 = in.nextDouble();
 		System.out.print("Enter item #2: ");
    	list2 = in.nextDouble();
    	System.out.print("Enter item #3: ");
    	list3 = in.nextDouble();
    	System.out.print("Enter item #4: ");
    	list4 = in.nextDouble();
    	System.out.print("Enter item #5: ");
    	list5 = in.nextDouble();
    	}

    public void printList(){
    	System.out.printf("%10s", "Item:");
    	System.out.printf("%10s", "Cost:");
    	System.out.printf("%10s", "Total:");
    	System.out.println();
		//item1
    	System.out.printf("%10s", "   #1");
    	System.out.printf("%10.2f", list1);
		System.out.printf("%10.2f", list1);
		System.out.println();
		//item2
		System.out.printf("%10s", "#2");
    	System.out.printf("%10.2f", list2);
		System.out.printf("%10.2f", list1 + list2);
		System.out.println();
		//item3
		System.out.printf("%10s", "#3");
    	System.out.printf("%10.2f", list3);
		System.out.printf("%10.2f", list1 + list2 + list3);
		System.out.println();
		//item4
		System.out.printf("%10s", "#4");
    	System.out.printf("%10.2f", list4);
		System.out.printf("%10.2f", list1 + list2 + list3 + list4);
		System.out.println();
		//item5
		System.out.printf("%10s", "#5");
    	System.out.printf("%10.2f", list5);
		System.out.printf("%10.2f", list1 + list2 + list3 + list4 + list5);
		System.out.println();
    }
}