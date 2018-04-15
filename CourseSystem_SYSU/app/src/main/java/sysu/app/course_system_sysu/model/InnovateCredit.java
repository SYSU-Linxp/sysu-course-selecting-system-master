package sysu.app.course_system_sysu.model;

import java.io.Serializable;

public class InnovateCredit implements Serializable{
    private String credit;
    private String name;
    private String type;

    public InnovateCredit(String credit, String name, String type) {
        this.credit = credit;
        this.name = name;
        this.type = type;
    }

    public String getCredit() {
        return credit;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
