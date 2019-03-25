public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  //slots after start exclusive -1 start 1
  private int actualIndex(int slots){
    int start1 = start;
    for(int i = 0; i<slots;i++){
      if(start1<data.length-1)start1++;
      else start1=0;
    }
    for(int i = 0; i>slots;i--){
      if(start1>0)start1--;
      else start1=data.length-1;
    }
    return start1;
  }
  private int actualIndex1(int slots){
    int start2 = end;
    for(int i = 0; i<slots;i++){
      if(start2<data.length-1)start2++;
      else start2=0;
    }
    for(int i = 0; i>slots;i--){
      if(start2>0)start2--;
      else start2=data.length-1;
    }
    return start2;
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
    E[] newData = (E[])new Object[data.length*2];
    int slots = 0;
    while(slots<size){
      newData[slots]=data[actualIndex(slots)];
      slots++;
    }
    start = 0;
    end = size;
    data = newData;
  }
  public String toString(){
    String tbr = "{";
    int slots =0;
    while(slots<size){
      tbr+=data[actualIndex(slots)]+ " ";
      slots++;
    }
    tbr+="}";
    return tbr;
  }
  public void addFirst(E element){
    if(size==data.length)resize();
    int a = actualIndex(-1);
    data[a]=element;
    start=a;
    size++;
   }
  public void addLast(E element){
    if(size==data.length)resize();
    int a = actualIndex1(1);
    data[a]=element;
    end=a;
    size++;
  }
  public E removeFirst(){
    E tbr = data[start];
    data[start]=null;
    start=actualIndex(1);
    size--;
    return tbr;
  }
  //public E removeLast(){ }
  public E getFirst(){
    return data[start];
   }
  //public E getLast(){ }
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    MyDeque test = new MyDeque();
    System.out.println(test);
    for(int i=0;i<50;i++){
      test.addFirst(i);
      System.out.println(test);
    }
    for(int i=0;i<50;i++){
      System.out.println(test);
      System.out.println(test.removeFirst());
    }
    System.out.println(test);


  }
}
