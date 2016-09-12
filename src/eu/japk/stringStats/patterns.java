package eu.japk.stringStats;

import java.util.ArrayList;
import java.util.List;

public class patterns extends stringStats {
	 String[] charsFinalArr;
	 int finalMax;
	 int finalLeast;
	 String[] leastFinalArr;
	 
	
	public patterns(String input, int numberLength) {
		int maxNum = 1;
		int currentMax = 1;
		int totalChars = 1;
		int lowestNumber = 1;
		int init = 0;
		int patternLength;
		List<String> arrTemp;
		ArrayList<String> chars = new ArrayList<String>();
		ArrayList<String> least = new ArrayList<String>();
		
		if ((!(numberLength > 1)) || input.equals(null)){
			charsFinalArr = new String[1];
    		leastFinalArr = new String[1];
    		charsFinalArr[0] = "No input";
    		leastFinalArr[0] = "No input";
    		finalMax = 0;
    		finalLeast = 0;
    		
    		return;
		}
		
		String[] tempArr = new String[input.length()];
		tempArr = input.split("");
		arrTemp = new ArrayList<String>();
		for (int i = 0; i < tempArr.length - numberLength; i++){
			int numToIncrease = 1;
			String tempStr = tempArr[i];
			while (numToIncrease < numberLength){
			tempStr += tempArr[i + numToIncrease];
			numToIncrease++;
			}
		
			
			arrTemp.add(tempStr);
			
		}
		arrTemp.sort(null);
		chars.add(arrTemp.get(0));
		least.add(arrTemp.get(0));
		
		for (int i = 1; i <arrTemp.size(); i++) {

			// If current item is equal to the previous
			if (arrTemp.get(i).equals( arrTemp.get(i-1))){
				currentMax++;
				
				// If current max equals max number, add item to modal array
				if (currentMax == maxNum) {
					
					chars.add(arrTemp.get(i));
					

				// If current max is greater than the max number, reset modal array and change the max number
				}else if(currentMax > maxNum) {
					
					maxNum = currentMax;
					
					chars.clear();;
					chars.add(arrTemp.get(i));
				
			}	
			}else{
				
				if (maxNum == 1) chars.add(arrTemp.get(i)); // Add all items to modal array

				// Lowest number greater than current max and not first time, reset least array
				if (currentMax < lowestNumber && init == 1) {
					least.clear();
					least.add(arrTemp.get(i));

				// Current max equals lowest number and not the first time, add to least array
				}else if(currentMax == lowestNumber && init ==1){
					least.add(arrTemp.get(i));
				}
				
				// Check if lowest number is correct
				lowestNumber = (lowestNumber > currentMax) ? currentMax : lowestNumber;

				// If first time, set to 1
				
				
				if (init == 0){
					init =1; 
					lowestNumber = currentMax;
				}
				
				currentMax = 1;
				totalChars++;

			}
		
		};
		
		if (chars.size() == arrTemp.size() || totalChars*maxNum == arrTemp.size()) {
			chars.clear();
			chars.add("No mode");
		}
		if (least.size() == arrTemp.size() || totalChars*maxNum == arrTemp.size()) {
			least.clear();
			least.add("No least used");
		}else{
		if (lowestNumber > currentMax){
			least.clear();
			least.add(arrTemp.get(arrTemp.size() -1));
		}
		if (lowestNumber == currentMax){
			least.add(arrTemp.get(arrTemp.size() -1));
		}
	}
		
		charsFinalArr = new String[chars.size()];
		leastFinalArr = new String[least.size()];
		charsFinalArr = (String[]) chars.toArray(charsFinalArr);
		leastFinalArr = (String[]) least.toArray(leastFinalArr);
		finalMax = maxNum;
		finalLeast = lowestNumber;
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
}
