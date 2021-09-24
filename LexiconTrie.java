import structure5.*;
import java.util.Iterator;
import java.util.Scanner;

/**
* An implementation of the trie data structure that holds references to all
* words in our lexicon
*/
public class LexiconTrie implements Lexicon {

  //keeps track of the number of words in our LexiconTrie
  private int count = 0;
  //is the root
  private LexiconNode root;

  /**
  * constructs an empty LexiconTrie
  */
  public LexiconTrie() {
    //sets up the root as an empty LexiconNode
    root = new LexiconNode('\0', false);
  }

  /**
  * Adds words to lexicon
  * @pre word is not null
  * @return true if word was added, false if word already contained in lexicon
  */
  public boolean addWord(String word) {
    Assert.pre(!word.equals(null), "please provide a valid word");
    //make lowercase
    word = word.toLowerCase();
    //we instantiate our current node as the root
    LexiconNode current = root;
    //iterate through all of the characters in the word
    for (int i = 0; i < word.length(); i++) {
      //save the character we are at
      char c = word.charAt(i);
      //if the current node does not have c as a child, we add it
      if (!current.hasChild(c)) current.addChild(new LexiconNode(c, false));
      //proceed to next child of current
      current = current.getChild(c);
    }
    //word already in LexiconTrie
    if (current.isWord()) return false;
    //otherwise, flag the final node as true
    current.setWord(true);
    //increment word count
    count++;
    return true;
  }

  /**
  * Adds words to lexicon from a valid file
  * @pre filename is a valid file
  * @return number of words contained in file
  */
  public int addWordsFromFile(String filename) {
    int fileCount = 0;
    //local count for number of words in file
    try {
      //create a scanner
      Scanner sc = new Scanner(new FileStream(filename));
      //loop through the file
      while (sc.hasNextLine()) {
        //each line is stored as a string
        String word = sc.nextLine();
        //add each word, locally counting only if word is not contained in lexicon
        if (addWord(word)) fileCount++;
      }
      sc.close();
    } catch (Exception e) {
      //accounts for non-existent or misspelled files
      System.out.println("Please provide a valid filename");
      return 0;
    }
    return fileCount;
  }

  /**
  * Removes word from lexicon
  * @pre word is not null
  * @return true if word is successfully removed, false if lexicon does not contain word
  */
  public boolean removeWord(String word) {
    Assert.pre(!word.equals(null), "please provide a valid word to remove");
    //make lowercase
    word = word.toLowerCase();
    //if word is not in trie, we simply return false
    if (!containsWord(word)) return false;

    StackList<LexiconNode> stack = new StackList<LexiconNode>();

    //we instantiate our current node as the root
    LexiconNode current = root;
    //iterate through all of the characters in the word
    for (int i = 0; i < word.length(); i++) {
      //save the character we are at
      char c = word.charAt(i);
      //proceed to next child of current
      current = current.getChild(c);
      stack.push(current);
    }
    current.setWord(false);
    //at the end of word, so we set flag as false
    //decrement count at the end of the word
    count--;
    if (!current.hasChildren()) removeHelper(stack);
    return true;
  }

  /**
  * Removes all unneseary nodes
  * @pre stack is not null
  */
  protected void removeHelper(StackList<LexiconNode> stack) {
    //as long as there is more than one item in the stack, loop through it
    while (stack.size() > 1) {
      //keep reference to the top two nodes
      LexiconNode one = stack.pop();
      LexiconNode two = stack.peek();
      //one is child of two
      if (!one.isWord()) two.removeChild(one.getChar());
      else break;
    }
  }


  /**
  * Returns the number of words contained in lexicon
  */
  public int numWords() {
    return count;
  }


  /**
  * Returns true iff lexicon contains word
  * @pre word is not null
  * @return true if lexicon contains word, false if not
  */
  public boolean containsWord(String word) {
    Assert.pre(!word.equals(null), "please provide a valid word to check");
    //make lowercase
    word = word.toLowerCase();
    LexiconNode current = root;
    //iterate through all of the characters in the word
    for (int i = 0; i < word.length(); i++) {
      //save the character we are at
      char c = word.charAt(i);
      //proceed to next child of current
      if (!current.hasChild(c)) return false;
      current = current.getChild(c);
    }
    if (current.isWord()) return true;
    return false;
  }


  /**
  * returns true iff prefix is contained in lexicon
  * @pre prefix is not null
  */
  public boolean containsPrefix(String prefix) {
    Assert.pre(!prefix.equals(null), "please provide a valid prefix to check");
    //make lowercase
    prefix = prefix.toLowerCase();
    LexiconNode current = root;
    //iterate through all of the characters in the word
    for (int i = 0; i < prefix.length(); i++) {
      //save the character we are at
      char c = prefix.charAt(i);
      //proceed to next child of current
      if (!current.hasChild(c)) return false;
      current = current.getChild(c);
    }
    return true;
  }


  /**
  * returns an iterator for the lexicon
  * @return a vector iterator with all words in our lexicon
  */
  public Iterator<String> iterator() {

    Iterator<LexiconNode> iter = root.iterator();
    Vector<String> words = new Vector<String>(count);

    while (iter.hasNext()) findAllWords("", iter.next(), words);

    return words.iterator();
  }

  /**
  * Helper method for our iterator()
  * @pre LexiconNode provided is not the root
  */
  protected void findAllWords(String s, LexiconNode current, Vector<String> words) {
    Assert.pre(!current.equals(root), "Please provide a non-root node");

    s += current.getChar();

    // add the character at the current node to our working string

    if (current.isWord()) words.add(s);
    //add the string to vector if isWord flag is on at any point

    // create an iterator to walk through the children of current
    Iterator<LexiconNode> iter = current.iterator();
    while (iter.hasNext()) findAllWords(s, iter.next(), words);
    //for each child of current, we findAllWords for that child

  }

  /**
  *
  * @pre
  * @post
  * @return
  */
  public Set<String> suggestCorrections(String target, int maxDistance) {
    return null;
  }


  /**
  *
  * @pre
  * @post
  * @return
  */
  public Set<String> matchRegex(String pattern) {
    return null;
  }

  /**
  * Main method for testing
  */
  public static void main(String[] args) {
    LexiconTrie test = new LexiconTrie();
    test.addWord("hat");
    test.addWord("hate");
    test.addWord("cat");
    System.out.println(test);
  }
}
