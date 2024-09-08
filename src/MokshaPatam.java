import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: Stefan Perkovic
 *
 */

public class MokshaPatam {


    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        int current_num = 1;
        boolean[] visited = new boolean[boardsize + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(current_num);
        int[] snakes_ladders = new int[boardsize + 1];
        int[] rolls = new int[boardsize + 1];

        for (int i = 0; i < snakes.length; i++){
            snakes_ladders[snakes[i][0]] = snakes[i][1];
        }
        for (int i = 0; i < ladders.length; i++){
            snakes_ladders[ladders[i][0]] = ladders[i][1];
        }

        while (!queue.isEmpty()){
            current_num = queue.remove();
            if (current_num == boardsize) {
                System.out.println(rolls[current_num]);
                return rolls[current_num];
            }
            for (int i = 1; i <= 6; i++){
                int node = current_num + i;
                if (node <= boardsize){
                    if (snakes_ladders[node] != 0){
                        node = snakes_ladders[node];
                    }

                    if (!visited[node]){
                        visited[node] = true;
                        rolls[node] = rolls[current_num] + 1;
                        queue.add(node);
                    }
                }
            }
        }
        System.out.println("-1");
        return -1;
    }
}
