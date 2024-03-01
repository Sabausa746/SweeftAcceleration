public class ListNode {
    private int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().getName().equals("ListNode")) {
            ListNode otherNode = (ListNode) obj;
            ListNode tempNode = this;
            while (tempNode != null && otherNode != null) {
                if (tempNode.val != otherNode.getVal()) {
                    return false;
                } else {
                    tempNode = tempNode.getNext();
                    otherNode = otherNode.getNext();
                }
            }
            return true;
        }
        return false;
    }

}
