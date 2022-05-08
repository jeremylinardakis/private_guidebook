package Models;

public class Boulder {
    private int grade;
    private String name;
    private boolean isDangerous;
    private String description;
    private String area;

    public Boulder(){
    }

    public Boulder(String name, int grade, boolean isDangerous, String description, String area) {
        this.name = name;
        this.grade = grade;
        this.isDangerous = isDangerous;
        this.description = description;
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public int getGrade() {
        return grade;
    }

    public String getName() {
        return name;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return  "______________  " + name + "  ______________" +
                "\nGrade            -> V" + grade +
                "\nDescription      -> " + description +
                "\nIs it dangerous? -> " + isDangerous +
                "\nArea             -> " + area;

    }
}
