package day_04;

public class Day04_Ex4 {
    public static void main(String[] args) {
        System.out.println("----------- START EXERCISE 4 ---------");
        MyLinkedList list = new MyLinkedList();

        System.out.println("*** Insert at the beginning of the list ***");
        list.insertFirst(new Node('a', null));
        list.print();

        System.out.println("*** Insert at the end of the list ***");
        list.insertLast(new Node('b', null));
        list.print();

        list.insertLast(new Node('c', null));
        list.insertLast(new Node('e', null));
        list.insertLast(new Node('f', null));
        list.insertLast(new Node('g', null));
        list.insertLast(new Node('h', null));
        list.insertLast(new Node('i', null));
        list.insertLast(new Node('j', null));
        list.insertLast(new Node('k', null));
        System.out.println("*** The first element (Test get first element) ***");
        System.out.println(list.getFirst().info);

        System.out.println("*** Remove first element, then print the remaining ***");
        list.removeFirst();
        list.print();

        System.out.println("*** The last element (Test get last element) ***");
        System.out.println(list.getLast().info);

        System.out.println("*** Remove last element, then print the remaining ***");
        list.removeLast();
        list.print();

        System.out.println("*** Check if list contains an element ***");
        Node node1 = new Node('c', null);
        Node node2 = new Node('m', null);
        boolean containsNode1 = list.contain(node1);
        boolean containsNode2 = list.contain(node2);
        System.out.println(String.format("List contains node 1 ('%c'): ", node1.info)  + containsNode1);
        System.out.println(String.format("List contains node 1 ('%c'): ", node2.info)  + containsNode2);

        System.out.println("\n*** Returns the data at the given position in the list ***");
        list.getDataAt(2);
        list.getDataAt(5);
        list.getDataAt(10);

        System.out.println("\n*** Test insert after position ***");
        System.out.println("Insert X after position 0");
        list.insertAfterPosition(new Node('X', null), 0);
        list.print();

        System.out.println("Insert Y after position 3");
        list.insertAfterPosition(new Node('Y', null), 3);
        list.print();

        System.out.println("Insert Z after position 5");
        list.insertAfterPosition(new Node('Z', null), 5);
        list.print();

        System.out.println("Insert P after position 20");
        list.insertAfterPosition(new Node('P', null), 20);
        list.print();

        System.out.println("Insert a new node (K) after a node containing the key (X)");
        list.insertAfterANode(new Node('K', null), 'X');
        list.print();

        System.out.println("Insert a new node (K) before a node containing the key (Y)");
        list.insertAfterANode(new Node('K', null), 'X');
        list.print();

        System.out.println("\n*** Remove all nodes ***");
        list.removeAllNodes();
        list.print();

        System.out.println("----------- END EXERCISE 4 ---------\n\n");
    }
}

final class Node {
    char info;
    Node next;

    public Node(char letter, Node node) {
        info = letter;
        next = node;
    }
}

class MyLinkedList {
    private Node head;
    private Node tail;

    public void insertFirst(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void insertLast(Node node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
    }

    public Node getFirst() {
        return this.head;
    }

    public Node getLast() {
        return this.tail;
    }

    public void removeFirst() {
        Node currentHead = this.head;
        this.head = this.head.next;
        currentHead = null;
    }

    public void removeLast() {
        Node currentNode = this.head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }

        Node currentTail = this.tail;
        this.tail = currentNode;
        this.tail.next = null;
        currentTail = null;
    }

    public void removeAllNodes() {
        Node currentNode = this.head;
        while (currentNode != null) {
            Node destroyedNode = currentNode;
            currentNode = currentNode.next;
            destroyedNode.next = null;
            destroyedNode = null;
        }
        this.head = null;
        this.tail = null;
    }

    public boolean contain(Node node) {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.info == node.info) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void getDataAt(int position) {
        if (position < 0) {
            System.out.println("Invalid position!");
        }

        Node currentNode = this.head;
        int currentPosition = 0;
        while (currentNode != null && currentPosition < position) {
            currentPosition++;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            if (currentPosition == position) {
                System.out.println(String.format("Data at position = %d is %c", position, currentNode.info));
            }
        } else {
            System.out.println("Invalid position!");
        }
    }

    void insertAfterPosition(Node node, int afterPosition) {
        if (afterPosition < 0) {
            System.out.println("Invalid position!");
        }

        Node currentNode = this.head;
        int currentPosition = 0;
        while (currentNode != null && currentPosition < afterPosition) {
            currentPosition++;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            node.next = currentNode.next;
            currentNode.next = node;
        } else {
            System.out.println("Invalid position!");
        }
    }

    void insertAfterANode(Node node, char key) {
        Node currentNode = this.head;
        while (currentNode != null && currentNode.info != key) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            node.next = currentNode.next;
            currentNode.next = node;
        } else {
            System.out.println("Invalid key!");
        }
    }

    void insertBeforeANode(Node node, char key) {
        Node currentNode = this.head;
        Node previousNode = null;
        while (currentNode != null && currentNode.info != key) {
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            node.next = currentNode;
            if (previousNode != null) {
                previousNode.next = node;
            }
        } else {
            System.out.println("Invalid key!");
        }
    }

    void print() {
        Node currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.info);
            if (currentNode != this.tail) {
                System.out.print(", ");
            }
            currentNode = currentNode.next;
        }
        System.out.println();
        System.out.println();
    }
}
