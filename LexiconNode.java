import structure5.*;
import java.util.Iterator;

/**
 * An implementation of the LexiconNode used to build a LexiconTrie
 */
class LexiconNode implements Comparable<LexiconNode> {

    //single letter stored in this node
    protected char letter;

    //true if this node ends some path that defines a valid word
    protected boolean isWord;

    //keep track of children nodes
    protected OrderedVector<LexiconNode> children = new OrderedVector<LexiconNode>();

   /**
    * Constructs an empty LexiconNode
    */
    LexiconNode(char letter, boolean isWord) {
    this.letter = letter;
    this.isWord = isWord;
    }

   /**
    * Returns character at given LexiconNode
    */
    public char getChar() {
      return letter;
    }

   /**
    * Compares two LexiconNodes lexographically
    * @pre o is not null
    * @return positive int if this > o, negative int if this < o, and 0 if this = o
    */
    public int compareTo(LexiconNode o) {
      Assert.pre(!(o.equals(null)), "Please compare a valid node");
      return this.letter - o.getChar();
    }

   /**
    * Adds child LexiconNode to children vector
    * @pre ln is not null
    */
    public void addChild(LexiconNode ln) {
      Assert.pre(!ln.equals(null), "please add a non-empty LexiconNode");
      children.add(ln);
    }

   /**
    * Gets the child of a parent LexiconNode
    * @pre ch is not null
    * @return a LexiconNode
    */
    public LexiconNode getChild(char ch) {
      for (LexiconNode n : children) {
        if (n.getChar() == ch) return n;
      }
      return null;
    }

    /**
     * Removes child LexiconNode from parent LexiconNode
     * @pre ch is not null
     */
    public void removeChild(char ch) {
      for (LexiconNode n : children) {
        if (n.getChar() == ch) children.remove(n);
      }
    }

    /**
     * Checks if a given char has children
     * @pre ch is not null
     * @return true if ch has children, false if it does not
     */
    public boolean hasChild(char ch) {
      for (LexiconNode n : children) {
        if (n.getChar() == ch) return true;
      }
      return false;
    }

    /**
     * Checks if a node denotes a word
     * @return true if the node has a word flag, false if it does not
     */
    public boolean isWord() {
      return isWord;
    }

    /**
     * Sets word to true or false given a bool b
     * @pre provide a valid bool
     */
    public void setWord(boolean b) {
      this.isWord = b;
    }


    /**
     * Checks if a given node has children
     * @return true if a node has children, false if it does not
     */
    public boolean hasChildren() {
      return children.size() > 0;
    }


    /**
     * Provides an iterator that goes through the children of a node alphabetically
     * @pre ch is not null
     * @return an iterator for the children of a given LexiconNode
     */
    public Iterator<LexiconNode> iterator() {
      return children.iterator();
    }

    /**
     * For testing
     */
    public static void main(String[] args) {

      LexiconNode node = new LexiconNode('a', true);
      node.addChild(new LexiconNode('b', false));
      node.addChild(new LexiconNode('c', false));
      System.out.println(node.getChild('c').getChar());

    }
}
