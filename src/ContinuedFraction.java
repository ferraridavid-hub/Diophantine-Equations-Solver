import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * This class represents a limited continued fraction 
 * associated with a rational number
 */

public class ContinuedFraction {
  private int numerator = 0;
  private int denominator = 1;
  private LinkedList<Integer> levelCoefficients = new LinkedList<>();

  public ContinuedFraction() {
  }

  public ContinuedFraction(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
    computeLevelCoefficients(numerator, denominator);
  }

  // pre: num < den and gcd(num, den) = 1
  /*
   * Compute the coefficient of each level, and push it into the levelCoefficients
   * list
   */
  public void computeLevelCoefficients(int num, int den) {
    // 0 case
    if (num == 0) {
      levelCoefficients.addLast(0);
      return;
    }
    
    if (num == 1) {
      if (den != num)
        levelCoefficients.addLast(den - num);
      levelCoefficients.addLast(1);
      return;
    }

    levelCoefficients.addLast(den / num);
    computeLevelCoefficients(den % num, num);
  }

  public List<Integer> getLevels() {
    return Collections.unmodifiableList(levelCoefficients);
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public static void main(String[] args) {
    ContinuedFraction frac = new ContinuedFraction(10, 23);
    var levels = frac.getLevels();
    System.out.println(levels);
  }

}
