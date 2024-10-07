package edu.grinnell.csc207.util;

import edu.grinnell.csc207.linear.Stack;
import edu.grinnell.csc207.linear.LinkedStack;

import java.io.PrintWriter;

/**
 * Assorted utilities for working with strings.
 * 
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */ 
public class StringUtils {
  // +------------------+--------------------------------------------
  // | Provided methods |
  // +------------------+
    
  /**
   * Determine whether the parens match in string.
   */
  public static boolean checkMatching(String str) {
    Stack<Character> parens = new LinkedStack<Character>();
    
    try {
      for (char ch : str.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
          parens.push(ch);
        } 
        else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {
          if (parens.isEmpty()) {
            return false;
          }
          char open = parens.pop();
          if (!isMatchingPair(open, ch)) {
            return false;
          }
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
      return false;
    }
    return parens.isEmpty();
  } // checkMatching
  /**
   * Helper method to check if the pair of characters matches.
   */
  private static boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
           (open == '[' && close == ']') ||
           (open == '{' && close == '}') ||
           (open == '<' && close == '>');
  }
} // class StringUtils    

