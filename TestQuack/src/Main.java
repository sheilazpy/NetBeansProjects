import java.util.Scanner;
// class Main is intended for no other purpose than to test class Quack
public class Main
{
    public static void main(String[] args)
    {
       int choice, newAge, newId, newPriority;
       String newFirst, newLast;
       Patient newPatient;
       Boolean done = false;
       Quack quack = new Quack();
       Scanner keyboard = new Scanner(System.in);
       
       // This while loop continuously executes a loop that allows the user to test class Quack.
       // It is an example of how a class can be tested prior to its use in a real program.
       while (!done) 
       {
            // Each time the loop starts, the user is presented with a menu with items for exercising
            // each method of class Quack, in this case, enqueue, push, dequeue, isEmpty and isFull. There 
            // is also a menu item for terminating the loop.
            System.out.print("Enter 1 to enqueue, 2 to push, 3 to dequeue, and 4 to quit: ");
            choice = keyboard.nextInt();
            System.out.println();
            
            //This switch statement selects the proper case for the menu choice made by the user.
            switch (choice)
            {
               case 1: // Exercise the enqueue method of class Quack
                    if (quack.isFull())
                    {
                        System.out.println("Cannot enqueue, quack is full! ");
                    }
                    else
                    {     
                        System.out.print("Enter patient's first name: ");
                        newFirst = keyboard.next();
                        System.out.print("Enter patient's last name: ");
                        newLast = keyboard.next();
                        System.out.print("Enter patient's age: ");
                        newAge = keyboard.nextInt();
                        System.out.print("Enter patient's ID number: ");
                        newId = keyboard.nextInt();
                        System.out.print("Enter patient's priority: ");
                        newPriority = keyboard.nextInt();
                        newPatient = new Patient(newFirst, newLast, newAge, newId, newPriority);
                        quack.enqueue(newPatient);
                        System.out.println();
                    }
                    break;
                   case 2: // Exercise the push method of class Quack
                    if (quack.isFull())
                    {
                        System.out.println("Cannot push, quack is full! ");
                    }
                    else
                    {     
                        System.out.print("Enter patient's first name: ");
                        newFirst = keyboard.next();
                        System.out.print("Enter patient's last name: ");
                        newLast = keyboard.next();
                        System.out.print("Enter patient's age: ");
                        newAge = keyboard.nextInt();
                        System.out.print("Enter patient's ID number: ");
                        newId = keyboard.nextInt();
                        System.out.print("Enter patient's priority: ");
                        newPriority = keyboard.nextInt();
                        newPatient = new Patient(newFirst, newLast, newAge, newId, newPriority);
                        quack.push(newPatient);
                        System.out.println();
                    }
                    break;
               case 3: // Exercise the pop method of class Quack
                    if (quack.isEmpty())
                    {
                        System.out.println("Cannot dequeue, quack is empty! ");
                    }
                    else
                    {
                        System.out.println("The first patient in the quack was: " + quack.dequeue().getName());   
                        System.out.println();
                    }
                    break;
               case 4: // Set done to true so that the loop will end
                    done = true;
                    break;
               default: 
                    // This default clause handles the case that the user has typed in an integer
                    // that is not one of the valid choices
                    System.out.println("The number you entered, "+ choice + ", + is not 1, 2, 3 or 4. Try again!");
                    System.out.println();
                    break;
            }
       }
       System.out.println("...quitting");
    }
}