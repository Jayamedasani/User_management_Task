package user.task;

import java.util.*;
import java.io.*;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void display(ArrayList<User> list) {
        if (list.isEmpty()) {
            System.out.println("No Users are available");
        } else {
            for (User user : list) {
                System.out.println("User_ID:" + user.getId() + "\tName:" + user.getName() + "\tAddress:" + user.getAddress());
            }
        }
    }

    public void addUser(ArrayList<User> list) {
        System.out.println("Enter User ID:");
        int id = sc.nextInt();
        System.out.println("Enter User Name:");
        String name = sc.next();
        System.out.println("Enter User Address:");
        String address = sc.next();
        list.add(new User(id, name, address));
        System.out.println("User Added to list!");
    }

    public void deleteUser(ArrayList<User> list) {
        if (list.isEmpty()) {
            System.out.println("Users List is empty can't delete from list");
        } else {
            System.out.println("Enter user_ID to remove:");
            int id = sc.nextInt();
            ArrayList<Integer> idList = new ArrayList<>();
            for (User user : list) {
                idList.add(user.getId());
            }
            if (idList.contains(id)) {
                Iterator<User> itr = list.iterator();
                while (itr.hasNext()) {
                    User user = itr.next();
                    if (user.getId() == id) {
                        itr.remove();
                        System.out.println("User removed from list!");
                        break;
                    }
                }
            } else {
                System.out.println("User with given ID is not available can't delete");
            }
        }
    }

    public void searchUser(ArrayList<User> list) {
        System.out.println("Enter User Id to search:");
        int id = sc.nextInt();
        ArrayList<Integer> idList = new ArrayList<>();
        for (User user : list) {
            idList.add(user.getId());
        }
        if (idList.contains(id)) {
            for (User user : list) {
                if (user.getId() == id) {
                    System.out.println("User is available! Name: " + user.getName() + " Address: " + user.getAddress());
                    break;
                }
            }
        } else {
            System.out.println("User with given ID is Not available");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> list = new ArrayList<User>();
        Main main = new Main();
        while (true) {
            System.out.println("*******MENU*******");
            System.out.println("1. Display Users");
            System.out.println("2. Add User");
            System.out.println("3. Delete User");
            System.out.println("4. Search User");
            System.out.println("5. Exit");
            System.out.print("Select your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    main.display(list);
                    break;
                case 2:
                    main.addUser(list);
                    break;
                case 3:
                    main.deleteUser(list);
                    break;
                case 4:
                    main.searchUser(list);
                    break;
                case 5:
                    System.out.println("ThankYou!!");
                    System.exit(1);
                default:
                    System.out.println("Enter valid choice");
            }
        }
    }
}