
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Account {
    int id;
    double balance;
    public Account (int id, double balance){
        this.id = id;
        this.balance = balance;
    }


}
