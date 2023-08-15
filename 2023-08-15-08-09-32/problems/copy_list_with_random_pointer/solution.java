/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        return clone(head);
    }

    private Node clone(Node start) {
        if (start == null) {
            return null;
        }
        
        Node curr = start;
        Node temp = null;

        // Insert additional node after every node of the original list
        while (curr != null) {
            temp = curr.next;

            // Inserting node
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        
        curr = start;

        // Adjust the random pointers of the newly added nodes
        while (curr != null) {
            if (curr.next != null) {
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            
            // Move to the next newly added node by skipping an original node
            curr = curr.next != null ? curr.next.next : null;
        }
        
        Node original = start;
        Node copy = start.next;
        Node tempCopy = copy; // Save the start of the copied linked list

        // Separate the original list and copied list
        while (original != null) {
            original.next = original.next != null ? original.next.next : null;
            
            copy.next = copy.next != null ? copy.next.next : null;

            original = original.next;
            copy = copy.next;
        }

        return tempCopy;
    }
}
