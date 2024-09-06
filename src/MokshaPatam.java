import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {


    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        int current_num = 1;
        int end_num = boardsize;
        boolean visited[] = new boolean[boardsize];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(current_num);
        int rolls = 0;
        while (!queue.isEmpty()){
            current_num = queue.remove();
            if (current_num == end_num) {
                return rolls;
            }

            for (int i = 0; i < 6; i++){
                int node = current_num + i;

                if (!visited[node]){
                    queue.add(node);
                }


                if (/** Node is in a snake or ladder*/){
                    node = snakes[node];
                }
                if (/** Node is in a ladder*/){
                    node = ladders[node];
                }

            }
            rolls ++;
            visited[current_num] = true;

        }






        return 0;
    }
}
