
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

        String word = next();

        for (int i=1; i < word.length()-1 ; i++)
        {
            if (word.charAt(0) == word.charAt(i))
            {
                if (word.substring(i).equals( word.substring(0, word.length() - i)) == false)
                {
                    printCase();
                    out.println(word.substring(0,i) + word);
                    return;
                }
            }
        }

        printCase();
        out.println("Impossible");

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
