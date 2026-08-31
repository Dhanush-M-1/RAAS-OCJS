/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Darkhan
 */
public class task5 {
    public static void main(String[] args){
        int n;
        Node[] a;
        long sum;
        try (Scanner in = new Scanner (System.in)) {
            n = in.nextInt();
            a = new Node[n];
            sum = 0L;
            a[0] = new Node(0,in.nextInt());
            for (int i=1;i<n;i++){
                a[i] = new Node(i,in.nextInt());
                a[i].left = a[i-1];
                a[i-1].right = a[i];
            }
        }
        Arrays.sort(a);
        Node t;
        for (int i=0;i<n-2;i++){
            t = a[i];
            if (t.left != null && t.right != null){
                sum += Math.min(t.left.v, t.right.v);
                t.remove();
            }
            else{
                sum += t.v;
                t.remove();
            }
        }
        System.out.println(sum);
    }
}

class Node implements Comparable<Node>{
    int v,i;
    Node left, right;
    public Node(int ii, int vv){
        i = ii;
        v = vv;
    }

    @Override
    public int compareTo(Node o) {
        return v - o.v;
    }
    
    public void remove(){
        if (left != null) left.right = right;
        if (right != null) right.left = left;
    }
}