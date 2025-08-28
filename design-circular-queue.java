class MyCircularQueue {
    private int arr[];
    private int size;
    private int Front;
    private int Rear;


    public MyCircularQueue(int k) {
        arr=new int[k];
        size=k;
        Front=-1;
        Rear=-1;
        
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(Front==-1){
            Front=0;
        }
        Rear=(Rear+1)%size;
        arr[Rear]=value;
        return true;
       
    }
       public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
       
        if(Front==Rear){
            Front=Rear=-1;

        }else{
        Front=(Front+1)%size;
        }
   return true;
     }
    public int Front() {
        if(isEmpty()){
            return -1;
        }
    return arr[Front];
       }
      public int Rear() {
           if(isEmpty()){
            return -1;
        }
       return arr[Rear];
        
    }
     public boolean isEmpty() {
     return Front==-1 && Rear==-1;
       }
        public boolean isFull() {
        return (Rear+1)%size==Front;
      
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */