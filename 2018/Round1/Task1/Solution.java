
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
        String[] s  = new String[3];
        int [] mass = {1,0,0};
        int [] prev = {0,0,0};

        s[0] = next();
        s[1] = next();
        s[2] = next();


        for (int i = 0; i<n;i++)
        {
            prev[0] = mass[0];
            prev[1] = mass[1];
            prev[2] = mass[2];
            if(s[0].charAt(i)=='.' && s[1].charAt(i)=='.' && s[2].charAt(i)=='.')
            {
                mass[0] = prev[1];
                mass[1] = (prev[0] + prev[2]) % 1000000007;
                mass[2] = prev[1];
            }
            else if(s[0].charAt(i)=='#' && s[1].charAt(i)=='.' && s[2].charAt(i)=='.')
            {
                mass[0] = 0;
                mass[1] = prev[2];
                mass[2] = prev[1];
            }
            else if(s[0].charAt(i)=='.' && s[1].charAt(i)=='.' && s[2].charAt(i)=='#')
            {
                mass[0] = prev[1];
                mass[1] = prev[0];
                mass[2] = 0;
            }
            else
            {
                mass[0] = 0;
                mass[1] = 0;
                mass[2] = 0;
            }
        }


        printCase();
        out.println(mass[2]);

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
