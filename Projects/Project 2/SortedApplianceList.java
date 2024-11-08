public class SortedApplianceList extends ApplianceList {

    public SortedApplianceList() {
        super();
    }

    public void add(Appliance appliance) {
        ApplianceNode newNode = new ApplianceNode(appliance);

        // Special case: If the list is empty, insert the new node
        if (first.next == null) {
            first.next = newNode;
            return;
        }

        // find the correct position
        ApplianceNode current = first;
        while (current.next != null && current.next.data.getSerialNumber().compareTo(newNode.data.getSerialNumber()) < 0) {
            current = current.next;
        }

        // Insert the new node at the correct position
        newNode.next = current.next;
        current.next = newNode;
        length++;
    }

    public void printList() {
        ApplianceNode current = first.next;
        while(current.next!=null) {
            System.out.println(current.data.toString());
            current = current.next;
        }
    }
}
