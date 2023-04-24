/* TODO:
 * - find the solution nearest to the origin
 */

public class Solution {
  private int x;
  private int y;

  public Solution(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static Solution of(int M, int N, int Z) {

    if (M == 0) {
      if (Z % N == 0)
        return new Solution(0, -Z / N);
      else
        return null;
    }

    if (N == 0) {
      if (Z % M == 0)
        return new Solution(Z / M, 0);
      else
        return null;
    }

    // special case: M and N are not coprime integers
    if (Utils.gcd(M, N) != 1) {
      if (Utils.gcd(M, N) == Z && Utils.gcd(M / Z, N / Z) == 1)
        return solveBaseEquation(M / Z, N / Z);
      else
        return null;
    }

    // general case: M, N are coprime integers
    var solution = solveBaseEquation(M, N);
    solution.x = Z * solution.x;
    solution.y = Z * solution.y;
    return solution;

  }

  // pre: gcd(M, N) = 1
  private static Solution solveBaseEquation(int M, int N) {
    Solution s;
    boolean swapped = false;

    // swap M and N if M > N to perform the same algorithm. At the end the solution
    // is negate
    if (M > N) {
      int t = M;
      M = N;
      N = t;
      swapped = true;
    }

    ContinuedFraction frac = new ContinuedFraction(new RationalNumber(M, N));

    int fracDepth = frac.getDepth();
    // even case
    if (fracDepth % 2 == 0) {

      var temp = frac.getTruncated(fracDepth - 2);
      if (swapped)
        s = new Solution(temp.numerator, temp.denominator);
      else
        s = new Solution(temp.denominator, temp.numerator);

    } else { // odd case

      var temp = frac.getTruncated(fracDepth - 1);
      if (swapped)
        s = new Solution(temp.numerator, temp.denominator);
      else
        s = new Solution(temp.denominator, temp.numerator);

    }

    // if M > N the algorithm is the same, but to find a solution we need the
    // negative of the M < N case
    if (swapped) {
      s.x = -s.x;
      s.y = -s.y;
    }

    return s;
  }

  public String toString() {
    return "(" + x + ", " + y + ")";
  }
}