import java.util.Arrays;
import java.util.ArrayList;

public class Node{

    private ArrayList<int[]> path = new ArrayList<int[]>();
    private int[] array;

    public Node(int[] array2, ArrayList<int[]> path2){
      array = new int[array2.length];
      for(int i=0; i<array2.length; i++){
        array[i] = array2[i];
      }
      for(int i=0; i<path2.size(); i++){
        path.add(path2.get(i));
      }
    }

    public int[] getArray(){
      return array;
    }

    public ArrayList<int[]> getPath() {
  		return path;
  	}

    public void extendPath() {
  	   path.add(array);
  	}
}
