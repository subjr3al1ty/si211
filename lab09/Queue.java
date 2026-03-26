public class Queue
{
  public void enqueue(String s)
  {
    if (head == null) 
      head = tail = new Node(s,null);
    else 
    { 
      tail.next = new Node(s,null); 
      tail = tail.next; 
    }
  }
  public String dequeue()
  {
    //add a check here to see if the queue is cleared to empty
    if(head == null) {
      throw new QueueException("depqueue empty queue");
    }
    String val = head.data;
    head = head.next;
    return val;
  }
  public boolean empty() { return head == null; }

  public Iter iterator() { return new Iter(head); }

  protected class Iter
  {
    private Node curr;
    public Iter(Node start) { curr = start; }
    public boolean hasNext() { return curr != null; }
    public String next() 
    {
      //add a check here to see if iterator is past the end
      if(curr == null) {
        throw new QueueException("iterator past end of queue");
      }
      String val = curr.data; 
      curr = curr.next;  
      return val; 
    }
  }

  private class Node
  {
    public String data;
    public Node next;
    public Node(String d, Node n) { data = d; next = n; }
  }
  
  private Node head = null, tail = null;
}
