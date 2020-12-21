package School.models;

public class Teacher extends Person{

    private int wage;

    public void input() {
        super.input();
        getWageFomUser();
    }

    private void getWageFomUser() {

        boolean inputScanned = false;
        while (!inputScanned) {
            try {
                System.out.print("Enter wage: ");
                this.wage = scanner.nextInt();
                inputScanned = true;
            } catch (Exception e) {
                System.out.println("wrong input, please enter a valid number for wage");
            }
        }
    }

    @Override
    public String toString() {
        return "Teacher{" +
                super.toString() + ", " +
                "wage=" + wage +
                '}';
    }
}
