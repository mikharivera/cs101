import java.util.Scanner;
public class Test 
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
		System.out.println("0[ ]-1");
		for (ctr = 0; ctr < enqueueVal; ctr++)
			q.enqueue(num);
		for (ctr = 0; ctr < num; ctr++)
			q.print();
		
		System.out.print("Input number of data to dequeue: ");
        int n = sc.nextInt();
		for (ctr = 0; ctr < n; ctr++)
            q.dequeue();
		
		for (ctr = 0; ctr < n; ctr++)
			q.print();
			
		System.out.print("Input number of data to enqueue: ");	
		int enqueueVal2 = sc.nextInt();
		int num2 = 0;
		
        System.out.print("Input " + enqueueVal2 + " data to enqueue ");
		for (ctr = 0; ctr < enqueueVal; ctr++)
			num2 = sc.nextInt();
			
        for (ctr = 0; ctr < enqueueVal2; ctr++)
            q.enqueue(num2);
		
		for (ctr = 0; ctr < num2; ctr++)
			q.print();
		
		System.out.print("Input number of data to dequeue: ");
		int n2 = sc.nextInt();
        for (ctr = 0; ctr < n2; ctr++)
            q.dequeue();
		
		for (ctr = 0; ctr < n2; ctr++)
			q.print();
		
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
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int data) 
	{
       if ( front == -1 && rear == -1 )
	   {
               front = 0;
               rear = 0;
               queueArray[rear] = nItems;
        }  
        else if((rear+1)%queueArray.length == front) 
		{
                 System.out.println("Full");
        }
        else
		{
             rear = (rear+1)%queueArray.length;
             queueArray[rear] = nItems;
        }

    }

    public int dequeue() 
	{
        int ret = 0;
		if ( front == -1 && rear == -1 )
		{
                System.out.println("invalid!");
        }
        else 
		{
            ret = queueArray[front];
            if(rear==front)
			{
                   rear = -1;
                   front = -1;
            }
            else 
			{
                front = (front+1)%queueArray.length;
            }
        }
		return ret;

    }

    public int peek() {
        return queueArray[front];
    }

   /*public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int size() {
        return nItems;
    }*/

    public void print() 
	{
        if(front==-1 && rear == -1) 
		{
			for(int i=0;i<queueArray.length;i++) 
			{
				System.out.print(".");
			}
		}
		else 
		{
			if(front<=rear) 
			{
				for(int i=0;i<=front-1;i++) 
				{ 
					System.out.print(".");   
				}
				System.out.print("+");
				for(int i=front;i<=rear;i++)
				{ 
					System.out.print(queueArray[i]);
				} 
				System.out.print("-");
				for(int i=rear+1;i<=queueArray.length-1;i++) 
				{ 
					System.out.print(".");   
				}
			}	
			else  
			{
				for(int i=0;i<=rear;i++) 
				{ 
					System.out.print(queueArray[i]);   
				}
				System.out.print("-");
				for(int i=rear+1;i<=front-1;i++) 
				{	 
					System.out.print(".");
				}	 
				System.out.print("+");
				for(int i=front;i<=queueArray.length-1;i++) 
				{ 
					System.out.print(queueArray[i]);   
				}
			}

		}
	}

}
