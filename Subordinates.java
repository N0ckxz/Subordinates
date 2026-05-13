import java.util.*;
import java.io.*;

public class Subordinates {
    static int n;
    static List<Integer>[] adj;
    static int[] subordinates;

    public static void main(String[] args) throws IOException { //hecho con IA, implementación para ingresar datos

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        if (line == null) return;
        int n = Integer.parseInt(line);
        
        if (n == 1) {
            System.out.println(0);
            return;
        }
        //Implementacion de un algoritmo de busqueda mas eficiente, ya que fallaron 3 tests
        int[] parent = new int[n + 1];
        int[] childCount = new int[n + 1];
        int[] subCount = new int[n + 1];

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
                // Sumamos los subordinados del hijo + el hijo mismo al jefe
                subCount[boss] += (subCount[current] + 1);
                childCount[boss]--;
                
                if (childCount[boss] == 0) {
                    queue.add(boss);
                }
            }
        }

        // Salida de datos movida dentro del método main
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subCount[i]).append(i == n ? "" : " ");
        }
        System.out.println(sb.toString());
    }
}