import java.util.*;
import java.io.*;

public class Subordinates {
    static List<Integer>[] adj;
    static int[] subordinates;

    public static void main(String[] args) throws IOException { //hecho con IA, implementación para ingresar datos
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine()); //hecho con IA, convierte un String a tokens
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj[boss].add(i);
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
        
    }
}