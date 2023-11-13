package generation.model;

public class Course {
    private final String code;
    private final String name;
    private final int credits;
    private final Module module;
    private double grade;

    // Constructor
    public Course(String code, String name, int credits, Module module) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.module = module;
    }
    public Course(String code, String name, int credits, Module module, double grade) {
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.module = module;
        this.grade = grade;
    }

    // Getters & Setters
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public int getCredits() {
        return credits;
    }
    public Module getModule() {
        return module;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course{" + "code='" + code + '\'' + ", name='" + name + '\'' + ", credits=" + credits + ", module=" + module + '}';
    }
}
