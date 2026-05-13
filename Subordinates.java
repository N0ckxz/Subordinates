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

        subordinates = new int[n + 1];
        
        // Iniciamos el cálculo desde el Director General (nodo 1)
        solve(1);

        // Hecho con IA, basicamente es un metodo de impresion mas rapido
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i]).append(i == n ? "" : " ");
        }
        System.out.println(sb.toString());
    }

    static void solve(int node) {
        for (int child : adj[node]) {
            solve(child);

            subordinates[node] += subordinates[child] + 1;
        }
    }
}