import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class Vegetable
{
    int quantity;
    String name;
    int price;
    public Vegetable(int quantity, String name, int price)
    {
        this.quantity=quantity;
        this.name=name;
        this.price=price;
    }  

    public String getname()
    {
        return name;
    }
    public int getprice()
    {
        return price;
    }
    public int getquantity()
    {
        return quantity;
    }
}
public class OperationStream
{
    public static void main(String[] args) {
        List<Vegetable>l=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you wanna add elements? :");
        String choice = sc.nextLine();
        while(!choice.equalsIgnoreCase("no")){
            System.out.println("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name: ");
            String name = sc.nextLine();
            System.out.println("Enter price: ");
            int price = sc.nextInt();
            l.add(new Vegetable(quantity,name,price));
            sc.nextLine();
            System.out.println("Do you wanna add elements? ");
            choice = sc.nextLine();
        }
    //filter method
    System.out.println("Filtering:");
    l.stream().filter(p->p.price>60).forEach(pd->System.out.println(pd.quantity+" "+pd.name+" "+pd.price));
    //map method
    System.out.println("Mapping:");
    l.stream().map(n->n.getname()).forEach(n->System.out.print(n+" "));
    //count
    System.out.println("count:");
    long count=l.stream().distinct().count();
    System.out.println(count);
    //sorted
    List sortedNames = l.stream().map(s->s.getname()).sorted().collect(Collectors.toList());		
	System.out.println(sortedNames);
    
    }
}
