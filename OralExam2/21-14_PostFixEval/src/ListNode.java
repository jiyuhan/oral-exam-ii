/**
 * In the requirement, it says we need to utilize the stack class which is given in the chapter.
 * So I copied it from book. Maybe the comments are different because I'm lazy...
 */

public class ListNode<T> {
    T data;
    ListNode<T> nextNode;

    // constructor
    ListNode(T object) {
        this(object, null);
    }

    // contructor creates ListNode that refers to the specified object and to the next ListNode
    ListNode(T object, ListNode<T> node) {
        data = object;
        nextNode = node;
    }

    //return reference to data in node
    T getData() {
        return data;
    }

    //return reference to next node in list
    ListNode<T> getNext() {
        return nextNode;
    }
} // end class ListNode<T>
