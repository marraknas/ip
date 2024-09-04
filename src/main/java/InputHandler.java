import java.util.ArrayList;

public class InputHandler {
    private ArrayList<Task> data;
    private String hline = "____________________________________________________________";
    public InputHandler(ArrayList<Task> database) {
        this.data = database;
    }
    public void markHandle(String input) throws BuzzException {
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        if (index < 0 || index >= data.size()) {
            throw new BuzzException("OOPS!!! The task doesn't exist *BEEP*");
        }
        data.get(index).setDone(true);
        System.out.println(hline);
        System.out.println("Mission accomplished! *bzzt*");
        System.out.println(data.get(index).toString());
        System.out.println(hline);
    }

    public void unmarkHandle(String input) throws BuzzException {
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        if (index < 0 || index >= data.size()) {
            throw new BuzzException("OOPS!!! The task doesn't exist *BEEP*");
        }
        data.get(index).setDone(false);
        System.out.println(hline);
        System.out.println("Argh next time! *bzzt*");
        System.out.println(data.get(index).toString());
        System.out.println(hline);
    }

    public void deleteHandle(String input) throws BuzzException {
        int index = Integer.parseInt(input.split(" ")[1]) - 1;
        if (index < 0 || index >= data.size()) {
            throw new BuzzException("OOPS!!! The task doesn't exist *BEEP*");
        }
        Task task = data.remove(index);
        System.out.println(hline);
        System.out.println("*POOF* Circuits fried! Deleted the mission.");
        System.out.println(task.toString());
        System.out.println("You currently have " + data.size() + " missions available *reeeee* ");
        System.out.println(hline);

    }

    public void todoHandle(String input) throws BuzzException {
        if (input.length() <= 5) {
            throw new BuzzException("NOOO! Description is empty *crash*");
        }
        Task task = new Todo(input.substring(5));
        data.add(task);
        System.out.println(hline);
        System.out.println("Understood boss. Added!");
        System.out.println(task.toString());
        System.out.println("You currently have " + data.size() + " missions available *reeeee* ");
        System.out.println(hline);
    }

    public void deadlineHandle(String input) throws BuzzException {
        String[] parts = input.split("/by");
        if (parts.length < 2 || parts[0].length() <= 9) {
            throw new BuzzException("NOOO! Description is empty *crash*");
        }
        Task task = new Deadline(parts[0].substring(9), parts[1].trim());
        data.add(task);
        System.out.println(hline);
        System.out.println("Understood boss. Added!");
        System.out.println(task.toString());
        System.out.println("You currently have " + data.size() + " missions available *reeeee* ");
        System.out.println(hline);
    }

    public void eventHandle(String input) throws BuzzException {
        String[] parts = input.split("/");
        if (parts.length < 3 || parts[0].length() <= 6) {
            throw new BuzzException("OOPS!!! The description of an event cannot be empty.");
        }
        Task task = new Event(parts[0].substring(6), parts[1].substring(5), parts[2].substring(3));
        data.add(task);
        System.out.println(hline);
        System.out.println("Understood boss. Added!");
        System.out.println(task.toString());
        System.out.println("You currently have " + data.size() + " missions available *reeeee* ");
        System.out.println(hline);
    }
}
