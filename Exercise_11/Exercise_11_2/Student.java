public class Student extends Person{
    static final int freshman = 1;
    static final int sophomore = 2;
    static final int junior = 3;
    static final int senior = 4;
    private int status;

    public Student(String name, String address, String phone, String email, int status) {
        super(name, address, phone, email);
        this.status = status;
    }

    public String getStatus() {
        if(status == 1){
            return "Freshman";
        }else if(status == 2){
            return "Sophomore";
        }else if (status == 3){
            return "Junior";
        }else {
            return "Senior";
        }
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString(){
        return super.toString() + "\nStatus: " + getStatus();
    }


}
