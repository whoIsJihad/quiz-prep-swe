package state;

public class Task {
    String name;
    State currentState;

    void startTask() {
        this.currentState.startTask();
    }

    void continueTask() {
        this.currentState.continueTask();
    }

    void review() {
        this.currentState.review();
    }

    void done() {
        this.currentState.done();
    }

    void setState(State state){
        this.currentState=state;
    }

}

interface State {
    void startTask();

    void continueTask();

    void review();

    void done();
}

class ToDo implements State {
    public void startTask() {
        System.out.println("Starting the task");
    }

    public void continueTask() {
        System.out.println("Havent started the task yet");
    }

    public void review() {
        System.out.println("Task hast been started.cant review ");
    }

    public void done() {
        System.out.println("Task not done.still hasn't started");
    }
}

class InProgress implements State {
    public void startTask() {
        System.out.println("Started already");
    }

    public void continueTask() {
        System.out.println("Continuing the task");
    }

    public void review() {
        System.out.println("Task hast been fininished.cant review ");

    }

    public void done() {
        System.out.println("The task is done.Still in progress");
    }
}

class InReview implements State {
    public void startTask() {
        System.out.println("Started already");

    }

    public void continueTask() {
        System.out.println("task is already done");
    }

    public void review() {
        System.out.println("Reviewing the task");
    }

    public void done() {
        System.out.println("The task is not done");
    }
}

class Done implements State {
    public void startTask() {
        System.out.println("The task is done and dusted");

    }

    public void continueTask() {
        System.out.println("The task is done and dusted");

    }

    public void review() {
        System.out.println("The task is done and dusted");

    }

    public void done() {
        System.out.println("The task is done and dusted");

    }
}

class Main {

    public static void main(String[] args) {
        Task task=new Task();
        task.setState(new ToDo());
        task.startTask();

    }
}