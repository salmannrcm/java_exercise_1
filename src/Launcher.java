import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
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
            else if("freq".equals(cmd))
            {
                System.out.println("Please enter file's path : ");
                String chemin = scanner.nextLine();
                Freq(chemin);
            }
            else
            {
                System.out.println("Unknown Command");
            }

        }while (Continue);

        System.out.println("Method finished");
    }

    private static boolean Freq(String chemin)
    {
        Path path = Paths.get(chemin);
        try {
            String content = java.nio.file.Files.readString(path);
            content = content.toLowerCase(Locale.ROOT);
            String[] words = content.split(" ");
            List<String> list = Arrays.asList(words);
            Map<Object, Integer> frequencyMap = list.stream()
                    .collect(toMap(
                            s -> s, // key is the word
                            s -> 1, // value is 1
                            Integer::sum));
            List<Object> res = list.stream()
                    .sorted(comparing(frequencyMap::get).reversed()) // sort by descending frequency
                    .distinct() // take only unique values
                    .limit(3)   // take only the first 10
                    .collect(toList()); // put it in a returned list
            //System.out.println("Most 3 used words will be displayed in decreasing order \n");
            for(int i=0;i<3;i++)
            {
                if (i != 2)
                {
                    System.out.print(res.get(i)+" ");
                }else
                {
                    System.out.print(res.get(i));
                }
            }
            System.out.println();


        } catch (Exception e) {
            System.out.println("Unreadable file: " + e.toString());
        }
        return false;
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
