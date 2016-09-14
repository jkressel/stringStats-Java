package eu.japk.stringStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class specifiedNumber extends stringStats {
	
	String[] less;
	 int total;
		String[] equal;
	 String[] greater;
	
	
	public specifiedNumber(String input, int number){
	ArrayList<String> charsEqual = new ArrayList<String>();
	ArrayList<String> charsGreater = new ArrayList<String>();
	ArrayList<String> charsLess = new ArrayList<String>();
	List<String> arrTemp;
	int currentMax = 1;
	int currentMaxSave = 1;
	int totalChars = 1;
	int charCount = 0;
	int used = 0;
	int maxNum = number;
	
	arrTemp = new ArrayList<String>(Arrays.asList(input.split("")));
	arrTemp.sort(null);
	charsLess.add(arrTemp.get(0));
	
	
	if ((maxNum == 1 || maxNum <1) || (!(arrTemp.size() > 0))){
		less = new String[1];
		equal = new String[1];
		greater = new String[1];
		less[0] = "No input";
		greater[0] = "No input";
		equal[0] = "No input";
		total = 0;
		return;
		
	}
	
for (int i = 1; i <arrTemp.size(); i++) {


		
		if (arrTemp.get(i).equals(arrTemp.get(i-1))){
			// Increment current max if current item in array is equal to previous
			currentMax++;
		
			
			if (currentMax == maxNum) {
				// Add current item to the equal array if current max is equal to the specified number
				charsEqual.add(arrTemp.get(i));
				

			
			}
			else if(currentMax > maxNum && used == 0) { 
				used = 1; // Make sure that an item is added no more than once to the array
				charsGreater.add(arrTemp.get(i));
				currentMaxSave = currentMax;
			}
		}else{
			used = 0; // Reset used indicator so that current item can be added to more than if needed
			
				// Remove item from Less Than array if current max is greater than or equal to max number
			if (currentMax >= maxNum) charsLess.remove(charsLess.size()-1);
				// Remove item from equal array if current max is greater than max number
			if (currentMax > maxNum) charsEqual.remove(charsEqual.size()-1);
			// If only one of each, add to equal array, else, start new cycle by adding to the less than array
			
			if (maxNum == 1) charsEqual.add(arrTemp.get(i)); else charsLess.add(arrTemp.get(i));

			//Reset current max; increment total
			currentMax = 1;
			totalChars++;

		}
	
	
		};
		
		// Various checks for last item
				
				if (currentMax >= maxNum) charsLess.remove(charsLess.size() -1);
				
				if (currentMax > maxNum) charsEqual.remove(charsEqual.size() -1);
				
				if (currentMax > maxNum + 1) charsGreater.remove(charsGreater.size() -1);

				// Check output is valid
			
				if (charsLess.size() == 0) charsLess.add("No matches");
			
				if (charsEqual.size() == 0) charsEqual.add("No matches");
				
				if (charsGreater.size() == 0) charsGreater.add("No matches");
				
				less = new String[charsLess.size()];
				equal = new String[charsEqual.size()];
				greater = new String[charsGreater.size()];
				less = (String[]) charsLess.toArray(less);
				equal = (String[]) charsEqual.toArray(equal);
				greater = (String[]) charsGreater.toArray(greater);
				total = totalChars;

	
	
	
	
	}
	
	public String[] Equal(){
		return equal;
	}
	public String[] Less(){
		return less;
	}
	public String[] Greater(){
		return greater;
	}
	public int Total(){
		return total;
	}
}
