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
    this.q = q;
    // RationalNumber constructor guarantees that q.numerator and q.denominator are
    // coprime integers
    computeLevelCoefficients(q.getNumerator(), q.getDenominator());
  }

  // pre: num < den and gcd(num, den) = 1
  /*
   * Compute the coefficient of each level, and push it into the levelCoefficients
   * list
   */
  private void computeLevelCoefficients(int num, int den) {

    // number 0 case
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

  // return the j-th truncated fraction
  public RationalNumber getTruncated(int j) {

    if (j < 0 || j > levelCoefficients.size())
      throw new IllegalArgumentException(
          "getTruncated: cannot compute truncated fraction. The depth of this fraction is " + levelCoefficients.size());

    // two-step recursive function implementation for Mj and Nj

    if (j == 0)
      return new RationalNumber(0, 1);
    if (j == 1)
      return new RationalNumber(1, levelCoefficients.peekFirst());

    var iter = levelCoefficients.iterator();
    int m0 = 0;
    int n0 = 1;
    int m1 = 1;
    int n1 = iter.next(); // k1

    // result numerator and denominator
    int mj = 0;
    int nj = 1;

    int depth = 1;

    while (iter.hasNext() && depth < j) {
      int kj = iter.next();
      mj = kj * m1 + m0;
      m0 = m1;
      m1 = mj;

      nj = kj * n1 + n0;
      n0 = n1;
      n1 = nj;

      depth++;
    }

    return new RationalNumber(mj, nj);
  }

  public List<Integer> getLevels() {
    return Collections.unmodifiableList(levelCoefficients);
  }

  public int getDepth() {
    return levelCoefficients.size();
  }

  public RationalNumber getRationalNumber() {
    return q;
  }

  public static void main(String[] args) {
    ContinuedFraction frac = new ContinuedFraction(new RationalNumber(2, 5));
    var levels = frac.getLevels();
    System.out.println(levels);
    System.out.println("depth" + frac.getDepth());
    var rat2 = frac.getTruncated(frac.getDepth() - 1);
    System.out.println(rat2);
  }

}
