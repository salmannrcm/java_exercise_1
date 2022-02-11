import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Launcher
{
    public static void main(String[] args)
    {
        System.out.println("Hello bg");
        Scanner scanner = new Scanner( System.in );
        List<Command> Listcommands;
        Listcommands = new ArrayList<>();

        Fibo fibo = new Fibo();
        Freq freq = new Freq();
        Quit quit = new Quit();

        Listcommands.add(fibo);
        Listcommands.add(freq);
        Listcommands.add(quit);

        boolean end = false;
        String msg;
        int checker = 0;

        do
        {
            checker = 0;
            System.out.println("Please enter some Command : ");
            msg = scanner.nextLine();
            //System.out.println("["+(int)msg.charAt(0)+"]");
            for(Command command : Listcommands)
            {
                if (msg.equals(command.name())){
                    end = command.run(scanner);
                    checker = 1;
                    break;
                }
            }
            if(checker == 0)
            {
                System.out.println("Unknown command");
            }
        } while(!end);
        scanner.close();
    }
}
