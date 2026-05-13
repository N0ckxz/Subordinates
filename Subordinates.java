import java.util.*;
import java.io.*;

public class Subordinates {
    static List<Integer>[] adj;
    static int[] subordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int boss = Integer.parseInt(st.nextToken());
            adj[boss].add(i);
        }

        subordinates = new int[n + 1];
        
    }

    static void solve(int node) {
        
    }
}