package eu.japk.stringStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class instances extends stringStats {
	
	private int instancesFinal = 0;
	public instances(String input, String charToCheck, boolean words){
		
		List<String> arrTemp;
		String arr[];
		int charCount =0;
		int failed = 0;
		
		if (words){
            String tempInput = input.replaceAll("\\s+", " ");
            tempInput = tempInput.replaceAll("[^a-zA-Z0-9]+"," ");
            
            arrTemp = new ArrayList<String>(Arrays.asList(tempInput.split(" ")));
            

        }else {
            String tempInput = input;
            
            arrTemp = new ArrayList<String>(Arrays.asList(tempInput.split("")));
            
            
        }
		arr = new String[arrTemp.size()];
        arrTemp.sort(null);
       arr = (String[]) arrTemp.toArray(arr);
       
       if (arr.length == 0 || charToCheck.equals("")){
    	   return;
       }
       for (int i = 0; i <arr.length; i++){
			if (charToCheck.equals(arr[i])) charCount++; else failed++;
			
		}
        instancesFinal = charCount;
		
	}
	
	public int instances(){
		return instancesFinal;
	}
}
