import java.time.Year;
public class PodcastEpisode extends ContentItem implements Downloadable{
    private String hostName;

    public PodcastEpisode(String title, int year, int durationMinutes,String hostName){
        super(title,year,durationMinutes);
        setHostName(hostName);
    }
    public String getHostName() {
        return hostName;
    }
    public void setHostName(String hostName) {
        if(hostName == null || hostName.isEmpty()){
            throw new IllegalArgumentException("Host name cannot be empty");
        }
        this.hostName = hostName;
    }

    public int ageFactor(){
        int age = getAge(Year.now().getValue());
        if(age <=2){
            return 3;
        }
        return 1;
    }
    @Override
    public double getLicenseCost(int currentYear) {
        double cost = 0.03 * getDurationMinutes() + ageFactor();
        return cost;
    }
    @Override
    public String toString() {
        return "id:" + getId() + "\n" +
                "title: " + getTitle() + "\n" +
                "year: " + getYear() + "\n" +
                "Minutes duration: " + getDurationMinutes()
                + "\n" + "hostName:" + getHostName();
    }

    @Override
    public void download() {
        System.out.println("Downloading podcast hosted by " + hostName);
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }
}