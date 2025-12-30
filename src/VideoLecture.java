import java.time.Year;
public class VideoLecture extends ContentItem implements Downloadable{
    private String quality;

    public VideoLecture(String title, int year, int durationMinutes, String quality) {
        super(title, year, durationMinutes);
        setQuality(quality);
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        if (quality == null || quality.isEmpty()) {
            throw new IllegalArgumentException("Quality cannot be null");
        }
        this.quality = quality;
    }

    public int ageFactor() {
        int age = getAge(Year.now().getValue());
        if (age <= 2) {
            return 5;
        }
        return 2;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        double cost = 0.05 * getDurationMinutes() + ageFactor();
        return cost;
    }

    @Override
    public String toString() {
        return "id:" + getId() + "\n" +
                "title: " + getTitle() + "\n" +
                "year: " + getYear() + "\n" +
                "Minutes duration: " + getDurationMinutes()
                + "\n" + "quality:" + getQuality();
    }

    @Override
    public void download() {
        System.out.println("Downloading Video in " + quality);
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }
}