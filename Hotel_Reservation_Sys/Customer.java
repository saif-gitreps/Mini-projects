public class Customer {
    String name;
    String national;
    String members;
    String cred;
    String bed;
    String duration;
    boolean food = false;
    boolean tour = false;
    public Customer(String name,String national,String members,String cred,String bed,String duration, boolean food,boolean tour){
        this.name = name;
        this.national = national;
        this.members = members;
        this.cred = cred;
        this.bed = bed;
        this.duration = duration;
        this.food = food;
        this.tour = tour;
    }
}
