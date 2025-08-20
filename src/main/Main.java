package main;
import dao.*;
import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAO();
        TrainerDAO trainerDAO = new TrainerDAO();
        WorkoutDAO workoutDAO = new WorkoutDAO();
        PaymentDAO paymentDAO = new PaymentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Gym Management System ===");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Add Trainer");
            System.out.println("4. View Trainers");
            System.out.println("5. Add Workout");
            System.out.println("6. View Workouts");
            System.out.println("7. Add Payment");
            System.out.println("8. View Payments");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String mName = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int mAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Membership Type: ");
                    String mType = sc.nextLine();
                    memberDAO.addMember(new Member(mName, mAge, mType));
                    break;

                case 2:
                    for (Member m : memberDAO.getAllMembers())
                        System.out.println(m);
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Trainer Name: ");
                    String tName = sc.nextLine();
                    System.out.print("Enter Specialization: ");
                    String spec = sc.nextLine();
                    trainerDAO.addTrainer(new Trainer(tName, spec));
                    break;

                case 4:
                    for (Trainer t : trainerDAO.getAllTrainers())
                        System.out.println(t);
                    break;

                case 5:
                    System.out.print("Enter Member ID: ");
                    int wMemberId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Workout Plan: ");
                    String plan = sc.nextLine();
                    workoutDAO.addWorkout(new Workout(wMemberId, plan));
                    break;

                case 6:
                    for (Workout w : workoutDAO.getAllWorkouts())
                        System.out.println(w);
                    break;

                case 7:
                    System.out.print("Enter Member ID: ");
                    int pMemberId = sc.nextInt();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    paymentDAO.addPayment(new Payment(pMemberId, amt));
                    break;

                case 8:
                    for (Payment p : paymentDAO.getAllPayments())
                        System.out.println(p);
                    break;

                case 9:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
