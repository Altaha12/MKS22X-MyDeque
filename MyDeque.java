public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  private int actualIndex(int slots){
    if(slots>0){
      if(slots+start<data.length)return slots+start;
      if(slots+start>=data.length)return data.length-slots-start;}
    if(slots<0){
      if(slots+start>=0)return slots+start;
      if(slots+start<0)return data.length+(start+slots);}
    return 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size=0;
    start=5;
    end=5;
   }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size=0;
    start=initialCapacity/2;
    end=initialCapacity/2;
  }
  public int size(){
    return size;
  }
  @SuppressWarnings("unchecked")
  private void resize(){
    E[] newData = (E[])new Object[data.length*10];
    int index = start;
    for(int i = 0; i<=size;i++){
      newData[i]=data[actualIndex(i)];
    }
    start = 0;
    end = size;
    data = newData;
  }
  public String toString(){
    String tbr = "{";
    for(int i =start;i<end;i++)tbr+=data[i]+" ";
    tbr+="}";
    return tbr;
  }
  public void addFirst(E element){
    int trueIndex = actualIndex(-1);
    if(trueIndex!=end){
      data[trueIndex]=element;
      start=trueIndex;
      size+=1;
    }
    else{
      resize();
      addFirst(element);
    }
   }
  public void addLast(E element){
    int trueIndex = actualIndex(size+1);
    if(trueIndex!=start){
      data[trueIndex]=element;
      end=trueIndex;
      size+=1;
    }
    else{
      resize();
      addFirst(element);
    }
   }
  //public E removeFirst(){ }
  //public E removeLast(){ }
  //public E getFirst(){ }
  //public E getLast(){ }
  public static void main(String[] args) {
    MyDeque first = new MyDeque();
    System.out.println(first);
    MyDeque secnd = new MyDeque(20);
    System.out.println(secnd);
  }
}
