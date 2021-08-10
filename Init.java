import java.util.Scanner;
import java.util.Arrays;

public class Init{
    private int[] array;


    public Init(){
    }

    public void readNumber(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Give numbers separated by commmas:");
        String inputString = sc.nextLine();
        String[] res = inputString.split(",");
        int n = res.length;
        array = new int[n];
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(res[i]);
        }
        sc.close();
    }

    public int[] getArray(){
        return array;
    }

    public static void main(String args[]){
        Init initializer = new Init();
        initializer.readNumber();
        //int[] x = {5,3,2,6,1,4};
        int[] array = initializer.getArray();
        Ask1 test = new Ask1();
        System.out.println("\nUCS result here:");
        long start = System.currentTimeMillis();
        test.executeUcs(array);
        long end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start));
        System.out.println("\nAStar result here:");
        start = System.currentTimeMillis();
        test.aStar(array);
        end = System.currentTimeMillis();
        System.out.println("Time: "+(end-start));

    }
}
