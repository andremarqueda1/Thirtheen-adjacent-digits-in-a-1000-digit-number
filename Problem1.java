//ALLDATUM Problem #1
//Andre Marqueda	andremarqueda1@gmail.com
//Find the 13-adjacent greatest product from a list of digits

import java.io.*;
import java.util.*;


public class Main{
	public static void main(String[] args){
	
		//******Data Reading and cleaning******
		File digits = new File("digits.txt");
		Scanner input=null;
		List<Integer> digitList = new ArrayList<Integer>();
		try {
			input=new Scanner(digits);
			String FileLine;
			while (input.hasNext()){
				FileLine=input.next();
				
				System.out.println("Printing " + FileLine);
				
				//digitList.add(input.nextByte());
			}
		} catch (FileNotFoundException exception){
			exception.printStackTrace();
			System.out.println("File Not Found");
		}
		System.out.println(digitList);
		

	}
}



