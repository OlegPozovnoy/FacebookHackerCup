
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



    static void solve() throws Exception {

        int n = nextInt();
        int k = nextInt();
        int v = (int)(nextLong()%n)+n;

        ArrayList<String> s = new ArrayList<>();

        for (int i=0;i<n;i++)
            s.add(next());

        //v = v%n+n;


        int startpos = ((v-1)*k)%n;
        int endpos=(v*k-1)%n;

        StringBuilder result = new StringBuilder("");

        System.out.println(startpos + " " + endpos);

        if (endpos>=startpos)
            for (int i = startpos;i<=endpos;i++)
                if (i!=endpos)
                    result.append(s.get(i) + " ");
                else
                    result.append(s.get(i));
        else
            {
                for (int i = 0;i<=endpos;i++)
                        result.append(s.get(i) + " ");


                for (int i = startpos;i<=n-1;i++)
                    if (i!=n-1)
                        result.append(s.get(i) + " ");
                    else
                        result.append(s.get(i));

            }

        printCase();
        out.println(result.toString());



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
            out = new PrintWriter(new OutputStreamWriter(System.out));

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
