package th.ac.ku.sci.todolistapp;

import java.util.Date;

public class TodoItem {
    private String title;
    private String detail;
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
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
}
