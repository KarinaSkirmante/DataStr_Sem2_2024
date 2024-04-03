package datastr;

public class MyLinkedList<Ttype> {
	private MyListNode first = null;
	private MyListNode last = null;
	private int counter = 0;
	
	//pēc noklusejuma jau ir bezargumenta konstruktors -> MyLinkedList()
	
	public boolean isEmpty()
	{
		return (counter==0);
	}
	
	//TODO padomāt un izveidot isFull() funkciju
	
	public int howManyElements()
	{
		return counter;
	}
	
	public void add(Ttype element) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		
		
		//TODO izsaukt isFull()
		
		if(isEmpty())
		{
			MyListNode newNode = new MyListNode(element);
			first  = newNode;
			last = newNode;
			counter++;
		}
		else
		{
			MyListNode newNode = new MyListNode(element);
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
			counter++;
		}
		
		
	}
	
	public void add(Ttype element, int position) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		//TODO
		
		//1. pārbaude uz position
		
		if(position < 0 || position > counter) throw new Exception("Problems with position");
		
		//1.5. ja saraksts ir tukšs????
		if(isEmpty() && position == 0) {
			
			add(element);
			//garais variants:
			/*MyListNode newNode = new MyListNode(element);
			first  = newNode;
			last = newNode;
			counter++;*/
		}
		else if(isEmpty() && position != 0) throw new Exception("Problems with position");
		
		
		
		//2. pievienot elementu priekšā
		else if(position == 0) {
			MyListNode newNode = new MyListNode(element);
			newNode.setNext(first);
			first.setPrevious(newNode);
			first = newNode;
			counter++;
			
		}
		//3. pielikt elementu beigās
		else if (position == counter)
		{
			add(element);
			
			//garais veids
			/*MyListNode newNode = new MyListNode(element);
			newNode.setPrevious(last);
			last.setNext(newNode);
			last = newNode;
			counter++;*/
		}
		//4. ielikt elementu pa vidu
		
		else
		{
			MyListNode temp = first;
			for(int i = 0 ; i < position ; i++) {
				temp = temp.getNext();
			}
			
			MyListNode rightNode = temp;
			MyListNode leftNode = temp.getPrevious();
			MyListNode newNode = new MyListNode(element);
			
			newNode.setNext(rightNode);
			rightNode.setPrevious(newNode);
			newNode.setPrevious(leftNode);
			leftNode.setNext(newNode);
			
			counter++;
			
	
		}
		
		
		
	}
	
	
	
	public void print() throws Exception
	{
		if(isEmpty()) throw new Exception("List is empty");
		
		
		MyListNode temp = first;
		
		for(int i = 0 ; i < counter; i++) {
			System.out.print(temp + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	//delete
	//TODO
	//funkcijas deklarācija
	public void remove(int position) throws Exception
	{		//pārbaude uz isEmpty
		if(isEmpty()) throw new Exception("list is empty and it is not possible to delete element");

		//pārbaude uz position
		if(position < 0 || position >= counter) throw new Exception("Problems with position");
		//1. ja dzēšam pirmo elementu
		if(position == 0){
			MyListNode theNewFirst = first.getNext();
			theNewFirst.setPrevious(null);
			first = theNewFirst;
			counter--;
			System.gc();
			
		}
		
		//2. ja dzēšam pēdejo elementu
		else if(position == counter-1) {
			MyListNode theNewLast = last.getPrevious();
			theNewLast.setNext(null);
			last = theNewLast;
			counter--;
			System.gc();
		}
		//3. ja dzēšam kādu pa vidu
		else
		{
			MyListNode temp = first;
			
			for(int i = 0; i < position; i++) {
				temp = temp.getNext();
			}
			
			
			MyListNode rightNode = temp.getNext();
			MyListNode leftNode = temp.getPrevious();
			
			leftNode.setNext(rightNode);
			rightNode.setPrevious(leftNode);
			
			counter--;
			System.gc();
			
		}
		
	}

	//get (pēc pozīcijas)
	public Ttype get(int position) throws Exception {
		if(isEmpty()) throw new Exception("list is empty and it is not possible to get element");
		
		if(position < 0 || position >= counter) throw new Exception("Problems with position");
	

		MyListNode temp = first;
		for(int i = 0; i < position; i++) {
			temp = temp.getNext();
		}
		
		return (Ttype) temp.getElement();

	}
	
	
	//search (pēc elementa)
	
	public boolean search(Ttype element) throws Exception{
		if(isEmpty()) throw new Exception("list is empty and it is not possible to search element");
		
		if(element == null) throw new Exception("Problems with element");
		
		MyListNode temp = first;
		
		//while(temp != null)
		for(int i = 0; i < counter; i++) {
			if(temp.getElement().equals(element)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
		
	}
	//makeEmpty
	public void makeEmpty()
	{
		last = null;
		first = null;
		counter = 0;
		System.gc();
	}
	
	
	
	
	
	

}
