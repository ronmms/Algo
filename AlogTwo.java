import java.util.ArrayList;

/**
 * Ron Cohen - 208401349 Noam Boni - 315586131
 */
public class AlogTwo {

    public static void main(String[] args) {
        int weight = 5;
        Stuff[] A = new Stuff[3];
        int[][] sum = new int[A.length][weight+1];
        // for (int i = 0; i < sum.length; i++) {
        //     for (int j = 0; j < sum[i].length; j++) {
        //         sum[i][j] = -1;
        //     }
        // }
        for (int i = 0; i < A.length; i++) {
            A[i] = new Stuff((int) (Math.random() * 5), (int) (Math.random() * 5));
        }
        for (int i = 0; i < A.length; i++) {
            System.out.println("Item " + i + " " + A[i].getPrice() + " " + A[i].getWeight());
        }
        // try {
        //     System.out.println("\n" + recAlgo(sum, A, weight, A.length - 1));
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        // System.out.println(bruteForce(A, weight, A.length));

        System.out.println("\n" + Algo(sum, A, weight));
    }

    public static int bruteForce(Stuff[] A, int weight, int size) {
        if (size == 0)
            return 0;

        if (A[size - 1].getWeight() < weight)
            return Math.max(A[size - 1].getPrice() + bruteForce(A, weight - A[size - 1].getWeight(), size - 1),
                    bruteForce(A, weight, size - 1));

        return bruteForce(A, weight, size - 1);
    }

    public static int recAlgo(int[][] arr, Stuff[] A, int weight, int i) throws Exception {
        if (i < 0 || weight == 0)
            return 0;

        if (arr[i][weight] != -1)
            return arr[i][weight];

        if (A[i].getWeight() <=  weight) {
            arr[i][weight] = Math.max(A[i].getPrice() + recAlgo(arr, A, weight - A[i].getWeight(), i - 1),
                    recAlgo(arr, A, weight, i - 1));
            return arr[i][weight];
        } else {
            if (A[i].getWeight() > weight) {
                arr[i][weight] = recAlgo(arr, A, weight, i - 1);
                return arr[i][weight];
            }
        }
        throw new Exception("Hi Ronit");
    }

    public static ArrayList<Integer> Algo(int[][] arr, Stuff[] A, int weight){
        ArrayList<Integer> best = new ArrayList<>();
        for (int j = 0; j <= weight; j++) {
            if(A[0].getWeight() <= j)
                arr[0][j] = A[0].getPrice();
        }

        for (int j = 1; j < A.length; j++) {
            for (int k = 1; k <= weight; k++) {
                int priceA = 0 , priceB = 0;
                if(A[j].getWeight() <= k)
                    priceA = A[j].getPrice() + arr[j-1][k-A[j].getWeight()];

                priceB = arr[j-1][k];
                
                arr[j][k] = Math.max(priceA, priceB);
                best.add(arr[j][k]);
            }
            
        }

        return best;

    }
    
    
}
