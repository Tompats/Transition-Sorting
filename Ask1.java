import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class Ask1 {

    //private ArrayList<int []> all_paths = new ArrayList<int []>();

    public Ask1(){
    }

    public void executeUcs(int[] array){
        ArrayList<Node> queue = new ArrayList<Node>();
        ArrayList<int []> path = new ArrayList<int []>();
        ArrayList<int []> visited = new ArrayList<int []>();
        Node starting_node = new Node(array,path);
        queue.add(starting_node);

        while (!queue.isEmpty()){
            Node temp_node = queue.get(0);
            int[] temp_array = temp_node.getArray();
            queue.remove(0);
            visited.add(temp_array);


            if(isFinalState(temp_array)){
                temp_node.extendPath();
                printer(temp_node.getPath());
                break;
            }
            else{
                temp_node.extendPath();
                for(int i=2; i<=temp_array.length; i++){
                    int[] trans_array = transition(temp_array, i);
                    if(contains_custom(visited,trans_array)){
                    }
                    else{
                        Node child_node = new Node(trans_array,temp_node.getPath());
                        queue.add(child_node);
                    }
                }
            }
        }
    }

    public void aStar(int[] array){
        //ArrayList<Node> sorted_queue = new ArrayList<Node>();
        ArrayList<Node> unsorted_queue = new ArrayList<Node>();
        ArrayList<Node> queue = new ArrayList<Node>();
        ArrayList<int []> path = new ArrayList<int []>();
        ArrayList<int []> visited = new ArrayList<int []>();
        Node starting_node = new Node(array,path);
        queue.add(starting_node);
        while (!queue.isEmpty()){
            Node temp_node = queue.get(0);
            int[] temp_array = temp_node.getArray();
            queue.remove(0);
            visited.add(temp_array);
            if(isFinalState(temp_array)){
                temp_node.extendPath();
                printer(temp_node.getPath());
                break;
            }
            else{
                temp_node.extendPath();
                for(int i=2; i<=temp_array.length; i++){
                    int[] trans_array = transition(temp_array, i);
                    if(contains_custom(visited,trans_array)){
                    }
                    else{
                        Node child_node = new Node(trans_array,temp_node.getPath());
                        unsorted_queue.add(child_node);
                    }
                }
                //int min_score = heuristic(unsorted_queue.get(0).getArray());
                //sorted_queue.add(unsorted_queue.get(0));
                for(int j=0; j<unsorted_queue.size(); j++){
                    for(int k=1; k<unsorted_queue.size()-j; k++){
                        //if(min_score>heuristic(unsorted_queue.get(j).getArray())){
                            //sorted_queue.add(0,unsorted_queue.get(j));
                            int min_score = heuristic(unsorted_queue.get(j).getArray());
                            int min_score2 = heuristic(unsorted_queue.get(k).getArray());
                            if(min_score < min_score2){
                                Collections.swap(unsorted_queue,j,k);
                            }
                      }
                  }
                    //System.out.println("min "+min_score);
                for(int j=0; j<unsorted_queue.size(); j++){
                    queue.add(unsorted_queue.get(j));
                }
                unsorted_queue.clear();
                //sorted_queue.clear();
            }
        }
    }


    public Boolean contains_custom(ArrayList<int[]> array1,int[] array2){
        for(int i=0; i<array1.size(); i++){
            int counter = 0;
            int[] aa = array1.get(i);
            for(int j =0; j<aa.length; j++){
                if(array2[j] == aa[j]){
                    counter++;
                }
            }
            if(counter==array2.length){
              return true;
            }
        }
        return false;
    }

    public int[] transition(int[] array, int k){
        int[] trans = new int[array.length];
        int[] reverser = new int[k];
        for(int j=0; j<array.length; j++){
           if(j<k){
               reverser[j] = array[j];
           }
            trans[j] = array[j];
        }
        reverser = reverse(reverser,k);
        for(int i=0; i<k; i++){
            trans[i] = reverser[i];
        }
        return trans;
    }


    public int[] reverse(int a[], int n)
    {
        int[] reversed_array = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            reversed_array[j - 1] = a[i];
            j = j - 1;
        }
        return reversed_array;
    }

    public Boolean isFinalState(int[] array){
        int[] array_to = array.clone();
        Arrays.sort(array_to);
        if(Arrays.equals(array,array_to)){
            return true;
        }
        return false;
    }



    public void printer(ArrayList<int []> path){
        System.out.print("Solution: ");
        for(int i =0; i<path.size(); i++){
            int[] t = path.get(i);
            System.out.print("[");
            for(int j=0; j<t.length; j++){
                System.out.print(t[j]);
                if(j<t.length-1){
                    System.out.print(",");
                }
            }
            System.out.print("]\t");
        }

        System.out.println("Total Size:"+path.size());
    }





    public int heuristic(int[] array){
        int score = 0;
        int[] array_sorted = array.clone();
        Arrays.sort(array_sorted);
        for(int i=0; i<array.length;i++){
            if(array[i]==array_sorted[i]){
                score++;
            }
        }
        return score;
    }



}
