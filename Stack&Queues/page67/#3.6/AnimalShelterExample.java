public class AnimalShelterExample{
    public static void main(String[] args) throws Exception {
        
        AnimalShelterQueue q=new AnimalShelterQueue();
        
        q.enqueue(new Cat("C1"));
        q.enqueue(new Dog("D1"));
        q.enqueue(new Cat("C2"));
        q.enqueue(new Dog("D2"));
        
        
        try{
            System.out.printf("DQ Dog: %s\n", q.dequeueDog().getName());
            System.out.printf("DQ Any: %s\n", q.dequeueAny().getName());
            System.out.printf("Peek 2: %s\n", q.peek().getName());
            
        }catch(Exception e){
             System.out.println(e.getMessage());
        }
    }
}

class Animal{
    
    private String name;
    protected int counter;
    
    public Animal(String name){
        this.name=name;    
    }
    
    public String getName(){
        return this.name;
    }
    
}

class Cat extends Animal{
    public Cat(String n){
        super(n);
    }
}

class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}

// WORK HERE >>>> Fine tune
class AnimalShelterQueue extends Queue<Animal>{
    private Queue<Animal> catQ = new Queue<>();
    private Queue<Animal> dogQ = new Queue<>();
    
    private int animalCounter;
    
    public void enqueue(Animal data){
        if(data instanceof Dog){
            Dog dog = (Dog) data;
            dog.counter = ++animalCounter;
            dogQ.enqueue(dog);
            return;
        }
        
        if(data instanceof Cat){
            Cat cat = (Cat) data;
            cat.counter = ++animalCounter;
            catQ.enqueue(cat);
            return;
        }
         // set counter in animal
         // super queue
    }
    
    private int getCatCounter() throws Exception{
        if(catQ.isEmpty()){
            return 0;
        }
        return catQ.peek().counter;
    }
    
    private int getDogCounter() throws Exception{
        if(dogQ.isEmpty()){
            return 0;
        }
        return dogQ.peek().counter;
    }
    
    // Remove either the oldest DOG or the oldest CAT 
    public Animal dequeueAny() throws Exception{
        int catC=getCatCounter(),dogC=getDogCounter();
        return catC <= dogC ? catQ.dequeue():dogQ.dequeue();
    }
    
    public Animal peek() throws Exception{
        int catC=getCatCounter(),dogC=getDogCounter();
        return catC <= dogC ? catQ.peek():dogQ.peek();
    }
    
    // Remove only the oldest DOG
    public Animal dequeueDog() throws Exception{
        return dogQ.dequeue();
    }
    
    // Remove only the oldest CAT
    public Animal dequeueCat() throws Exception{
        return catQ.dequeue();
    }
    
    
}

class Queue<T>{
    private QueueNode<T> front;
    private QueueNode<T> rear;
    
    public Queue(){
    }
    
    public Queue(T data){
        front=new QueueNode(data);
        rear=front;
    }
    
    private class QueueNode<T>{
        T data;
        QueueNode next;
        
        QueueNode(T _data){
            this.data=_data;    
        }
    }
    
    public boolean isEmpty(){
        return front==null;    
    }
    
    public void enqueue(T data){
        QueueNode newNode=new QueueNode(data);
        // check empty queue for NULL
        if(isEmpty())
        {
            front=newNode;
            rear=front;
            return;
        }
        
        rear.next=newNode; // link new node behind current rear
        rear=rear.next; // mark new node as rear
    }
    
    public T dequeue() throws Exception{
        if(isEmpty())
            throw new Exception("dequeue: No element");
            
        T value = front.data;
        front=front.next; // remove current front
        return value;
    }
    
    public T peek() throws Exception{
        if(isEmpty()) 
            throw new Exception("Peek: No element");
        return front.data;
    }
}