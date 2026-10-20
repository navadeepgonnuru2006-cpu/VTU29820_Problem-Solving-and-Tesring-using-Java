
import java.util.ArrayList;
import java.util.Scanner;

class Student {}
class Rockstar {}
class Hacker {}

public class InstanceOFTutorial {

    static String count(ArrayList mylist) {
        int student = 0;
        int rockstar = 0;
        int hacker = 0;

        for (int i = 0; i < mylist.size(); i++) {
            Object element = mylist.get(i);

            if (element instanceof Student)
                student++;

            if (element instanceof Rockstar)
                rockstar++;

            if (element instanceof Hacker)
                hacker++;
        }

        return student + " " + rockstar + " " + hacker;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList mylist = new ArrayList();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String name = sc.next();

            if (name.equals("Student"))
                mylist.add(new Student());

            if (name.equals("Rockstar"))
                mylist.add(new Rockstar());

            if (name.equals("Hacker"))
                mylist.add(new Hacker());
        }

        System.out.println(count(mylist));
        sc.close();
    }
}
