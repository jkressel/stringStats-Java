package bla.bla;

import java.util.Arrays;

import eu.japk.stringStats.*;

public class Test {
 public static void main(String[] args){
	 patterns at = new patterns("abcbcaabc",2);
	 System.out.println(Arrays.toString(at.least()));
	 
 }
}

