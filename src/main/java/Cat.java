public class Cat extends Species{

    public Cat()
    {
        type = "Cat";
    }
    public String speak(String name, User owner)
    {
        return "Meow, cat " + name + " has owner " + owner.getFirstname() + " " + owner.getLastname();
    }
    public void message(String name, User owner)
    {
        System.out.println(speak(name, owner));
    }
}
