import java.util.ArrayList;
import java.util.NoSuchElementException;

//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           P09 Dictionary Using BST
// Files:           N/A
// Course:          CompSci 300, Spring 2019
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

public class DictionaryTests {
	public static void main(String[] args) {
		System.out.println(testAddMethod());
		System.out.println(testLookup());
		System.out.println(testSize());
		System.out.println(testHeight());
		System.out.println(testGetAllWords());
	}
	/*
	 * tests the functionality of the add method in DictionaryBST
	 * @return boolean true - if correct
	 * 				   false - if errors
	 */
	public static boolean testAddMethod() {
		//initializes parameters
		boolean test1 = true;
		boolean test1TryCatch = false;
		DictionaryBST newDict = new DictionaryBST();
		//checks if correctly returns false for an empty dictionary
		if (!newDict.isEmpty()) {
			test1 = false;
		}
		//checks if a node was successfully added to an empty dictionary
		if (newDict.addWord("famous", "to be popular") == false) {
			test1 = false;
		}
		//checks if a node was successfully added to a non-empty dictionary
		if (newDict.addWord("airplane", "zoom") == false) {
			test1 = false;
		}
		//checks if dictionary correctly returns not empty
		if (newDict.isEmpty()) {
			test1 = false;
		}
		//checks if a word can be added again
		if (newDict.addWord("airplane", "zoom")) {
			test1 = false;
		}
		//checks if an exception is thrown with empty parameters
		try {
			newDict.addWord("", "");
		} catch (IllegalArgumentException e) {
			test1TryCatch = true;
		}
		return test1 && test1TryCatch;
	}
	/*
	 * tests the functionality of the lookup method in DictionaryBST
	 * @return boolean true - if correct
	 * 				   false - if errors
	 */
	public static boolean testLookup() {
		//initializes parameters
		boolean test2 = true;
		boolean test2TryCatch = false;
		DictionaryBST newDict = new DictionaryBST();
		newDict.addWord("die", "to die");
		newDict.addWord("apple", "gross fruit");
		newDict.addWord("bug", "ew");
		newDict.addWord("cat", "fur ball");
		//checks to see if lookup returns the correct meaning of the node being searched for
		String s = newDict.lookup("cat");
		if (!s.equals("fur ball")) {
			test2 = false;
		}
		//checks if lookup is case insensitive
		String s2 = newDict.lookup("Cat");
		if (!s2.equals("fur ball")) {
			test2 = false;
		}
		//checks to see if an exception is thrown when searching for a node that
		//does not exist
		try {
			newDict.lookup("money");
		}
		catch(NoSuchElementException e) {
			test2TryCatch = true;
		}
		return test2 && test2TryCatch;
	}
	/*
	 * tests the functionality of the size method in DictionaryBST
	 * @return boolean true - if correct
	 * 				   false - if errors
	 */
	public static boolean testSize() {
		//initializes parameters
		boolean test3 = true;
		DictionaryBST newDict = new DictionaryBST();
		newDict.addWord("die", "to die");
		newDict.addWord("apple", "gross fruit");
		newDict.addWord("bug", "ew");
		newDict.addWord("cat", "fur ball");
		//receives the returned size from method
		int size = newDict.size();
		//checks if size is as expected
		if(size != 4) {
			test3 = false;
		}
		return test3;
	}
	/*
	 * tests the functionality of the height method in DictionaryBST
	 * @return boolean true - if correct
	 * 				   false - if errors
	 */
	public static boolean testHeight() {
		//initializes parameters
		boolean test4 = true;
		DictionaryBST newDict = new DictionaryBST();
		newDict.addWord("die", "to die");
		newDict.addWord("apple", "gross fruit");
		newDict.addWord("bug", "ew");
		newDict.addWord("cat", "fur ball");
		//retrieves height from method
		int height = newDict.height();
		//checks if height is as expected
		if (height != 4) {
			test4 = false;
		}
		return test4;
	}
	/*
	 * tests the functionality of the getAllWords method in DictionaryBST
	 * @return boolean true - if correct
	 * 				   false - if errors
	 */
	public static boolean testGetAllWords() {
		//initializes parameters
		boolean test5 = true;
		DictionaryBST newDict = new DictionaryBST();
		newDict.addWord("die", "to die");
		newDict.addWord("apple", "gross fruit");
		newDict.addWord("bug", "ew");
		newDict.addWord("cat", "fur ball");
		ArrayList<String> compList = new ArrayList<>();
		compList.add("apple");
		compList.add("bug");
		compList.add("cat");
		compList.add("die");
		//receives returned arraylist from method
		ArrayList<String> returnedList = newDict.getAllWords();
		//compares the arraylists
		for (int i = 0; i < returnedList.size(); i++) {
			if(!compList.get(i).equals(returnedList.get(i))) {
				return false;
			}
		}
		return test5;
	}
}
