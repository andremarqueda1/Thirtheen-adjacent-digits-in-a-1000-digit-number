//ALLDATUM Problem #1
//Andre Marqueda	andremarqueda1@gmail.com
//Find the 13-adjacent greatest product from a list of digits

import java.io.*;
import java.util.*;

public class Problem1{
	public static void main(String[] args) throws IOException{
	
		        //******DATA READING, CLEANING AND INTEGER CONVERSION******

		List<Integer> digitList = new ArrayList<Integer>();
		try {
        File digitsTxt= new File("digits.txt");             //Opening the file
		FileReader FReader = new FileReader(digitsTxt);
        BufferedReader BReader = new BufferedReader(FReader); //BReader will iterate digit by digit
            int nextInt=0;
            char c;
            while((nextInt=BReader.read())!=-1){ //BufferedReader will return -1 when there are no more digits left to read
                c=(char) nextInt;
                                            //By aplying an ASCII Mask ('0'), we can get the Integer value of a given ASCII Character
                if (c-'0'>=0){              //Note: Since there are Line Returns (\n) on the original file, when applying 
                                            //the ASCII Mask we need to filter these "trash values". 
                digitList.add(c-'0');                    
               }
            }
		} catch (FileNotFoundException exception){
			exception.printStackTrace();
			System.out.println("File Not Found");
		}
                //******END OF DATA READING, CLEANING AND INTEGER CONVERSION******
        

                //******FINDING THE GREATEST PRODUCT*******/
        int currentProduct=1, maxProduct=0;
        List<Integer> greatestProductDigits = new ArrayList<Integer>(); //This list will store the digits that comprise the greatest product
        for(int i=0; i<digitList.size(); i++){
            for (int j=0; j<12;j++){                                    //By iterating the entire list, we can "pivot" the following thirteen digits
                if (i+j>digitList.size()-1){                            //This defines when we reach the last thirteen digits. 
                    break;
                }
                
                currentProduct=currentProduct*digitList.get(i+j);      
            }
                if (currentProduct>maxProduct){
                    maxProduct=currentProduct;                          //If a new greatest product is found...
                    greatestProductDigits.clear();                      //...We store the digits that comprise the multiplication
                    for (int k=0;k<12;k++){
                        greatestProductDigits.add(digitList.get(i+k));  
                    }
                }
                currentProduct=1;
        }
        System.out.println("The thirtheen digits that compose the greatest product are: " + greatestProductDigits);
        System.out.println("The greatest product is: " + maxProduct);
	}
}