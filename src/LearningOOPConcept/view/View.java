package LearningOOPConcept.view;

import LearningOOPConcept.controller.UserController;
import LearningOOPConcept.model.UpdateUserDTO;
import LearningOOPConcept.model.User;
import LearningOOPConcept.utils.ConvertDate;


import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class View {

    static ConvertDate convertDate = new ConvertDate();

    public static void viewClient() {
        UserController userController = new UserController();
        while (true) {
            System.out.println("User Information");
            System.out.print("""
                    1. List User
                    2. Add User
                    3. Search User
                    4. Update User
                    5. Delete User
                    6. Exit
                    """);
            int op = 0;
            while (true) {
                try {
                    System.out.print("Option: ");
                    op = new Scanner(System.in).nextInt();
                    break;
                }catch (InputMismatchException e){
                    System.out.println("Please enter a valid option!");
                }
            }


            switch (op) {
                case 1 -> {
                    try{
                        TableView t = new TableView();
                        t.TableViewAll(userController.listUser());
                    }catch(Exception _){
                    }
                }
                case 2 -> {

                    User tempUser = new User();
                    System.out.println("Input User Information");
                    System.out.print("Input User Name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.print("Input Gender: ");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.print("Input Age: ");
                    int age = new Scanner(System.in).nextInt();
                    System.out.print("Input Birth Date(yyyy-mm-dd): ");
                    String birthDate = new Scanner(System.in).nextLine();
                    LocalDate convertedDate = convertDate.parseDate(birthDate);
                    tempUser.uuid = UUID.randomUUID();
                    tempUser.name = name;
                    tempUser.gender = gender;
                    tempUser.age = age;
                    tempUser.birthDate = convertedDate ;
                    userController.addUser(tempUser);
                }
                case 3 -> {
                    System.out.println("=".repeat(25));
                    System.out.println("Search User");
                    System.out.println("=".repeat(25));
                    System.out.print("Input User UUID: ");
                    String uuid = new Scanner(System.in).nextLine();
                    if (userController.searchUser(uuid) == null) {
                        System.out.println("User Not Found");
                        System.out.println("=".repeat(25));
                    } else {
                        System.out.println("User Found");
                        System.out.println("=".repeat(25));
                        TableView tableView = new TableView();
                        tableView.TableView(userController.listUserByUUID(uuid));
                        System.out.println("=".repeat(25));
                    }
                }
                case 4 -> {
                    System.out.print("Input UUID to Update: ");
                    String uuid = new Scanner(System.in).nextLine();
                    System.out.println("=".repeat(25));
                    String foundUUID = userController.searchUser(uuid);
                    if (foundUUID == null) {
                        System.out.println("User Not Found");
                    } else {
                        System.out.println("User Found");
                        System.out.println("=".repeat(25));
                        userController.listUserByUUID(uuid);
                        System.out.println("=".repeat(25));
                        System.out.println("Input new User Information");
                        System.out.print("Input Name: ");
                        String newName = new Scanner(System.in).nextLine();
                        System.out.print("Input Gender: ");
                        String newGender = new Scanner(System.in).nextLine();
                        System.out.print("Input Age: ");
                        int newAge = new Scanner(System.in).nextInt();
                        System.out.print("Input Birth Date(yyyy-mm-dd): ");
                        String birthDate = new Scanner(System.in).nextLine();
                        LocalDate convertedDate = convertDate.parseDate(birthDate);
                        userController.updateUser(uuid, new UpdateUserDTO(newName, newGender, newAge, convertedDate));
                        userController.listUserByUUID(uuid);
                        System.out.println("Update Successfully");
                    }
                }
                case 5 -> {
                    System.out.println("=".repeat(25));
                    System.out.print("Input UUID to Delete: ");
                    String deleteUUID = new Scanner(System.in).nextLine();
                    System.out.println("=".repeat(25));
                    userController.deleteUser(deleteUUID);

                }
                case 6 -> {
                    try {
                        System.out.println("System Exiting...");
                        System.out.println("=".repeat(25));
                        Thread.sleep(2000);
                    } catch (InterruptedException ignore) {
                    }
                }
                default -> System.out.println("Invalid Input");
            }
        }
    }
}
