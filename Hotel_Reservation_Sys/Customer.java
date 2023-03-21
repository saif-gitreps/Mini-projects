public class Customer {
    int members;
    int bed;
    int totalCost;
    public static int bedOccupied =0;
    public static int totalMembers =0;
    public static int finalCost =0;
    public Customer(int members,int bed,int totalCost){
        this.members = members;
        this.bed = bed;
        this.totalCost = totalCost;
        bedOccupied += bed;
        totalMembers += members;
        finalCost += totalCost;
    }
}
