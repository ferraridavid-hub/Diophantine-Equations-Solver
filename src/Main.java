import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int M, N, Z;

    System.out.println("""
      
        **********************************************
          WELCOME TO THE DIOPHANTINE EQUATION SOLVER
        **********************************************
          """);
    System.out.println("""
        I can tell you if the equation:
            Mx - Ny = Z
        with M, N, Z integers, has integer solutions.
        If I find a solution I print it on the screen...

          """);

    try (var keyb = new Scanner(System.in)) {
      System.out.println("Please, enter integer values for M, N, Z");
      M = keyb.nextInt();
      N = keyb.nextInt();
      Z = keyb.nextInt();
    }

    var solution = Solution.of(M, N, Z);
    if (solution == null)
      System.out.println("\nThe equation\n\t" + M + "x" + " - " + N + "y" + " = " + Z + "\n has no integer solutions");
    else
      System.out.println("Computed solution: " + solution); 
  }
}
