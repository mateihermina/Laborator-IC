/**
 * <h1>The implementation of a circular linked list</h1>
 * The class contains most common functions of a linked list.
 * <p>
 * <b>Note:</b>  The list keeps a reference to the head and the tail.
 *
 * @author  Hermina & Miruna
 * @version 1.0
 * @since   2022-05-18
 */
public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    /**
     * Adds a node in the list
     * @param value is added to the list
     */
    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    /**
     * Checks if the list contains a specific node
     * @param searchValue is the value to be searched
     * @return true if the value is found, false otherwise
     */
    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    /**
     * Deletes a node from the list
     * @param valueToDelete is the value that needs to be deleted
     */
    public void deleteNode(int valueToDelete) {
        Node currentNode = head;
        if (head == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (head == nextNode) {
                        head = head.nextNode;
                    }
                    if (tail == nextNode) {
                        tail = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != head);
    }

    /**
     * Gets the next node of a given node
     * @param currentNode is the node of which next is searched
     * @return the next node
     */
    public Node getNextNode(Node currentNode) {
        Node crt = head;
        while(crt != null) {
            if(crt == currentNode) {
                return crt.nextNode;
            }
            crt = crt.nextNode;
        }

        return null;
    }

}