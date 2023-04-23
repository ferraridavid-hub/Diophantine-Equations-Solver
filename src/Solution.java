public class Solution {
  private int x;
  private int y;

  private static int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public static Solution of(int M, int N, int Z) {

    // special case
    if (gcd(M, N) != 1) {
      if (gcd(M, N) == Z && gcd(M / Z, N / Z) == 1)
        return solveBaseEquation(M / Z, N / Z);
      else
        return null;
    }

    // general case: M, N coprime integers
    var solution = solveBaseEquation(M, N);
    solution.x = Z * solution.x;
    solution.y = Z * solution.y;
    return solution;

  }

  // pre: gcd(M, N) = 1
  private static Solution solveBaseEquation(int M, int N) {
    ContinuedFraction frac = new ContinuedFraction(new RationalNumber(M, N));

    // continued fraction height
    int fracDepth = frac.getLevels().size();
  
    // even case
    if (fracDepth % 2 == 0) {

    }
    return new Solution();
  }
}
