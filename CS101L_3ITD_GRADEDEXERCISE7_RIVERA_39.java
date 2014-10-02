import java.util.Scanner;
public class CS101L_3ITD_GRADEDEXERCISE7_RIVERA_39 
{
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Input size of queue: ");
        int size = sc.nextInt();
        CircularQueue q = new CircularQueue(size);
        System.out.print("Input number of data to enqueue: ");
        int enqueueVal = sc.nextInt();
		System.out.print("Input " + enqueueVal + " data to enqueue: ");
		int ctr;
		int num = 0;
		for (ctr = 0; ctr < enqueueVal; ctr++)
			num = sc.nextInt();
			
		for (ctr = 0; ctr < enqueueVal; ctr++)
			q.enqueue(num);
		
		System.out.print("Input number of data to dequeue: ");
        int n = sc.nextInt();
		for (ctr = 0; ctr < n; ctr++)
            q.dequeue();
			
		System.out.print("Input number of data to enqueue: ");	
		int enqueueVal2 = sc.nextInt();
		int num2 = 0;
		
        System.out.print("Input " + enqueueVal2 + " data to enqueue ");
		for (ctr = 0; ctr < enqueueVal; ctr++)
			num2 = sc.nextInt();
			
        for (ctr = 0; ctr < enqueueVal2; ctr++)
            q.enqueue(num2);
		
		System.out.print("Input number of data to dequeue: ");
		int n2 = sc.nextInt();
        for (ctr = 0; ctr < n2; ctr++)
            q.dequeue();
    }    
}

class CircularQueue 
{
    private int[] queueArray;    	
    private int rear;
    private int front;
    private int nItems;
	private int maxSize;

    public CircularQueue (int size) 
    {
        maxSize = size;
        front = -1;
        rear = -1;
        queueArray = new int[maxSize];
        nItems = 0;
    }    
    public void enqueue (int data) 
    {
       if (nItems != maxSize) 
        {
            if (rear == maxSize - 1)
                rear = -1;
            if (front == -1)
                front++;
            queueArray[++rear] = data;
            nItems++;
        }
        else
		{
            System.out.println("FULL");
		}
        print();
    }
    public void dequeue () 
    {
        if (nItems != 0)
        {
            if (front == maxSize - 1)
                front = -1;
            front++;
            nItems--;
        }
        print();   
    }   
	public int peek()
	{
		return queueArray[front];
	}
    public void print () 
    {
		if (rear < front && nItems == 0) {
            for (int i = front; i < maxSize; i++) {
                System.out.println(queueArray[i]);
            }

            for (int i = 0; i <= rear; i++) {
                System.out.println(queueArray[i]);
            }

        }

        else if (front >= rear && nItems == 0) {
            for (int i = front; i <= rear; i++) {
                System.out.println(queueArray[i]);
            }
        }
		
		else {
            System.out.println("Queue is Empty!");
        }
        /*System.out.print("[ ");
        for (int ctr = front, ctr1 = 0; ctr1 < nItems; ctr1++, ctr++) 
        {
            if (ctr == maxSize)
                ctr = 0;
            System.out.print(queueArray[ctr] + " ");
        }
        System.out.println("] " + front + " " + rear);*/
    }
}
