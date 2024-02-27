public class LinkedListMerger {

    public static class ListNode {

        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }

    }

    private ListNode head;
    private int size;

    public static void main(String[] args) {

        LinkedListMerger llm1 = new LinkedListMerger();
        llm1.addNode(30);
        llm1.addNode(10);
        llm1.addNode(20);
        llm1.addNode(40);

        llm1.log(llm1.toString());

        LinkedListMerger llm2 = new LinkedListMerger();
        llm2.addNode(30);
        llm2.addNode(10);
        llm2.addNode(20);
        llm2.addNode(40);

        llm2.log(llm2.toString());

        LinkedListMerger llm3 = new LinkedListMerger();
        llm3.addNode(70);
        llm3.addNode(50);
        llm3.addNode(60);
        llm3.addNode(80);

        LinkedListMerger llm4 = new LinkedListMerger();
        llm4.addNode(100);
        llm4.addNode(90);

        LinkedListMerger llm5 = new LinkedListMerger();
        llm5.addNode(90);
        llm5.addNode(100);

        llm1.addNodes(llm2.getList());
        llm1.addNodes(llm3.getList());
        llm1.addNodes(llm4.getList());
        llm1.addNodes(llm5.getList());

        llm1.log(llm1.toString() + " => " + llm1.size());
        llm2.log(llm2.toString() + " => " + llm2.size());
        llm3.log(llm3.toString() + " => " + llm3.size());
        llm4.log(llm4.toString() + " => " + llm4.size());
        llm4.log(llm5.toString() + " => " + llm5.size());
    }

    public ListNode getList() {
        return this.head;
    }

    public int size() {
        return this.size;
    }

    public void addNodes(ListNode n1) {
        ListNode p1 = n1;
        while (p1 != null) {
            addNode(p1.val);
            p1 = p1.next;
        }
    }

    public void addNode(int val) {
        if (this.head == null) {
            this.head = new ListNode(val);
            this.size = 1;
        } else if (this.head.next == null) {
            if (this.head.val > val) {
                int tmp = this.head.val;
                this.head.val = val;
                this.head.next = new ListNode(tmp);
            } else {
                this.head.next = new ListNode(val);
            }
            this.size = 2;
        } else {
            boolean isInserted = false;
            ListNode p1 = this.head.next;
            while (p1.next != null) {
                if (p1.val > val) {
                    insertNode(p1, val);
                    isInserted = true;
                    break;
                }
                p1 = p1.next;
            }
            if (!isInserted) {
                insertNode(p1, val);
            }
        }
    }

    private void insertNode(ListNode n1, int val) {
        if (n1.val > val) {
            int tmp = n1.val;
            ListNode tmpNode = n1.next;
            n1.val = val;
            n1.next = new ListNode(tmp);
            n1.next.next = tmpNode;
        } else {
            n1.next = new ListNode(val);
        }
        this.size++;
    }

    @Override
    public String toString() {
        String result = "";
        ListNode p1 = this.head;
        while (p1 != null) {
            result += p1.toString() + " -> ";
            p1 = p1.next;
        }
        return result.length() > 4 ? result.substring(0, result.length() - 4) : result;
    }

    public void log(String msg) {
        System.out.println(msg);
    }

}
