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
        int visited = {};
        int previous_number[] = {};
        Queue<Integer> queue = new PriorityQueue<>();
        while (current_num != end_num){
            for (int i = 0; i < ladders.length; i++)
                if (ladders[current_num][i]){
                    current_num = ladders[][i];
                }
                else if (snakes[current_num][i]){
                    current_num = snakes[][i];

                }


            for (int i = 0; i < 6; i++){
                queue.add(current_num + i);
                visited += current_num + i;
                previous_number[current_num + i] = current_num;


            }



        }






        return 0;
    }
}
