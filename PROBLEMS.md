# Lexicon Thought Questions

 1. For each node in the trie, you need to store pointers to its children nodes. What data structure did you use to store the pointers to children nodes? Justify the choice you made.
   * Data structure choice: OrderedVector
   * Justification: The OrderedVector ensured that the children of a given node are stored in alphabetical order. Thus, when we created an iterator for the children, there was no need to sort the structure that the children are stored in, because it is already done.

2. Suppose we use an `OrderedVector` instead of a trie for storing our lexicon. Discuss how the process of searching for suggested spelling corrections would differ from our trie-based implementation. Which is more efficient? Why?
   * Searching in a trie: Searching for a String target in a trie only requires the partial traversal of the trie. We can ensure that our suggested correction is within a certain range of the trie. Since we store our words using LexiconNodes that store individual characters, it is much easier to traverse the trie since all of our suggested corrections are inherently neighbors.
   * Searching in an `OrderedVector`: Searching for a String target in an OrderedVector requires the entire traversal of the vector. For each word in the ordered vector, we must compare, letter by letter, our target to the ith word. If numDifferences > maxDistance, then the ith word is not a suggested correction. If numDifferences ≤ maxDistance, then the ith word is a suggested correction. This means that it takes about n^2 time to produce a suggested correction operation.
   * Which is more efficient? (The trie is much more efficient. This is because for the OrderedVector, it requires n^2 time to traverse the entire Lexicon, searching character by character. However, in the trie, the words are already broken into their characters and we only search over a given range in the trie, which is much more efficient than traversing an entire vector.)
