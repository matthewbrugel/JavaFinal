package termproject;

import java.awt.RenderingHints;

/**
 * Title:        Term Project 2-4 Trees
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
public class TwoFourTree
        implements Dictionary {

    private Comparator treeComp;
    private int size = 0;
    private TFNode treeRoot = null;

    public TwoFourTree(Comparator comp) {
        treeComp = comp;
    }

    private TFNode root() {
        return treeRoot;
    }

    private void setRoot(TFNode root) {
        treeRoot = root;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Searches dictionary to determine if key is present
     * @param key to be searched for
     * @return object corresponding to key; null if not found
     */
    public Object findElement(Object key) {
        return null;
    }
    
    private void fixOverflow(TFNode node) {
        //get current node being passed in
        
        //create a new TFNode if current is root
        TFNode current = node;
        
        //get the current node's parent
        TFNode parent = current.getParent();
        if(parent == null){
            parent = new TFNode();
        }
        
        //get current nodes third item
        Item num3 = current.getItem(2);
        //get index of where to insert item in parent
        int parentIndex = FindFirstGreaterThanOrEqualTo(parent, num3.key());
        //put item in parent
        parent.insertItem(parentIndex, num3);
        //remove item from current node
        current.removeItem(2);
        

        
        //get last item of current node
        Item num4 = current.getItem(2);
        current.removeItem(2);
        int indexInsert2 = FindFirstGreaterThanOrEqualTo(parent, num4.key());
        TFNode childNode = parent.getChild(indexInsert2);
        if (childNode == null) {
            childNode = new TFNode();
            parent.setChild(indexInsert2, childNode);
        }
        int childIndex = FindFirstGreaterThanOrEqualTo(childNode, num4.key());
        childNode.insertItem(childIndex, num4);
        
        //if parent is full, we have to fixoverflow on parent as well
        if (parent.getNumItems() == 4) {
            fixOverflow(parent);
        }
    }

    /**
     * Inserts provided element into the Dictionary
     * @param key of object to be inserted
     * @param element to be inserted
     */
    public void insertElement(Object key, Object element) {
        TFNode previousNode = null;
        TFNode currentNode = root();
        
        //if root hasnt been set then make new tfnode and set it to root
        if(currentNode == null){
            currentNode = new TFNode();
            setRoot(currentNode);
        }
        
        int currentIndex = 0;
       
        while (currentNode != null) {
            currentIndex = FindFirstGreaterThanOrEqualTo(currentNode, key);
            previousNode = currentNode;
            currentNode = previousNode.getChild(currentIndex);
        }
        
        previousNode.insertItem(currentIndex, new Item (key, element));
        if (previousNode.getNumItems() == 4) {
            fixOverflow(previousNode);
        }
    }
    
    /**
     * Finds the first item with a key within a TFNode greater than or equal to
     * the current key
     * @param T node being searched
     * @param key being compared
     * @return the first item greater than or 
     */
    public int FindFirstGreaterThanOrEqualTo(TFNode T, Object key){
        int i = 0;
        for(i = 0; i < T.getNumItems(); i++){
            Object k = T.getItem(i).key();
            if (treeComp.isGreaterThanOrEqualTo(k, key)) {
                return i;
            }
        }
        return i;
    }

    /**
     * Searches dictionary to determine if key is present, then
     * removes and returns corresponding object
     * @param key of data to be removed
     * @return object corresponding to key
     * @exception ElementNotFoundException if the key is not in dictionary
     */
    public Object removeElement(Object key) throws ElementNotFoundException {
        return null;
    }

    public static void main(String[] args) {
        Comparator myComp = new IntegerComparator();
        TwoFourTree myTree = new TwoFourTree(myComp);

        Integer myInt1 = new Integer(47);
        myTree.insertElement(myInt1, myInt1);
        Integer myInt2 = new Integer(83);
        myTree.insertElement(myInt2, myInt2);
        Integer myInt3 = new Integer(22);
        myTree.insertElement(myInt3, myInt3);

        Integer myInt4 = new Integer(16);
        myTree.insertElement(myInt4, myInt4);

        Integer myInt5 = new Integer(49);
        myTree.insertElement(myInt5, myInt5);

        Integer myInt6 = new Integer(100);
        myTree.insertElement(myInt6, myInt6);

        Integer myInt7 = new Integer(38);
        myTree.insertElement(myInt7, myInt7);

        Integer myInt8 = new Integer(3);
        myTree.insertElement(myInt8, myInt8);

//        Integer myInt9 = new Integer(53);
//        myTree.insertElement(myInt9, myInt9);
//
//        Integer myInt10 = new Integer(66);
//        myTree.insertElement(myInt10, myInt10);
//
//        Integer myInt11 = new Integer(19);
//        myTree.insertElement(myInt11, myInt11);
//
//        Integer myInt12 = new Integer(23);
//        myTree.insertElement(myInt12, myInt12);
//
//        Integer myInt13 = new Integer(24);
//        myTree.insertElement(myInt13, myInt13);
//
//        Integer myInt14 = new Integer(88);
//        myTree.insertElement(myInt14, myInt14);
//
//        Integer myInt15 = new Integer(1);
//        myTree.insertElement(myInt15, myInt15);
//
//        Integer myInt16 = new Integer(97);
//        myTree.insertElement(myInt16, myInt16);
//
//        Integer myInt17 = new Integer(94);
//        myTree.insertElement(myInt17, myInt17);
//
//        Integer myInt18 = new Integer(35);
//        myTree.insertElement(myInt18, myInt18);
//
//        Integer myInt19 = new Integer(51);
//        myTree.insertElement(myInt19, myInt19);

        myTree.printAllElements();
        System.out.println("done");

        myTree = new TwoFourTree(myComp);
        final int TEST_SIZE = 10000;


//        for (int i = 0; i < TEST_SIZE; i++) {
//            myTree.insertElement(new Integer(i), new Integer(i));
//            //          myTree.printAllElements();
//            //         myTree.checkTree();
//        }
        System.out.println("removing");
//        for (int i = 0; i < TEST_SIZE; i++) {
//            int out = (Integer) myTree.removeElement(new Integer(i));
//            if (out != i) {
//                throw new TwoFourTreeException("main: wrong element removed");
//            }
//            if (i > TEST_SIZE - 15) {
//                myTree.printAllElements();
//            }
//        }
//        System.out.println("done");
    }

    public void printAllElements() {
        int indent = 0;
        if (root() == null) {
            System.out.println("The tree is empty");
        }
        else {
            printTree(root(), indent);
        }
    }

    public void printTree(TFNode start, int indent) {
        if (start == null) {
            return;
        }
        for (int i = 0; i < indent; i++) {
            System.out.print(" ");
        }
        printTFNode(start);
        indent += 4;
        int numChildren = start.getNumItems() + 1;
        for (int i = 0; i < numChildren; i++) {
            printTree(start.getChild(i), indent);
        }
    }

    public void printTFNode(TFNode node) {
        int numItems = node.getNumItems();
        for (int i = 0; i < numItems; i++) {
            System.out.print(((Item) node.getItem(i)).element() + " ");
        }
        System.out.println();
    }

    // checks if tree is properly hooked up, i.e., children point to parents
    public void checkTree() {
        checkTreeFromNode(treeRoot);
    }

    private void checkTreeFromNode(TFNode start) {
        if (start == null) {
            return;
        }

        if (start.getParent() != null) {
            TFNode parent = start.getParent();
            int childIndex = 0;
            for (childIndex = 0; childIndex <= parent.getNumItems(); childIndex++) {
                if (parent.getChild(childIndex) == start) {
                    break;
                }
            }
            // if child wasn't found, print problem
            if (childIndex > parent.getNumItems()) {
                System.out.println("Child to parent confusion");
                printTFNode(start);
            }
        }

        if (start.getChild(0) != null) {
            for (int childIndex = 0; childIndex <= start.getNumItems(); childIndex++) {
                if (start.getChild(childIndex) == null) {
                    System.out.println("Mixed null and non-null children");
                    printTFNode(start);
                }
                else {
                    if (start.getChild(childIndex).getParent() != start) {
                        System.out.println("Parent to child confusion");
                        printTFNode(start);
                    }
                    for (int i = childIndex - 1; i >= 0; i--) {
                        if (start.getChild(i) == start.getChild(childIndex)) {
                            System.out.println("Duplicate children of node");
                            printTFNode(start);
                        }
                    }
                }

            }
        }

        int numChildren = start.getNumItems() + 1;
        for (int childIndex = 0; childIndex < numChildren; childIndex++) {
            checkTreeFromNode(start.getChild(childIndex));
        }

    }
}

