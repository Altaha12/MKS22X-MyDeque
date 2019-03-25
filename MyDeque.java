import java.util.NoSuchElementException;
import java.lang.NullPointerException;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  //slots after start exclusive -1 start 1
  private int actualIndex(int slots){
    int  x;
    if(slots>=0){
      x=(start + slots)%data.length;}
    else{
      x=slots%data.length+start;
      if(x<0)
        {x=data.length+x;}
       }
    return x;
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
  public void addFirst(E element)throws NullPointerException{
    if(element == null)throw new NullPointerException();
    if(size==data.length)resize();
    int a = actualIndex(-1);
    data[a]=element;
    start=a;
    size++;
   }
  public void addLast(E element)throws NullPointerException{
    if(element == null)throw new NullPointerException();
    if(size==data.length)resize();
    int a = actualIndex(size);
    data[a]=element;
    end=a;
    size++;
  }
  public E removeFirst() throws NoSuchElementException{
    if(size==0) throw new NoSuchElementException();
    E tbr = data[start];
    data[start]=null;
    start=actualIndex(1);
    size--;
    return tbr;
  }
  public E removeLast()throws NoSuchElementException{
    if(size==0) throw new NoSuchElementException();
    final E tbr = data[end];
    data[end]=null;
    end=actualIndex(size-2);
    size--;
    return tbr;
   }
  public E getFirst()throws NoSuchElementException{
    if(size==0) throw new NoSuchElementException();
    return data[start];
   }
  public E getLast()throws NoSuchElementException{
    if(size==0) throw new NoSuchElementException();
    return data[end];
   }
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
  }
}
