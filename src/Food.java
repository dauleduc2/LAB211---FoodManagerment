
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food implements Serializable {

    final public String ID;
    public String name;
    public int weight;
    public String type;
    public String place;
    public Date expriredDate;

    public Food() {
        this.ID = null;
        this.name = null;
        this.weight = 0;
        this.type = null;
        this.place = null;
        this.expriredDate = null;
    }

    public Food(String ID, String name, int weight, String type, String place, Date expriredDate) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expriredDate = expriredDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getExpriredDate() {
        return expriredDate;
    }

    public void setExpriredDate(Date expriredDate) {
        this.expriredDate = expriredDate;
    }

    public String dayToString() {
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        return ft.format(expriredDate);
    }

}
