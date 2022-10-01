public class ToDoList {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList() {
        System.out.println("Todo List");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var index = i + 1;

            if (todo != null) {
                System.out.println(index + ". " + todo);
            }
        }

    }

    public static void testShowTodoList() {
        model[0] = "Java";
        model[1] = "Javascript";
        model[3] = "PHP";

        showTodoList();
    }

    public static void addTodoList(String todo) {
        // isFull
        var isFull = false;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // length * 2
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // add todo if model[i] null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Buku " + i);
        }

        showTodoList();
    }

    public static boolean deleteTodoList(Integer no) {
        if ((no - 1) >= model.length) {
            return false;
        } else if (model[no - 1] == null) {
            return false;
        } else {
            for (int i = (no - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testDeleteTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");

        var result = deleteTodoList(20);
        System.out.println(result);

        result = deleteTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("nama");
        System.out.println("Hi " + name);
    }

    // view
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewDeleteTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan Tidak ada");
            }
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("One");
        addTodoList("Two");
        addTodoList("Three");
        addTodoList("Four");
        addTodoList("Five");
        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        System.out.println("Menambah Todo List");

        var todo = input("todo (x Jika Batal)");

        if (todo.equals("x")) {
            // cancel
        } else {
            addTodoList(todo);
        }

    }

    public static void testViewAddTodoList() {
        addTodoList("One");
        addTodoList("Two");

        viewAddTodoList();

        showTodoList();
    }

    public static void viewDeleteTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor Yang di Hapus (x Jika Batal)");

        if (number.equals("x")) {
            // cancel
        } else {
            boolean success = deleteTodoList(Integer.valueOf(number));

            if (!success) {
                System.out.println("Gagal Menghapus Todo List " + number);
            }
        }

    }

    public static void testViewDeleteTodoList() {
        addTodoList("one");
        addTodoList("two");
        addTodoList("three");

        showTodoList();

        viewDeleteTodoList();

        showTodoList();
    }
}