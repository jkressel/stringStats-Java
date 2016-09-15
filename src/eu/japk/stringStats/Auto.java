/*********Copyright (c) 2016 John Kressel

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

***********/
package eu.japk.stringStats;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Auto extends stringStats {
 String[] charsFinalArr;
 int finalMax;
 int finalLeast;
 String[] leastFinalArr;
 int totalCharsFinal;


    public Auto(String input, boolean words, boolean caseUpper){
        ArrayList<String> chars = new ArrayList<String>();
        int maxNum =1;
        int currentMax = 1;
        String arr[];
        List<String> arrTemp;
        int totalChars = 1;
        int lowestNumber = 1;
        int init = 0;
        ArrayList<String> least = new ArrayList<String>();

        if (words){
            String tempInput = input.replaceAll("\\s+", " ");
            tempInput = tempInput.replaceAll("[^a-zA-Z0-9]+"," ");
            
            arrTemp = new ArrayList<String>(Arrays.asList(tempInput.split(" ")));
            

        }else {
            String tempInput = input;
            
            arrTemp = new ArrayList<String>(Arrays.asList(tempInput.split("")));
            
            if (caseUpper){
            	for (int count = 0; count < arrTemp.size(); count++){
            		arrTemp.set(count, arrTemp.get(count).toUpperCase());
            	}
        }else{
        	for (int count = 0; count < arrTemp.size(); count++){
        		arrTemp.set(count, arrTemp.get(count).toLowerCase());
        	}
        }
        }
        arr = new String[arrTemp.size()];
        arrTemp.sort(null);
       arr = (String[]) arrTemp.toArray(arr);
       least.add(arr[0]);
       chars.add(arr[0]);
       System.out.println(arr.length);
       
       if ((input.length() == 0)){
    	   
    	   
    		charsFinalArr = new String[1];
    		leastFinalArr = new String[1];
    		charsFinalArr[0] = "No input";
    		leastFinalArr[0] = "No input";
    		finalMax = 0;
    		finalLeast = 0;
    		totalCharsFinal = 0;
    		return;
       }
       
       for (int i = 1; i<arr.length;i++){
    	  
    	   if (arr[i].equals(arr[i-1])){
    		   currentMax++;
    		  
    		   
    		   if (currentMax == maxNum) {
   				
   				chars.add(arr[i]); // If Current Max number is the same as the all time max, add item to the modal array
   				

   			}else if(currentMax > maxNum) {
   				/****** If Current Max is greater than max, set max equal to current max and reset modal array, adding current element ********/
   				maxNum = currentMax;
   				
   				chars.clear();
   				chars.add(arr[i]);
   				
   				
   		}	
    	   }else{
   			
   			
   			if (maxNum ==1){
   				chars.add(arr[i]);
   				// If max is 1, then all get added to the modal array
   			}

   			if (currentMax < lowestNumber && init == 1) { 
   			/****** If current max is less than lowest 
   			number and is not the first time, 
   			add current element to least array *******/
   				least.clear();
   				least.add(arr[i -1]);
   				/****** If current max is equal to lowest number and is not first time, add previous item to array ******/
   			}else if(currentMax == lowestNumber && init ==1){
   				least.add(arr[i-1]);
   			}
   			lowestNumber = (lowestNumber > currentMax) ? currentMax : lowestNumber;

			// Ensure that lowest number has a base reference to the first group in the array
			
			if (init != 1){
			init =1;
			lowestNumber = currentMax;
			}	
			currentMax = 1;
			totalChars++;

		}
	
	};
	if (chars.size() == arr.length || totalChars*maxNum == arr.length) {
		chars.clear();
		chars.add("No mode");
	}
	if (least.size() == arr.length || totalChars*maxNum == arr.length) {
		least.clear();
		least.add("No least used");
	}else{
	if (lowestNumber > currentMax){
		least.clear();
		least.add(arr[arr.length -1]);
	}
	if (lowestNumber == currentMax){
		least.add(arr[arr.length -1]);
	}
}
	
	
	charsFinalArr = new String[chars.size()];
	leastFinalArr = new String[least.size()];
	charsFinalArr = (String[]) chars.toArray(charsFinalArr);
	leastFinalArr = (String[]) least.toArray(leastFinalArr);
	finalMax = maxNum;
	finalLeast = lowestNumber;
	totalCharsFinal = totalChars;
	
	
       }
    
    public String[] mode(){
    	return charsFinalArr;
    }
    public String[] least(){
    	return leastFinalArr;
    }
    public int maxNumber(){
    	return finalMax;
    }
    public int lowestNumber(){
    	return finalLeast;
    }
    public int total(){
    	return totalCharsFinal;
    }
    }

