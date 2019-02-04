import java.util.ArrayList;
import java.util.ArrayList.*;

public class QueueWorklist {

  private ArrayList<MazeCell> elements;

  public QueueWorklist() {
    elements = new ArrayList<>(0);
  }

  public void add(MazeCell m) {
    elements.add(m);
  }


  public MazeCell remove() {
    MazeCell temp;
    temp = elements.remove(0);
    return temp;
  }


  public boolean isEmpty() {
    return elements.isEmpty();
  }
}



