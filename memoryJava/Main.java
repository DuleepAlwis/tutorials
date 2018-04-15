package memory;

import java.util.Scanner;

public class Main 
{
    public static void main(String [] args)
    {
        Scanner input = new Scanner(System.in);
        char c = 'n';
        System.out.println("\t\t\tMain Memory");
        System.out.println("==================================================================================================================================================================");
        System.out.print("Enter the size of the Os :-");
        int p = Integer.parseInt(input.nextLine());
        System.out.print("\nEnter the size of the memory:-");
        int s = Integer.parseInt(input.nextLine());
        
        
        memory1 m = new memory1(p,s);
        System.out.println("===================================================================================================================================================================");
        System.out.println("1.Load process\t2.Remove process\t3.Print memory\t4.Exit('y')");
        //Main while loop
        while(c!='y')
        {
            try 
            {
                System.out.print("Option:-");
                int i = Integer.parseInt(input.nextLine());
                switch(i)
                {
                    case 1:
                        System.out.print("\nProcess Id :-");
                        String pid = input.nextLine();
                        System.out.print("\nProcess size :-");
                        p = Integer.parseInt(input.nextLine());
                        m.loadProcess(pid, p);
                        break;
                    case 2:
                        System.out.print("\nProcess Id :-");
                        pid = input.nextLine();
                        m.removeProcess(pid);
                        break;
                    case 3:
                        m.printMemory();
                }
            
                System.out.print("Exit(y/n):-");
                String state = input.nextLine();
                c = state.charAt(0);
             } catch (Exception e) {
                //TODO: handle exception
                System.out.println("Your input wasn't clear");
            }
        }
        System.out.println("System shut down");
            
            
        /*m.loadProcess("p1", 300);
        m.loadProcess("p2", 200);
        m.loadProcess("p3",300);
        m.loadProcess("p4", 100);
        m.removeProcess("p2");
        m.loadProcess("p4",100);
        m.loadProcess("p5", 50);
        m.printMemory();*/

    }
}