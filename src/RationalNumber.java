public class RationalNumber {
  int numerator = 0;
  int denominator = 1;

  public RationalNumber() {
  }

  public RationalNumber(int numerator, int denominator) {
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }
}
