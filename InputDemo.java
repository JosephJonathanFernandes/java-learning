import java.util.Scanner;

class InputDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Hello " + name + "! You are " + age + " years old.");
        
        sc.close();
    }
}


// nextLine() → reads full text

// nextInt(), nextDouble() → read numbers