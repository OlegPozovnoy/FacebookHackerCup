
package com.google.jam;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.util.*;


public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    static int steps;//row 100

    static int[] preorder;
    static int preorderCount =0;

    static int[] postorder;
    static int postorderCount=0;

    static int[][] treestructure;

    static Map<Integer,Integer> correspondence;

    static void solve() throws Exception {

        int n = nextInt();
        int k = nextInt();

        preorderCount=0;
        postorderCount=0;

        preorder = new int[n];
        postorder  = new int[n];

        treestructure = new int[n][2];

        for (int i = 0; i< n ; i++)
        {
            treestructure[i][0] = nextInt();
            treestructure[i][1] = nextInt();
        }

        doPreorder(0);
        doPostorder(0);

        correspondence = new HashMap<Integer, Integer>();

        for (int i = 0; i<n;i++) {
            correspondence.put(preorder[i],postorder[i]);
        }

        int currentK=1;

        for (int i = 0; i<n;i++)
        {
            preorder[i] = 0; //K
            postorder[i] = 0; //visited
        }

        int totalVisited=0;
        int lastNotChecked=0;

        while (totalVisited<n)
        {
            while(postorder[lastNotChecked] ==1)
                lastNotChecked++;

            int startCycle = lastNotChecked;

            do{
                postorder[startCycle] = 1;
                preorder[startCycle] = currentK;
                startCycle = correspondence.get(startCycle);
                totalVisited++;
            }
            while (postorder[startCycle]!=1);

            currentK++;

        }

        printCase();

        if (currentK-1 < k)
            out.println("Impossible");

        else{
            for (int i=0;i<n;i++)
            {
                if(preorder[i]>k)
                    preorder[i]=k;
                if(i==n-1)
                    out.println(preorder[i]);
                else
                    out.print(preorder[i] + " ");
            }
        }

        return;

    }

    static void doPreorder(int node)
    {

        Stack<Integer> nodeStack = new Stack<Integer>();
        nodeStack.push(node);

        while (nodeStack.empty() == false) {

            Integer mynode = nodeStack.peek();
            preorder[preorderCount] = mynode;
            preorderCount++;

            nodeStack.pop();

            if (treestructure[mynode][1]!=0) {
                nodeStack.push(treestructure[mynode][1]-1);
            }
            if (treestructure[mynode][0]!=0) {
                nodeStack.push(treestructure[mynode][0]-1);
            }
        }

    }

    static void doPostorder(int node){

        Stack<Integer>s1 = new Stack<>();
        Stack<Integer>s2 = new Stack<>();

        s1.push(node);

        while (!s1.isEmpty())
        {
            int temp = s1.pop();
            s2.push(temp);

            if (treestructure[temp][0] != 0)
                s1.push(treestructure[temp][0]-1);
            if (treestructure[temp][1] != 0)
                s1.push(treestructure[temp][1]-1);
        }

        while (!s2.isEmpty())
        {
            int temp = s2.pop();
            postorder[postorderCount] = temp;
            postorderCount++;
        }

        return;


    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static void printlnCase() {
        out.println("Case #" + test + ":");
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            //in = new BufferedReader(new InputStreamReader(System.in));
            //out = new PrintWriter(new OutputStreamWriter(System.out));
            out = new PrintWriter(new File("C:\\GoogleCodeJam\\src\\test_out.txt"));
            in = new BufferedReader (new FileReader("C:\\GoogleCodeJam\\src\\test.txt"));
            int tests = nextInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }

}
