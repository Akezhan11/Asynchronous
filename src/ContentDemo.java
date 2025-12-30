import javax.swing.text.AbstractDocument;
import java.time.Year;
import java.util.ArrayList;

public class ContentDemo {
    void main() {
        ArrayList<ContentItem> items = new ArrayList<>();
        items.add(new PodcastEpisode("Harry Poter and Akezhan", 2025, 110, "Emperor"));
        items.add(new PodcastEpisode("OOP: Astana It University", 2025, 150, "AITU"));
        items.add(new VideoLecture("Interface and demo class", 1999, 90, "HD"));
        items.add(new VideoLecture("English B2 level", 2011, 190, "QHD"));
        int currentYear = Year.now().getValue();
        for (ContentItem item : items) {
            System.out.println(item.toString() + " | licenseCost=" + item.getLicenseCost(currentYear));
            if (item instanceof Downloadable) {
                Downloadable cast = (Downloadable) item;
                cast.download();
                System.out.println("Max downloads/day: " + cast.getMaxDownloadsPerDay()+"\n");
            }
        }
    }
}