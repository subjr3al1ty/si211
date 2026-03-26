import java.util.*;

//name: aspen harres
public class Queue {
 private static class Node {
   public String data;
   public Node next;

   public Node(String d, Node n) {
     data = d;
     next = n;
   }
 }
 private Node head;
 private Node tail;

 //make the queue
 public Queue() {
   head = null;
   tail = null;
 }

 public void enqueue(String s) {
   //set up linked list
   Node newNode = new Node(s, null);
   
   //if its empty, set head and tail to s, and end
   if(empty()) {
     head = newNode;
     tail = newNode;
   } else {
     //otherwise set only head
     tail.next = newNode;
     tail = newNode;
   }
 }

 public String dequeue() {
   if(empty()) {
     return null;
   }
  
   String val = head.data;
   head = head.next;
    
   //this makes sure everything is cleared out
   if(head == null)
   {
     tail = null;
   }
   return val;
 }

 //checks until head is empty
 public boolean empty() {
   return head == null;
 }
}
