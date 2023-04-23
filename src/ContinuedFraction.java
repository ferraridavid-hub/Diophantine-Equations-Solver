import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.lang.IllegalArgumentException;

/**
 * This class represents a limited continued fraction
 * associated with a rational number
 */

public class ContinuedFraction {
  private RationalNumber q;
  private LinkedList<Integer> levelCoefficients = new LinkedList<>();

  public ContinuedFraction() {
  }

  public ContinuedFraction(RationalNumber q) {
    this.q = q
    computeLevelCoefficients(q.getNumerator(), q.getDenominator());
  }

  // pre: num < den and gcd(num, den) = 1
  /*
   * Compute the coefficient of each level, and push it into the levelCoefficients
   * list
   */
  private void computeLevelCoefficients(int num, int den) {
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

  // return the i-th truncated fraction
  public RationalNumber getTruncated(int j) {
    if (j < 0 || j > levelCoefficients.size())
      throw new IllegalArgumentException(
          "getTruncated: cannot compute truncated fraction. The depth of this fraction is " + levelCoefficients.size());

    
  }

  public List<Integer> getLevels() {
    return Collections.unmodifiableList(levelCoefficients);
  }

  public RationalNumber getRationalNumber() {
    return q;
  }

  public static void main(String[] args) {
    ContinuedFraction frac = new ContinuedFraction(10, 23);
    var levels = frac.getLevels();
    System.out.println(levels);
  }

}
