import javax.sound.sampled.Line;
import java.util.Scanner;

public class project_kesemek {

        public static String[] model = new String[10];
        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

        public static void main(String[] args) {
           testViewShowTodoList();
        }

    /**
     * menampilkan todo list
     */


    public static void showTodoList() {
        System.out.println("TODOLIST");
            for (int i = 0; i < model.length; i++) {
                String todo = model[i];
                int no = i + 1;

                if (todo != null) {
                    System.out.println(no + ". " + todo);
                }
            }
        }

        public static void testShowTodoList() {
            model[0] = "Belajar Java Dasar";
            model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
            showTodoList();
        }

        public static void addTodoList(String todo) {
            boolean isFull = true;
            for (int i = 0; i < model.length; i++) {
                if (model[i] == null) {
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                String[] temp = model;
                model = new String[model.length * 2];

                for (int i = 0; i < temp.length; i++) {
                    model[i] = temp[i];
                }
            }

            for (int i = 0; i < model.length; i++) {
                if (model[i] == null) {
                    model[i] = todo;
                    break;
                }
            }
        }

        public static void testAddTodoList() {
            for (int i = 0; i < 25; i++) {
                addTodoList("Contoh Todo ke " + i);
            }

            showTodoList();
        }

    /**
     * menghapus todo dari list
     */

    public static boolean removeTodoList(int number) {
            if (number < 1 || number > model.length) {
                return false;
            } else if (model[number - 1] == null) {
                return false;
            } else {
                for (int i = number - 1; i < model.length; i++) {
                    if (i == model.length - 1) {
                        model[i] = null;
                    } else {
                        model[i] = model[i + 1];
                    }
                }
                return true;
            }
        }

        public static void testRemoveTodoList() {
            addTodoList("Satu");
            addTodoList("Dua");
            addTodoList("Tiga");
            addTodoList("Empat");
            addTodoList("Lima");

            boolean result = removeTodoList(20);
            System.out.println(result);

            result = removeTodoList(7);
            System.out.println(result);

            result = removeTodoList(2);
            System.out.println(result);

            showTodoList();
        }
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
       String name= input("nama");
       System.out.println("Hi " + name);

       String channel= input("channel");
       System.out.println(channel);
        }

        /**
         * menampilkan view todo list
         */
         public static void viewShowTodoList() {
             while (true) {
                 showTodoList();

                 System.out.println("menu :");
                 System.out.println("1. tambah");
                 System.out.println("2. hapus ");
                 System.out.println("x. keluar ");


                 String input = input("Pilih");
                 if (input.equals("1")) {
                     viewAddTodoList();
                 } else if (input.equals("2")) {
                     viewRemoveTodoList();
                 } else if (input.equals("3")) {
                     break;
                 } else {
                     System.out.println("Pilihan tidak dimengerti");
                 }
             }
         }

         public static void testViewShowTodoList() {
            addTodoList("satu");
            addTodoList("dua");
            addTodoList("tiga");
            addTodoList("empat");
            addTodoList("lima");
            viewShowTodoList();
        }
    /**
     * menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList(){
        String todo = input("Masukkan todo baru");
        addTodoList(todo);
    }

    /**
     * menampilkan view menhapus todo list
     */
    public static void viewRemoveTodoList(){
        var number = Integer.parseInt(input("Nomor todo yang akan dihapus"));
        boolean result = removeTodoList(number);
        if (!result) {
            System.out.println("Todo tidak ditemukan atau tidak dapat dihapus.");
        }
    }
}