package th.ac.ku.sci.todolistapp.model;

import java.io.Serializable;
import java.util.Date;

public class TodoItem implements Serializable {
    public String title = "";
    public String detail = "";
    private Date created;
    private Date start;
    private Date end;

    public TodoItem(){
    }

    public TodoItem(String title, String detail,
                    Date created, Date start, Date end) {
        this.title = title;
        this.detail = detail;
        this.created = created;
        this.start = start;
        setEnd(end);
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        if(this.end != null && start != null && this.end.compareTo(start) < 0) {
            this.start = this.end;
            this.end = start;
        }else{
            this.start = start;
        }
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        if(this.start != null && end != null && this.start.compareTo(end) > 0) {
            this.end = this.start;
            this.start = end;
        }else{
            this.end = end;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        TodoItem t = (TodoItem)obj;
        return this.title.equals(t.title)
                && this.detail.equals(t.detail)
                && equalDate(this.created,t.created)
                && equalDate(this.created,t.created)
                && equalDate(this.start,t.start)
                && equalDate(this.end,t.end);
    }

    private boolean equalDate(Date d1, Date d2){
        if(d1 == null && d2 == null){
            return true;
        }else{
            return d1 != null && d2 != null && d1.equals(d2);
        }
    }
}
