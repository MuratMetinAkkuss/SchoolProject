package StarCollege;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Teacher {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> teachersMap = new HashMap<>();

    public static void putFakeTeacher() {
        teachersMap.put("123456987411", "Ali, Can, 1980, Matematik");
        teachersMap.put("123456987412", "Veli, Yan, 1981, Fizik");
        teachersMap.put("123456987413", "Ayse, Can, 1982, Kimya");
        teachersMap.put("123456987414", "Ali, San, 1983, Kimya");
        teachersMap.put("123456987415", "Alp, Yan, 1984, Matematik");

    }

    public static void tabOfTeacher() throws InterruptedException {
        String preference = "";
        do {
            System.out.println();
            System.out.println(
                    "============Star College============\n" +
                            "=============Teacher Menu==============\n" +
                            "\t  1- Print list of teacher\t\t\t\n" +
                            "\t  2- Find teacher with use Lastname\n" +
                            "\t  3- Find teacher with use Departman\n" +
                            "\t  4- Enter information of teacher for add it\t\t \n" +
                            "\t  5- Delete registration with teacher id number\t\t \n" +
                            "\t  A- Main menu\t\t \n" +
                            "\t  Q- Exit\n"
            );
            System.out.println("Please, Choose one");
            preference = scan.nextLine();

            switch (preference) {
                case "1":
                    printTeacherList();
                    break;
                case "2":
                    findTeacherWithLastname();//2- Find teacher with use Lastname
                    break;
                case "3":
                    findTeacherWithDepartman();//Find teacher with use Departman

                    break;
                case "4":
                    addTeacher();//Enter information of teacher for add it
                    break;
                case "5"://delete registration with teacher id number
                    System.out.println("Enter Id No which it will be deleted");
                    String itWillBeDeleted = scan.nextLine();


                     String itWillBeDeletedValue = teachersMap.get(itWillBeDeleted);


                    String resultValue = teachersMap.remove(itWillBeDeleted);
                    try {
                       boolean result = resultValue.equals(itWillBeDeletedValue);
                    } catch (Exception e) {
                        System.out.println("Requested teacher was not found");
                    }

                    break;
                case "A":
                case "a":
                    Store.mainMenu();
                    break;
                case "Q":
                case "q":
                    break;
                default:
                    System.out.println("Please Enter valid preference");
            }
        } while (!preference.equalsIgnoreCase("Q"));
        Store.stopProject();
    }

    public static void addTeacher() {
        System.out.println("Enter Id No");
        String idNo = scan.nextLine();
        System.out.println("Enter Name");
        String name = scan.nextLine();
        System.out.println("Enter Lastname");
        String lastName = scan.nextLine();
        System.out.println("Enter Birth");
        String birth = scan.nextLine();
        System.out.println("Enter Departman");
        String departman = scan.nextLine();
        String willBeAddedValue = name +", "+ lastName +", "+ birth +", "+ departman ;
        teachersMap.put(idNo,willBeAddedValue);
    }

    public static void findTeacherWithDepartman() throws InterruptedException {
        System.out.println("Enter lastname that you're looking for it: ");
        String requestedLastname = scan.nextLine();
        Set<Map.Entry<String, String>> keySet = teachersMap.entrySet();
        System.out.println(
                "============Star College============\n" +
                        "=============Requested Teacher==============\n" +
                        "IdNo         Isim   Lastname  Birth   Departman");
        for (Map.Entry<String, String> each : keySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValueArr = eachValue.split(", ");
            if (eachValueArr[3].equalsIgnoreCase(requestedLastname)) {
                System.out.printf(
                        "%11s %-6s %-8s %4s     %s\n",
                        eachKey, eachValueArr[0], eachValueArr[1]
                        , eachValueArr[2], eachValueArr[3]
                );
            }


        }
        Thread.sleep(5000);

    }

    public static void findTeacherWithLastname() throws InterruptedException {
        System.out.println("Enter lastname that you're looking for it: ");
        String requestedLastname = scan.nextLine();
        Set<Map.Entry<String, String>> keySet = teachersMap.entrySet();
        System.out.println(
                "============Star College============\n" +
                        "=============Requested Teacher==============\n" +
                        "IdNo         Isim   Lastname  Birth   Departman");
        for (Map.Entry<String, String> each : keySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValueArr = eachValue.split(", ");
            if (eachValueArr[1].equalsIgnoreCase(requestedLastname)) {
                System.out.printf(
                        "%11s %-6s %-8s %4s     %s\n",
                        eachKey, eachValueArr[0], eachValueArr[1]
                        , eachValueArr[2], eachValueArr[3]
                );
            }


        }
        Thread.sleep(5000);

    }

    private static void printTeacherList() throws InterruptedException {
        Set<Map.Entry<String, String>> keySet = teachersMap.entrySet();
        System.out.println(
                "============Star College============\n" +
                        "=============Teacher Menu==============\n" +
                        "IdNo         Isim   Lastname  Birth   Departman");
        for (Map.Entry<String, String> each : keySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValueArr = eachValue.split(", ");
            System.out.printf(
                    "%11s %-6s %-8s %4s     %s\n",
                    eachKey, eachValueArr[0], eachValueArr[1]
                    , eachValueArr[2], eachValueArr[3]
            );


        }
        Thread.sleep(5000);
    }
}
