import java.util.HashSet;

public class LinkedList {
public static void main(String[]args) {
int[]array = {3,5,8,5,10,2,1};

node head = create(array);
//printLL(head);
//head = removeDups(head);
//printLL(head);
head = partition(head, 5);
printLL(head);
//head = delete(1, head);
//printLL(head);
//head = insert(12, head);
//printLL(head);
	
}

public static node partition(node head, int part) {
	node temp = head;
	node small = new node (-1);
	node smallCopy = small;
	node large = new node(-1);
	node largeCopy = large;
	
	while(temp!=null) {
		if(temp.val<part) {
			node newnode= new node(temp.val);
			small.next = newnode;
			small = small.next;		
		}
		else {
			node newnode= new node(temp.val);
			large.next = newnode;
			large = large.next;
		}
		temp = temp.next;
		
	}
	
	largeCopy = largeCopy.next;
	smallCopy = smallCopy.next;
	small.next = largeCopy;
	
	return smallCopy;
	
	
}

public static int kthFromLast(node head, int k) {
	node slow = head;
	node fast = head;
	
	while(k!=0) {
		k--;
		fast = fast.next;
	}
	
	while(fast!=null) {
		slow = slow.next;
		fast = fast.next;
	}
	
	return slow.val;
	
	
}

public static node removeDups(node head) {
	HashSet<Integer> set = new HashSet<>();
	node temp = head;
	node prev = new node(-1);
	prev.next = temp;
	
	while(temp!=null) {
		int curr = temp.val;
		if(!set.contains(curr)) {
			set.add(curr);
			prev = prev.next;
			temp = temp.next;
		}
		else {
			temp = temp.next;
			prev.next = temp;
		}
		
		
	}
	
	return head;
	
}

public static node create(int[]array) {
	node head = new node(array[0]);
	node temp = head;
	for(int i = 1;i<array.length;i++) {
		node newnode = new node(array[i]);
		temp.next = newnode;
		temp = temp.next;
	}
	
	return head;
}

public static node insert(int num, node head) {
	node temp = head;
	while(temp.next!=null) {
		temp = temp.next;
	}
	node newnode = new node(num);
	temp.next = newnode;
	return head;
	
	
}


public static node delete(int num, node head) {
	node temp = head;
	if(temp.val==num) {
		return head.next;
	}
	
	while(temp!=null && temp.next!=null) {
		if(temp.next.val==num) {
			temp.next = temp.next.next;
		}
		temp = temp.next;
	}
	return head;
	
}

public static void printLL(node head) {
	node temp = head;
	while(temp!=null) {
		System.out.println(temp.val);
		temp = temp.next;
	}
	
}

}


