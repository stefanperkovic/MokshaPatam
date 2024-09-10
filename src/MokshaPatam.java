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

    /**
     * Finds the fewest number of moves required to reach the end of a Snakes and Ladders board.
     *
     * @param boardsize The size of the board
     * @param ladders A 2D array where each element [start, end] represents a ladder from start to end.
     * @param snakes A 2D array where each element [start, end] represents a snake from start to end.
     * @return The minimum number of moves required to reach the last cell, or -1 if it's not possible.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {
        int current_num = 1;
        // Tracks visited numbers
        boolean[] visited = new boolean[boardsize + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(current_num);
        // Holds final position after encountering a snake or ladder
        int[] snakes_ladders = new int[boardsize + 1];
        // Tracks how many rolls it took to get to current position
        int[] rolls = new int[boardsize + 1];

        // Initializes array of snakes and ladders
        for (int i = 0; i < snakes.length; i++){
            snakes_ladders[snakes[i][0]] = snakes[i][1];
        }
        for (int i = 0; i < ladders.length; i++){
            snakes_ladders[ladders[i][0]] = ladders[i][1];
        }

        // Preforms Breath-First-Search
        while (!queue.isEmpty()){
            current_num = queue.remove();
            if (current_num == boardsize) {
                return rolls[current_num];
            }
            // Goes through all possible dice roles
            for (int i = 1; i <= 6; i++){
                int node = current_num + i;
                if (node <= boardsize){
                    // Moves up/down snake or ladder
                    if (snakes_ladders[node] != 0){
                        node = snakes_ladders[node];
                    }
                    // Adds not to queue if not visited
                    if (!visited[node]){
                        visited[node] = true;
                        rolls[node] = rolls[current_num] + 1;
                        queue.add(node);
                    }
                }
            }
        }
        // Unwinnable board
        return -1;
    }
}
