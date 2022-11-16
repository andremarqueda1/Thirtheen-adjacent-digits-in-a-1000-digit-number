//ALLDATUM Problem #1
//Andre Marqueda	andremarqueda1@gmail.com
//Find the 13-adjacent greatest product from a list of digits

import java.io.*;
import java.util.*;



public class Main{
	public static void main(String[] args) throws IOException{
	
		//******Data Reading, cleaning and integer conversion******
		List<Integer> digitList = new ArrayList<Integer>();
		try {
        File digitsTxt= new File("digits.txt");             //Reading the txt
		FileReader FReader = new FileReader(digitsTxt);
        BufferedReader BReader = new BufferedReader(FReader); //BReader will help us iterate digit by digit
            int nextInt=0;
            char c;
            while((nextInt=BReader.read())!=-1){ //BufferedReader will return -1 when there are no more digits left to read
                c=(char) nextInt;
                                            //By aplying an ASCII Mask ('0'), we get the Integer value of a given ASCII Character
                if (c-'0'>=0){              //Note: Since there are Line Returns (\n) on the original file, when applying 
                                            //the ASCII Mask we need to filter these "trash values". 
                digitList.add(c-'0');                    
               }
            }
		} catch (FileNotFoundException exception){
			exception.printStackTrace();
			System.out.println("File Not Found");
		}
        //******End of Data Reading, cleaning and integer conversion******
        

        //******Finding the greatest product of thirteen adjacent digits *******/
        int currentProduct=1, maxProduct=0;
        for(int i=0; i<digitList.size(); i++){
            for (int j=0; j<12;j++){
                if (i+j>digitList.size()-1){
                    break;
                }
                
                currentProduct=currentProduct*digitList.get(i+j);
            }
                if (currentProduct>maxProduct){
                    
                    maxProduct=currentProduct;
                }
                currentProduct=1;
        }
        System.out.println("The greatest product is: " + maxProduct);

	}
}



