public class Dog extends Species{

    public Dog(float rating)
    {
        type = "Dog";
        this.rating = rating;
    }
    public String speak(String name, User owner)
    {
        return "Woof, dog " + name + " has owner " + owner.getFirstname() + " " + owner.getLastname();
    }
    public void message(String name, User owner)
    {
        System.out.println(speak(name, owner));
    }
}
