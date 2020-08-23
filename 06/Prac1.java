package week06;

import java.util.*;
/**
 * The application class for the first 241 practical test.
 * @author Iain Hewson
 */
public class Prac1 {
    /** A list of people to be operated on. */
    private List<Person> people = new ArrayList<>();
    /**
     * Creates an instance of Prac1 and sends lines of input read from
     * stdin to its processLine() method. Each line of input is
     * separated into the first word and the remainder of the line.
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
	Prac1 app = new Prac1();
	Scanner input = new Scanner(System.in);
	while (input.hasNextLine()) {
	    String[] line = input.nextLine().trim().split(" ", 2);
	    String command = line[0];
	    String remainder = line.length > 1 ? line[1] : "";
	    app.processLine(command, remainder);
	}
    }
    public void processLine(String command, String line) {
	if(command.equals("add")){
	    Person p = new Person();
	    people.add(p);
	    updatePerson(p, line);
	    System.out.println("Added: " + p);
	}
	if(command.equals("find")){
	    for(Person p : people){
		if(p.getId() == Integer.parseInt(line)){
		    System.out.println("Found: " + p);
		}
	    }
	}
	if(command.equals("remove")){
            for (Person p : people) {
                if (p.getId() == Integer.parseInt(line)) {
                    System.out.println("Removed: " + p);
                    people.remove(p);
                    break;
                }
            }
        }
	if(command.equals("children")){
	    for(Person p : people){
                //System.out.println(p.getSports);
		if((p.getSports().contains(line) && p.getChildren()){
                    System.out.println("Parents who participate in squash\n"+p.getId()+": "+p.getName());
		}
	    }
	}
	if(command.equals("older")){
	    for(Person p : people){
                try {
                    if(p.getAge() > Integer.parseInt(line)){
                        System.out.println(p.getName()+" Age:"+p.getAge());
                    }
                } catch (NumberFormatException e) {
                    //System.out.println("Error");
                }
            }
        }
        if (command.equals("print")) {
                System.out.println("Printing all");
                for (Person p : people) {
                    System.out.println(p);
	    }
	}
    }
    private void updatePerson(Person p, String details) {
	String[] attributes = details.trim().split(",");
	for (String item : attributes) {
	    Scanner s = new Scanner(item);
            if(s.hasNext()){
                String selector = s.next().toLowerCase();

                switch (selector) {
                    case "name":
                        p.setName(s.next());
                        break;
                    case "age":
                        try {
                            p.setAge(Integer.parseInt(s.next()));
                        } catch(NumberFormatException e) {
                            //System.out.println("Selector: "+selector+" details: "+ details);
                        }
                        break;
                    case "children":
                        p.setChildren(Boolean.parseBoolean(s.next()));
                        break;
                    case "sports":
                        while(s.hasNext()){
                            p.addSport(s.next());
                        }
                        break;
                    default:
                        System.out.println("Unknown attribute: " + selector);
                }         
            }
	}
    }
}
