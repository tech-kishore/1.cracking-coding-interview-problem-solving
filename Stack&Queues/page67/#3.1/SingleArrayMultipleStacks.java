// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class SingleArrayMultipleStacks {
    public static void main(String[] args) throws Exception{
        // System.out.println("Hello, World!");
        Work w=new Work(5,5);
        w.push(0,2000);
        w.push(0,3000);
        w.push(0,4000);
        // w.push(0,5000);
        // w.push(0,6000);
        w.push(1,17000);
        w.push(1,18000);
        w.push(1,19000);
        // w.push(1,110000);
        // w.push(1,111000);
        w.push(2,212000);
        w.push(2,213000);
        w.push(3,313000);
        w.push(4,555000);
        w.push(4,565000);
        w.push(4,575000);
        w.push(4,585000);
        w.push(4,595000);
        // w.printAll();
        
        System.out.printf("top 0 - %d\n",w.getTop(0));
        System.out.printf("top 1 - %d\n",w.getTop(1));
        System.out.printf("top 2 - %d\n",w.getTop(2));
        System.out.printf("top 3 - %d\n",w.getTop(3));
        System.out.printf("top 4 - %d\n",w.getTop(4));
        System.out.println("\n");
        System.out.printf("Stack - %d : %d\n",3,w.peek(3));
        System.out.printf("Stack - %d : %d\n",4,w.peek(4));
        System.out.printf("POP: Stack - %d : %d\n",3,w.pop(3));
        System.out.printf("POP: Stack - %d : %d\n",3,w.peek(3));
        System.out.printf("Stack - %d : %d\n",4,w.peek(4));
    }
}

class Work{
    //READ noOfStacks,sizeOfStack
    private int noOfStacks;
    private int sizeOfStack;
    
    //DECLARE valueArr:ARRAY[0:SIZE_OF_ARRAY]
    private int[] valueArr;
    
    //DECLARE topArr:ARRAY[0:noOfStacks]
    private int[] topArr;
    
    public int getTop(int stackNum){
        return topArr[stackNum];
    }
    
    public Work(int _noOfStacks, int _sizeOfStack){
        this.noOfStacks=_noOfStacks;
        this.sizeOfStack=_sizeOfStack;
        init();
    }
    
    private void init(){
        //COMPUTE SIZE_OF_ARRAY=noOfStacks*sizeOfStack
        int SIZE_OF_ARRAY=noOfStacks*sizeOfStack;
        
        //DECLARE valueArr:ARRAY[0:SIZE_OF_ARRAY]
        valueArr=new int[SIZE_OF_ARRAY];
    
        //DECLARE topArr:ARRAY[0:noOfStacks]
        topArr=new int[noOfStacks];
        //initialize
        for(int i=0;i<topArr.length;i++)
            topArr[i]=i*sizeOfStack;

    }
    
    private boolean isFull(int stackNum){
        int top = topArr[stackNum];
        int stackEnd=sizeOfStack*(stackNum + 1);
        // System.out.printf("%d - %d ",top,stackEnd);
        return stackEnd<=top;
    }
    
    //FUNCTION push(stack No, new value)
    public void push(int stackNo,int value) throws Exception{
        
        // check if stack is full
        if(isFull(stackNo))
            throw new Exception("Stack-"+stackNo + " is full!");
        
        // get current top(value index) of respective stackNum
            int top = topArr[stackNo];
        // add value in values array
            valueArr[top]= value;
        // increment top value in respective stackNum
            topArr[stackNo]++;  // next top;
    
    }//FUNCTIONEND
    
    private boolean isEmpty(int stackNum){
        int top = topArr[stackNum];
        int start = stackNum*sizeOfStack; // start index of stack
        return top==start;
    }
    
    //FUNCTION push(stack No, new value)
    public int peek(int stackNum) throws Exception{
        //CHECK IF STACK IS EMPTY\
        if(isEmpty(stackNum))
            throw new Exception("Stack-"+stackNum+" is empty!");
        //GET TOP VALUE
        int curr_top=topArr[stackNum]-1; // top is for next element; -1 for existing top element
        int value = valueArr[curr_top];
        //RETURN
        return value;
     }//FUNCTIONEND
     
    //FUNCTION pop(stack No, new value)
    public int pop(int stackNum) throws Exception{
        //CHECK IF STACK IS EMPTY\
        if(isEmpty(stackNum))
            throw new Exception("Stack-"+stackNum+" is empty!");
        //GET TOP VALUE
        int curr_top=topArr[stackNum]-1; // top is for next element; -1 for existing top element
        int value = valueArr[curr_top];
        topArr[stackNum]--; // remove top
        //RETURN
        return value;
     }//FUNCTIONEND
    
    public void printAll(){
        for(int i=0;i<valueArr.length;i++)
            System.out.printf("%d - ",valueArr[i]);
    }
}