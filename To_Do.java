import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class To_Do {
    private Scanner inp = new Scanner(System.in);
    ArrayList<String> List = new ArrayList<>();
    private String name;

    public To_Do() {
        intro();
    }

    private void intro(){
        System.out.print("Enter your name: ");
        name = inp.nextLine();

        System.out.print("\n");
        help();
    }

    private void enter_item() {
        String item;

        System.out.print("Enter the item you want to add: ");
        item = inp.nextLine();
        List.add(item);
        System.out.println(item + " added successfully!" + "\n");
    }

    private void view_items() {
        int count = 0;

        System.out.println("--------------------------------------------------------");
        System.out.println(name + "s To-Do List");
        System.out.println("--------------------------------------------------------");

        if (List.size() != 0) {
            for (String i : List) {
                count++;
                System.out.println(count + ".   " + i);
            }
        }
        else if (List.size() == 0){
            System.out.println("Your To-Do list is empty :/" + "\n" + "type add to add items!");
        }

        System.out.println("--------------------------------------------------------" + "\n");
    }

    private void change_name(){
        Scanner new_name = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = new_name.nextLine();
        System.out.println("Name changed to " + name + "! \n");
    }

    private void clear() {
        List.clear();
        System.out.println(name + "s To-Do List cleared successfully!" + "\n");
    }

    private void remove() {
        int item_index = 0;
        boolean converted = true;
        boolean index_found = true;
        String removed_item = null;

        Scanner remove_pos = new Scanner(System.in);

        System.out.print("Enter the position of the item: ");

        try {
            item_index = remove_pos.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("You need to enter an integer -_-" + "\n");
            converted = false;
        }

        if (converted) {
            try {
                removed_item = List.get(item_index - 1);
            }
            catch (IndexOutOfBoundsException error){
                System.out.println("That's not a valid position" + "\n");
                index_found = false;
            }
        }

        if (converted && index_found) {
            List.remove(removed_item);

            System.out.println(removed_item + " removed!" + "\n");
        }
    }

    private String ask_user() {
        String user_inp;
        System.out.print("What do u want to do?: ");
        user_inp = inp.nextLine();
        System.out.print("\n");
        return user_inp;
    }

    private void Master() {
        String curr_user;
        curr_user = ask_user();

        if (curr_user.equalsIgnoreCase("add")) {
            enter_item();
        } else if (curr_user.equalsIgnoreCase("view")) {
            view_items();
        } else if (curr_user.equalsIgnoreCase("remove")) {
            remove();
        } else if (curr_user.equalsIgnoreCase("clear")) {
            clear();
        } else if (curr_user.equalsIgnoreCase("help")) {
            help();
        } else if(curr_user.equalsIgnoreCase("change_name")){
            change_name();
        }
        else {
            System.out.println("That's not a valid option" + "\n");
        }
    }

    public void help() {
        System.out.println("hey " + name + "! You can use the following commands:");
        System.out.println("1. add");
        System.out.println("2. remove");
        System.out.println("3. clear");
        System.out.println("4. view");
        System.out.println("5. help");
        System.out.println("6. change_name");
        System.out.print("\n");
    }

    void run() {
        do {
            Master();
        } while (true);
    }
}