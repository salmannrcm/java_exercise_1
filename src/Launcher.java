import java.util.Scanner;

public class Launcher
{
    public static void main(String[] args) {
        System.out.println("Hello bg");
        Scanner scanner = new Scanner(System.in);
        boolean Continue = true;
        String cmd = null;
        do {
            System.out.println("Enter any command");
            cmd = scanner.nextLine();
            if ("quit".equals(cmd))
            {
                Continue = false;
            }
            else if("fibo".equals(cmd))
            {
                System.out.println("Enter some number : ");
                String Number  = scanner.nextLine();
                int n = Integer.parseInt(Number);
                System.out.println(fibo(n));
            }
            else
            {
                System.out.println("Unknown Command");
            }

        }while (Continue);

        System.out.println("Method finished");
    }

    private static int fibo(int n) {
        if(n < 0)
        {
            throw new IllegalArgumentException("Value entered is negative");
        }
        if(n == 0 || n == 1)
            return n;
        return fibo(n-1) + fibo(n - 2);
    }
}
