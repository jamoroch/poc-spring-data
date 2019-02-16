package hello.poc;

import java.io.Serializable;
import java.util.Date;

public class Message  implements Serializable {

    private String name;

    private Date startDate;

    public Message() {

    }

    public Message(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

}
