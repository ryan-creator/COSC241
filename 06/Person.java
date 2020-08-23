package week06;

public class Person {

    private static int count = 0;
    private int id;
    private String name = "";
    private int age = -1;
    private boolean children;
    private WordList sports = new WordList();


    public Person(){
        this.id = count;
        count++;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public boolean getChildren(){
        return children;
    }

    public void setChildren(boolean newChild){
        this.children = newChild;
    }

    public WordList getSports(){
        return sports;
    }
    
    public void addSport(String sport){
        sports =  sports.add(sport);
    }
    
    public String toString(){
        return "Person{id=" + id + ", name=" + name + ", age=" + age +
            ", sports=" + sports + ", children=" + children + "}";
    }
}
