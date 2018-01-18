import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by mohamed on 6/18/17.
 */
public class prim2 {
//    public static void main(String[] args) {
//        ArrayList<int[][]> matrices = readInput();
//
//        for(int[][] matrix : matrices) {
//            prim(matrix);
//        }
//    }
//
//
//    private static ArrayList<int[][]> readInput() {
//        ArrayList<int[][]> list = new ArrayList<>(1);
//        int graph[][] = {{0, 3, 1, 6, 0,0},
//                {3, 0, 5, 0, 3,0},
//                {0, 3, 0, 0, 7},
//                {6, 8, 0, 0, 9},
//                {0, 5, 7, 9, 0},
//        };
//        list.add(graph);
//        return list;
//    }
//
//
//    /**
//     * This method accepts tge adjacency matrix of the graph and prints out the output MST.
//     * <p>
//     *     Example of output is:
//     *     (0,1), (1,2), (1,4), (2,5), (5,3)
//     *     Where the numbers are indices of the vertices.
//     * </p>
//     * @param matrix an <code>n*n</code> adjacency matrix of input graph
//     */
//    private static void prim(int[][] matrix) {
//        // Complete this method
//        int i, j, k, x, y;
//        int V = matrix.length;
//        boolean[] Reached = new boolean[V];	// Reach/unreach nodes
//        int[] predNode = new int[V];		// Remember min cost edge
//
//      /* -----------------------------------
//         ReachSet = {0};
//	 UnReachSet = {1, 2, ..., N-1};
//	 ----------------------------------- */
//        Reached[0] = true;
//
//        for ( i = 1; i < V; i++ )
//        {
//            Reached[i] = false;
//        }
//
//        predNode[0] = 0;  // This is not necessary....
//        // Just make sure we don't have a bogus edge
//
//
//      /* =====================================================
//         UnReachSet will decreas by 1 node in each iteration
//	 There are NNodes-1 unreached nodes; so we can loop
//	 NNodes-1 times and UnReachSet will become empty !
//	 =====================================================  */
//        for ( k = 1; k < V; k++) // Loop NNodes-1 times (UnReachSet = empty)
//        {
//	 /* ================================================================
//            Find min. cost link between: reached node ---> unreached node
//            ================================================================ */
//            x = y = 0;
//
//            for ( i = 0; i < V; i++ )
//                for ( j = 0; j < V; j++ )
//                {
//                    if ( Reached[i] && ! Reached[j] &&
////                            matrix[i][j] < LinkCostes[x][y] )
//                    {
//                        x = i;     // Link (i,j) has lower cost !!!
//                        y = j;
//                    }
//                }
//
//	 /* ===============================
//            Add e (x,y) to Spanning tree
//            =============================== */
//            predNode[y] = x;
//
//	 /* ==========================================
//	    ReachSet = ReachSet ∪ {y}
//	    UnReachSet = UnReachSet - {y}
//	    ========================================== */
//            Reached[y] = true;
//        }

}
