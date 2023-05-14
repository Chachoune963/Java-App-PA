package Classes;

public class Activity {
    private String category;
    private String title;
    private String description;
    private String room_name;

    public Activity(String title, String room_name) {
        this.title = title;
        this.room_name = room_name;
    }

    public Activity(String category, String title, String description, String room_name) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.room_name = room_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
