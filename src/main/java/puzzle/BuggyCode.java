// @author jwwalker

package buggy;

import java.util.*;

public class BuggyCode {

  // !!!!!
  // DO NOT CHANGE ANY OF THESE METHOD SIGNATURES OR YOU WILL
  // NOT GET CREDIT FOR THAT METHOD.
  // !!!!!

 /**
  * Accepts an ArrayList of doubles and returns the
  * sum of all elements in the ArrayList.
  *
  * @param  arr an ArrayList of doubles to be summed
  * @return     the sum of all the elements in the ArrayList
  */
  public double sumArray(ArrayList<Double> arr) {
    double sum = 0;
    for (int x = 0; x < arr.size()-1; x++) {
      sum += arr.get(x);
    }
    return sum;
  }

 /**
  * Accepts two length values (assumed to be the legs of a
  * right triangle) and uses the Pythagorean theorem to return
  * the length of the hypotenuse.
  * @param length1 length of the first leg of a right triangle
  * @param length2 length of the second leg of a right triangle
  * @return        length of the hypotenuse
  */
  public double getHypotenuse(double length1, double length2) {
    return (Math.sqrt(Math.pow(length1, 2)) + Math.pow(length2, 2));
  }

 /**
  * Returns the Manhattan distance (https://en.wikipedia.org/wiki/Taxicab_geometry)
  * between two points on a 2D Cartesian coordinate system.
  * @param x1 the x component of the 1st 2D point
  * @param y1 the y component of the 1st 2D point
  * @param x2 the x component of the 2nd 2D point
  * @param y2 the y component of the 2nd 2D point
  * return    the Manhattan distance between points 1 and 2
  */
  public double manhattanDistance(double x1, double y1, double x2, double y2) {
    return ((x1 - x2) + (y1 - y2));
  }

 /**
  * Takes 2 strings and returns the following:
  *   -1 if both strings contain exactly the same text;
  *   0 if the strings have different text but are the same length;
  *   the difference in length if the strings are different lengths,
  *     where the difference is >= 1
  * @param string1 the first string to compare
  * @param string2 the second string to compare
  * @return        the difference in length between the two strings, or -1 if they're identical
  */
  public int stringDifference(String string1, String string2) {
    int ret = 0;
    if (string1 == string2) ret = -1;
    if (string1.length() == string2.length()) ret = 0;
    else ret = string1.length() - string2.length();
    return ret;
  }

 /**
  * Computes n! recursively.
  * n! = n * (n-1)!
  * 0! = 1
  *
  * @param n  factorial to calculate
  * @return   n!
  */
  public int factorial(int n) {
    if (n == 0) return 0;
    return (n * factorial(n-1));
  }

}
