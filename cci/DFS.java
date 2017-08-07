import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        
        int maxRegion = 0; 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int rSize = regionSize(grid, i, j); 
                    if (rSize > maxRegion) {
                        maxRegion = rSize; 
                    }
                }
            }
        }
        
        System.out.println(maxRegion); 
    }
    
    public static int regionSize(int grid[][], int i, int j) {
        Stack<Pair> srcStack = new Stack<>(); 
        HashSet<Pair> visited = new HashSet<>(); 
        
        srcStack.push(new Pair(i, j)); 
        int regionSize = 0; 
        while (!srcStack.isEmpty()) {
            Pair curr = srcStack.pop(); 
            if (visited.contains(curr)) {
                continue; 
            }
            visited.add(curr); 

            regionSize++; 
            if (curr.i + 1 < grid.length && grid[curr.i+1][curr.j] ==1) { //check bottom neighbor
                Pair p = new Pair(curr.i+1, curr.j); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.i - 1 >= 0 && grid[curr.i-1][curr.j] == 1) { // check top neighbor
                Pair p = new Pair(curr.i-1, curr.j); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.j + 1 < grid[0].length && grid[curr.i][curr.j+1] == 1) { // check right neighbor
                Pair p = new Pair(curr.i, curr.j+1); 
                if (!visited.contains(p)) {
                    srcStack.push(p);
                }
            }
            
            if (curr.j - 1 >= 0 && grid[curr.i][curr.j-1] == 1) { // check left neighbor
                Pair p = new Pair(curr.i, curr.j-1); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.i - 1 >= 0 && curr.j - 1 >= 0 && grid[curr.i-1][curr.j-1] == 1) { // check left up neighbor
               Pair p = new Pair(curr.i-1, curr.j-1); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.i - 1 >= 0 && curr.j + 1 < grid[0].length && grid[curr.i-1][curr.j+1] == 1) {
                Pair p = new Pair(curr.i-1, curr.j+1); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.i + 1 < grid.length && curr.j - 1 >= 0 && grid[curr.i+1][curr.j-1] ==1) {
                Pair p = new Pair(curr.i+1, curr.j-1); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
            
            if (curr.i+1 < grid.length && curr.j + 1 < grid[0].length && grid[curr.i+1][curr.j+1] == 1) {
                Pair p = new Pair(curr.i+1, curr.j+1); 
                if (!visited.contains(p)) {
                    srcStack.push(p); 
                }
            }
        }
        
        return regionSize; 
    }
}


class Pair {
    public Pair(int i, int j) {
        this.i = i; 
        this.j = j; 
    }

    public int i; 
    public int j; 

    @Override
    public int hashCode() {
        return i*31 + j; 
    }
    
    @Override
    public boolean equals(Object o) {
        Pair p = (Pair)o; 
        return p.i == this.i && p.j == this.j; 
    }
}