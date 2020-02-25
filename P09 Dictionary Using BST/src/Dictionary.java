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
public interface Dictionary {
	 // checks whether the dictionary is empty or not
	  public boolean isEmpty();
	  
	  // adds this word definition (word and the provided meaning) to the dictionary
	  // Returns true if the word was successfully added to this dictionary
	  // Returns false if the word was already in the dictionary
	  // Throws IllegalArgumentException if either word or meaning is null or an empty
	  // String
	  public boolean addWord(String word, String meaning);
	  
	  // Returns the meaning of the word s if it is present in this dictionary
	  // Throws a NoSuchElementException if the word s was not found in this dictionary  
	  public String lookup(String s);
	  
	  // Returns the number of words stored in this dictionary
	  public int size();
}
