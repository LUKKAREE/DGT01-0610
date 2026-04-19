class Link {
    public int value; // integer data
    public Link next; // reference to next link
}

class LinkList {
    private Link first; // ref to first Link on list

    public LinkList() {
        first = null;
    }

    public static Link getnode(int value) {
        Link n = new Link();
        n.value = value;
        n.next = null;
        return n;
    }

    public void insertFirst(int value) {
        Link newLink = getnode(value);
        newLink.next = first; // it points to old first link
        first = newLink;      // now first points to this
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void printlst() {
        Link ptr = first;
        while (ptr != null) {
            System.out.print(ptr.value + " ");
            ptr = ptr.next; // next node
        }
    }

    // (1) findMax() - returns max value, or -1 if empty
    public int findMax() {
        if (first == null) return -1;
        int max = first.value;
        Link ptr = first.next;
        while (ptr != null) {
            if (ptr.value > max) max = ptr.value;
            ptr = ptr.next;
        }
        return max;
    }

    // (2) removeMax() - removes max node, reconnects chain
    public Link removeMax() {
        if (first == null) {
            System.out.println("Cannot find max. LinkedList is empty.");
            return null;
        }

        int max = findMax();

        Link removed = getnode(max);

        // Case: max is the first node
        if (first.value == max) {
            first = first.next;
        } else {
            // Traverse to find node before the max
            Link ptr = first;
            while (ptr.next != null && ptr.next.value != max) {
                ptr = ptr.next;
            }
            if (ptr.next != null) {
                ptr.next = ptr.next.next; // skip (remove) max node
            }
        }

        System.out.println(max + " has been removed.");
        return removed;
    }
}

public class LabLinkedList {
    public static void main(String[] args) {
        LinkList numlist = new LinkList();

        numlist.insertFirst(28);
        numlist.insertFirst(96);
        numlist.insertFirst(75);
        numlist.insertFirst(162);

        numlist.printlst();
        System.out.println();

        System.out.println("Index Number: " + numlist.findMax());

        numlist.removeMax();
        numlist.printlst();
    }
}
