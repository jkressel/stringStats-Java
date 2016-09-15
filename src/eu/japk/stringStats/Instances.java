/*********Copyright (c) 2016 John Kressel

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

***********/

package eu.japk.stringStats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Instances extends stringStats {
	
	private int instancesFinal = 0;
	public Instances(String input, String charToCheck, boolean words){
		
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
