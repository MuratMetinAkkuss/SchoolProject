package StarCollege;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Student {

    static Map<String, String> studentMap = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void fakeStudentAdd() {
        studentMap.put("123456987411", "Ali, Can, 1999 , 3569, 12, A");
        studentMap.put("123456987412", "Veli, Yan, 1999, 3559, 12, B");
        studentMap.put("123456987413", "Ayse, Can, 1999, 4569, 12, A");
        studentMap.put("123456987414", "Ali, San, 1999, 1569, 11, A");
        studentMap.put("123456987415", "Alp, Yan, 1999, 3769, 11, A");
    }

    public static void studentMenu() throws InterruptedException {
        String choose = "";
        do {
            System.out.println(
                    "============Star College============\n" +
                            "===========Student Menu=============\n" +

                            "\t  1- Print list of student\n" +
                            "\t  2- Find student with use Lastname\n" +
                            "\t  3- Find student with use class no and branch\n " +
                            "\t  4- Enter information of student for add it\n" +
                            "\t  5- Delete registration with student id number\n" +
                            "\t  A- Main menu\n" +
                            "\t  Q- Exit\n");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    printStudentList();
                    break;
                case "2":
                    findStudentWithLastName();
                    break;
                case "3":
                    findStudentViaClassAndBranch();
                    break;
                case "4":
                    addStudent();
                    break;
                case "5":
                    deleteStudentViaIdNo();
                    break;
                case "A":
                case "a":
                    Store.mainMenu();
                    break;
                case "q":
                case "Q":
                    Store.stopProject();
                    break;
                default:
                    System.out.println("Please enter valid preference");
            }
        } while (!choose.equalsIgnoreCase("q"));
        Store.stopProject();
    }

    private static void deleteStudentViaIdNo() throws InterruptedException {
        System.out.println("Enter Id No which it will be deleted");
        String itWillBeDeleted = scanner.nextLine();


        String itWillBeDeletedValue = studentMap.get(itWillBeDeleted);


        String resultValue = studentMap.remove(itWillBeDeleted);
        try {
            boolean result = resultValue.equals(itWillBeDeletedValue);
        } catch (Exception e) {
            System.out.println("Requested teacher was not found");
        }
        printStudentList();
    }

    private static void addStudent() throws InterruptedException {
        System.out.println("Enter Id No");
        String idNo = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter Lastname");
        String lastName = scanner.nextLine();
        System.out.println("Enter Birth");
        String birth = scanner.nextLine();
        System.out.println("Enter School no");
        String schoolNo = scanner.nextLine();
        System.out.println("Enter Class No");
        String classNo = scanner.nextLine();
        System.out.println("Enter Branch No");
        String branchNo = scanner.nextLine();
        String willBeAddedValue = name +", "+ lastName +", "+ birth +", "+ schoolNo +", "+classNo + ", "+ branchNo;
        studentMap.put(idNo,willBeAddedValue);
        printStudentList();
    }

    private static void findStudentViaClassAndBranch() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = studentMap.entrySet();
        System.out.println("Enter Class that you're looking for it: ");
        String preferenceClass = scanner.nextLine();
        System.out.println("Enter Branch that you're looking for it: ");
        String preferenceBranch = scanner.nextLine();
        System.out.println(
                "============Star College============\n" +
                        "=============Student List==============\n" +
                        "IdNo         Isim   Lastname  Birth        School No  Class Branch");
        for (Map.Entry<String,String> each: myEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] arrValue = eachValue.split(", ");
            if (preferenceClass.equalsIgnoreCase(arrValue[4])&& preferenceBranch.equalsIgnoreCase(arrValue[5])) {
                System.out.printf(
                        "%-12s %-6s %-9s %-7s %-8s  %-5s  %-2s \n",
                        eachKey,arrValue[0],arrValue[1],arrValue[2],"     " + arrValue[3],"      "+arrValue[4],"    "+arrValue[5]
                );
            }

        }
        Thread.sleep(5000);
    }

    private static void findStudentWithLastName() throws InterruptedException {
        Set<Map.Entry<String, String>> myEntrySet = studentMap.entrySet();
        System.out.println("Enter lastname that you're looking for it: ");
        String preferenceLastName = scanner.nextLine();
        System.out.println(
                "============Star College============\n" +
                        "=============Student List==============\n" +
                        "IdNo         Isim   Lastname  Birth        School No  Class Branch");
        for (Map.Entry<String,String> each: myEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] arrValue = eachValue.split(", ");
            if (preferenceLastName.equalsIgnoreCase(arrValue[1])) {
                System.out.printf(
                        "%-12s %-6s %-9s %-7s %-8s  %-5s  %-2s \n",
                        eachKey,arrValue[0],arrValue[1],arrValue[2],"     " + arrValue[3],"      "+arrValue[4],"    "+arrValue[5]
                );
            }

        }
        Thread.sleep(5000);
    }

    private static void printStudentList() throws InterruptedException {

        Set<Map.Entry<String, String>> myEntrySet = studentMap.entrySet();
        System.out.println(
                "============Star College============\n" +
                        "=============Student List==============\n" +
                        "IdNo         Isim   Lastname  Birth        School No  Class Branch");
        for (Map.Entry<String,String> each: myEntrySet
             ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] arrValue = eachValue.split(", ");
            System.out.printf(
                    "%-12s %-6s %-9s %-7s %-8s  %-5s  %-2s \n",
                    eachKey,arrValue[0],arrValue[1],arrValue[2],"     " + arrValue[3],"      "+arrValue[4],"    "+arrValue[5]
            );

        }
        Thread.sleep(5000);
    }

}
