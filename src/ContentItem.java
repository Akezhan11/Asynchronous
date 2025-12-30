import java.time.Year;
public abstract class ContentItem {
    private int id;
    private static int idGen;
    private String title;
    private int year;
    private int durationMinutes;

    public ContentItem(String title, int year, int durationMinutes) {
        this.id  = idGen++;
        setYear(year);
        setDurationMinutes(durationMinutes);
        setTitle(title);
    }
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if(title == null|| title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if(year<1990 || year > currentYear){
            throw new IllegalArgumentException("Year must be between 1990 and now");
        }
        this.year = year;
    }
    public int getDurationMinutes() {
        return durationMinutes;
    }
    public void setDurationMinutes(int durationMinutes) {
        if(durationMinutes < 0){
            throw new IllegalArgumentException("Minutes must be > 0");
        }
        this.durationMinutes = durationMinutes;
    }
    public int getAge(int currentYear){
        return  currentYear - year;
    }
    public abstract double getLicenseCost(int currentYear);
    @Override
    public String toString() {
        return "id:" + id + "\n" +
        "title: " + title + "\n" +
        "year: " + year + "\n" +
        "Minutes duration: " + durationMinutes;
    }
}