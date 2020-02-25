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

public class DictionaryBST implements Dictionary {
	private DictionaryWord root;

	// This should be the only constructor of this class.
	// Creates an empty dictionaryBST.
	public DictionaryBST() {
		this.root = null;
	}

	// Methods defined in the Dictionary interface
	public boolean isEmpty() {
		// checks if the root instance is null
		if (this.root == null) {
			// if yes, there is no nodes and is empty
			return true;
		} else {
			return false;
		}
	}

	public boolean addWord(String word, String meaning) {
		// checks if word or meaning are null or empty strings
		if (word == null || word.equals("") || meaning == null || meaning.equals("")) {
			throw new IllegalArgumentException("invalid word or meaning");
		}
		// initializes a new word
		DictionaryWord newWord = new DictionaryWord(word, meaning);
		// checks if it's the first node to be added
		if (this.root == null) {
			// if yes, sets the root to the new word and leaves left and right
			// child as null
			this.root = newWord;
			return true;
		}
		// else, call addWordHelper to insert node
		return addWordHelper(newWord, this.root);
	}

	public String lookup(String s) {
		// call lookupHelped with the root to start at
		return lookupHelper(s, root);
	}

	public int size() {
		// call sizeHelper with the root to start at
		return sizeHelper(root);
	}

	// Public methods not defined in the Dictionary interface
	/**
	 * Computes and returns the height of this dictionaryBST, as the number of nodes
	 * from root to the deepest leaf DictionaryWord node.
	 * 
	 * @return the height of this Binary Search Tree counting the number of
	 *         DictionaryWord nodes
	 */
	public int height() {
		// call heightHelper with the root to start at
		return heightHelper(root);
	}

	/**
	 * Returns all the words within this dictionary sorted from A to Z
	 * 
	 * @return an ArrayList that contains all the words within this dictionary
	 *         sorted in the ascendant order
	 */
	public ArrayList<String> getAllWords() {
		// call getAllWordsHelper with the root to start at
		return getAllWordsHelper(root);
	}

	// Recursive private helper methods
	// Each public method should make call to the recursive helper method with the
	// corresponding name

	/**
	 * Recursive helper method to add newWord in the subtree rooted at node
	 * 
	 * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
	 * @param current     the current DictionaryWord that is the root of the subtree
	 *                    where newWord will be inserted
	 * @return true if the newWordNode is successfully added to this dictionary,
	 *         false otherwise
	 */
	private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
		// compare the node to be added with the current node in the tree
		// if the words are the same, return false and dont add word
		if (current.getWord().toLowerCase().compareTo(newWordNode.getWord().toLowerCase()) == 0) {
			return false;
		}
		// alphabetically compared, if current is less than the new node
		if (current.getWord().toLowerCase().compareTo(newWordNode.getWord().toLowerCase()) < 0) {
			// check if the current node has a right child
			if (current.getRightChild() == null) {
				// if no, set its right child to new node
				current.setRightChild(newWordNode);
				return true;
			}
			// if yes, make a recursive call and move down the tree
			return addWordHelper(newWordNode, current.getRightChild());
		}
		// alphabetically compared, if current is greater than the new node
		// check if the current node has a left child
		if (current.getLeftChild() == null) {
			// if no, set its left child to the new node
			current.setLeftChild(newWordNode);
			return true;
		}
		// if yes, make a recursive call and move down the tree
		return addWordHelper(newWordNode, current.getLeftChild());
	}

	/**
	 * Recursive helper method to lookup a word s in the subtree rooted at current
	 * 
	 * @param s       String that represents a word
	 * @param current pointer to the current DictionaryWord within this dictionary
	 * @return the meaning of the word s if it is present in this dictionary
	 * @throws NoSuchElementException if s is not found in this dictionary
	 */
	private static String lookupHelper(String s, DictionaryWord current) {
		// check if the current node is null meaning the word wasn't found
		if (current == null) {
			throw new NoSuchElementException("word not found");
		}
		// alphabetically compared, if current is less than the new node
		if (current.getWord().toLowerCase().compareTo(s.toLowerCase()) < 0) {
			// make a recursive call to the next node down the tree
			return lookupHelper(s, current.getRightChild());
		}
		// alphabetically compared, if current is greater than the new node
		else if (current.getWord().toLowerCase().compareTo(s.toLowerCase()) > 0) {
			// make a recursive call to the next node down the tree
			return lookupHelper(s, current.getLeftChild());
		}
		// else return the meaning at the current node
		return current.getMeaning();
	}

	/**
	 * Recursive helper method that returns the number of dictionary words stored in
	 * the subtree rooted at current
	 * 
	 * @param current current DictionaryWord within this dictionaryBST
	 * @return the size of the subtree rooted at current
	 */
	private static int sizeHelper(DictionaryWord current) {
		// if end of list, return 0
		if (current == null) {
			return 0;
		}
		// add the size down the left branch
		int size1 = sizeHelper(current.getLeftChild());
		// add the size down the right branch
		int size2 = sizeHelper(current.getRightChild());
		// add the two sizes plus the root node
		return size1 + size2 + 1;
	}

	/**
	 * Recursive helper method that computes the height of the subtree rooted at
	 * current
	 * 
	 * @param current pointer to the current DictionaryWord within this
	 *                DictionaryBST
	 * @return height of the subtree rooted at current counting the number of
	 *         DictionaryWord nodes from the current node to the deepest leaf in the
	 *         subtree rooted at current
	 */
	private static int heightHelper(DictionaryWord current) {
		// check if at end node
		if (current == null) {
			return 0;
		}
		// call math.max to find the greatest of the lengths between the left and right
		// branch
		// and add one for the root node
		return Math.max(heightHelper(current.getLeftChild()),
				heightHelper(current.getRightChild())) + 1;
	}

	/**
	 * Recursive Helper method that returns a list of all the words stored in the
	 * subtree rooted at current
	 * 
	 * @param current pointer to the current DictionaryWord within this
	 *                dictionaryBST
	 * @return an ArrayList of all the words stored in the subtree rooted at current
	 */
	private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
		// check if at end node
		if (current == null) {
			// initialize a new arraylist
			return new ArrayList<String>();
		}
		// left, visit, right
		// add the left branch to the arraylist
		ArrayList<String> wordList = getAllWordsHelper(current.getLeftChild());
		// add the root node
		wordList.add(current.getWord());
		// add the right branch
		wordList.addAll(getAllWordsHelper(current.getRightChild()));
		return wordList;
	}
}
