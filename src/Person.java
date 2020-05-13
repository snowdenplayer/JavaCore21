public class Person {

    @Fielder(value = "Annotation name")

    private String name;
    @Fielder(value = "Annotation firstname")
    private String firsname;
    @Fielder(value = "Annotation age")
    private int age;

    private String father;

    public Person(String name, String firsname, int age, String father) {
        this.name = name;
        this.firsname = firsname;
        this.age = age;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", firsname='" + firsname + '\'' +
                ", age=" + age +
                ", father='" + father + '\'' +
                '}';
    }
}
