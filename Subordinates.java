import java.util.*;
import java.io.*;

public class Subordinates {
    static List<Integer>[] adj;
    static int[] subordinates;

    public static void main(String[] args) throws IOException { //hecho con IA, implementación para ingresar datos
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        //Implementacion de un algoritmo de busqueda mas eficiente, ya que fallaron 3 tests
        int[] parent = new int[n + 1];
        int[] childCount = new int[n + 1];
        int[] subordinates = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine()); //hecho con IA, convierte un String a tokens
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            parent[i] = boss;
            childCount[boss]++; // Contamos cuántos hijos directos tiene cada jefe
        }

        Deque<Integer> queue = new ArrayDeque<>(); //cola para procesar hijos pendientes
        for (int i = 1; i <= n; i++) {
            if (childCount[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            int boss = parent[current];
            if (boss != 0) {

                subordinates[boss] += (subordinates[current] + 1);
                childCount[boss]--;
                
                if (childCount[boss] == 0) {
                    queue.add(boss);
                }
            }
        }
    }

    static void solve(int node) {
        for (int child : adj[node]) {
            solve(child);

            subordinates[node] += subordinates[child] + 1;
        }
    }
}