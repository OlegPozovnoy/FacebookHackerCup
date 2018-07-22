
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

   /* static int[] preorder;
    static int preorderCount =0;

    static int[] postorder;
    static int postorderCount=0;

    static int[][] treestructure;

    static Map<Integer,Integer> correspondence;
*/
    static void solve() throws Exception {

        int N = nextInt();
        int M = nextInt();

        double[] H = new double[N];

        H[0] = nextInt();
        H[1] = nextInt();

        int W = nextInt();
        int X = nextInt();
        int Y = nextInt();
        int Z = nextInt();

        int[] A = new int[M];
        int[] B = new int[M];
        int[] U = new int[M];
        int[] D = new int[M];

        for (int i = 0; i < M; i++) {
            A[i] = nextInt();
            B[i] = nextInt();
            U[i] = nextInt();
            D[i] = nextInt();
        }

        for (int i = 2; i < N; i++)
            H[i] = (((long) W * (long)H[i - 2]) % Z + ((long) X * (long)H[i - 1]) % Z + (Y % Z)) % Z;

        // revert direction

        for (int i = 0, tmp; i < M; i++)
        {
            if (A[i]>B[i])
            {
                tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;

                tmp = U[i];
                U[i] = D[i];
                D[i] = tmp;
            }

        }

        // compress

        ArrayList<Long> Nodes = new ArrayList<Long>();
        for (int i = 0 ; i<M ; i++) {
            Nodes.add((long)A[i]);
            Nodes.add((long)B[i]);
        }
        Nodes.add(1L);
        Nodes.add((long)(N));

        //delete unnecessary nodes

        Collections.sort(Nodes);

        for (int i = Nodes.size()-1; i>=1; i--)
        {
            if (Nodes.get(i) == Nodes.get(i-1))
            {
                Nodes.remove(i);
            }
        }
        //calc Up and Down constraints
        int[] Up = new int[Nodes.size()];
        int[] Down = new int[Nodes.size()];

        for (int i=0; i< Nodes.size();i++)
        {
            Up[i] = Z;
            Down[i] = Z;

            for (int j=0;j<M; j++)
            {
                if (A[j]<=Nodes.get(i) && B[j]>Nodes.get(i))
                    {
                        Up[i] = Math.min(Up[i], U[j]);
                        Down[i] = Math.min(Down[i], D[j]);
                    }
            }
        }


        //calc result.

        double result = 0;
        double lastshift = 0;

        double currentUp;
        double currentDown;
        int currentM = 0;

        double CurrentTop = H[0];
        double CurrentBottom = H[0];


        for (int i=1;i<=N-1;i++)
        {
            while (Nodes.get(currentM+1)<= i )
                currentM++;

            currentUp = Up[currentM];
            currentDown = Down[currentM];

            if (H[i]>CurrentTop + currentUp)
            {
                result = Math.max(result,(H[i] - CurrentTop - currentUp)/2 );
            }

            if (H[i]<CurrentBottom - currentDown)
            {
                result = Math.max(result,(-H[i] + CurrentBottom - currentDown)/2 );
            }

                CurrentBottom = Math.max(H[i],CurrentBottom - currentDown);
                CurrentTop = Math.min(H[i],CurrentTop + currentUp);


/*            if (H[i] + currentUp < H[i+1])
            {
                H[i] += Math.min(result-lastshift,H[i+1]-H[i] - currentUp); //moving Hi Up;

                if (H[i] + currentUp < H[i+1])
                    {
                        lastshift = Math.min(H[i+1] - H[i] - currentUp, result);
                        H[i+1] -= lastshift;


                        if (H[i] + currentUp < H[i+1])
                        {
                            lastshift += (H[i+1] - H[i] - currentUp, result);
                            result = lastshift;
                            H[i+1] -= lastshift;


                        }
                    }



                result = Math.max(result, (H[i+1] - H[i] -currentUp)/2.0);
                H[i+1] -=  (H[i+1] - H[i] - currentUp)/2.0;
                H[i] +=  (H[i+1] - H[i] - currentUp)/2.0;
            }

            if (H[i] -currentDown >H[i+1])
            {
                result = Math.max(result, (H[i] - currentDown - H[i+1])/2.0);
                H[i+1] +=   (H[i] - currentDown - H[i+1])/2.0;
                H[i] -=   (H[i] - currentDown - H[i+1])/2.0;
            }
            else
                lastshift = 0;
*/
        }


        printCase();
        out.println(result);

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
