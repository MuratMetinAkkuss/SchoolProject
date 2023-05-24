package StarCollege;

import java.util.Scanner;

public class Store {
   static Scanner scan = new Scanner(System.in);
    public static void mainMenu() throws InterruptedException {

        String preference ="";
        do {
        System.out.println(
                "============Star College============\n" +
                        "=============Main Menu==============\n" +
                        "\t  1- School information\t\t\t\n" +
                        "\t  2- Tab of teacher\n" +
                        "\t  3- Tab of student\t\t \n" +
                        "\t  Q- Exit\n"
        );
        System.out.println("Please, Choose one");
        preference = scan.nextLine();
        switch (preference){
            case "1"://School info
                Store.printSchoolInformation();
                break;
            case "2"://tab of teacher
                Teacher.tabOfTeacher();
                break;
            case "3"://tab of student
                Student.studentMenu();
                break;
            case "q"://exit
            case "Q"://exit
            break;
            default:
                System.out.println("Please enter valid preference");
        }


        }while (!preference.equalsIgnoreCase("Q"));

        Store.stopProject();

    }

    public static void printSchoolInformation() throws InterruptedException {
        System.out.println("============Star College============\n" +
                "\t\t Adress : " + School.adress +
                "\n\t\t Phone  :  " + School.phoneNumber);
        Thread.sleep(5000);
    }

    public static void stopProject() {

        System.out.println("Your preference has been chosen 'exit' ");
        System.exit(0);
    }
}
