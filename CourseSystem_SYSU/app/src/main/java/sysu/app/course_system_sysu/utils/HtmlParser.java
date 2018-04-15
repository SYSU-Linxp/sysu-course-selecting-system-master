package sysu.app.course_system_sysu.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import sysu.app.course_system_sysu.model.ExamInfo;
import sysu.app.course_system_sysu.model.InnovateCredit;

public class HtmlParser {
    public static List<InnovateCredit> getInnovateCredits(String html){
        List<InnovateCredit> credits = new ArrayList<>();

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("tbody tr");
        for (Element element : elements){
            Elements elems = element.select("td");
            String type = elems.get(1).text();
            String name = elems.get(2).text();
            String credit = elems.get(3).text();

            InnovateCredit credit1 = new InnovateCredit(credit, name, type);
            credits.add(credit1);
        }

        return credits;
    }

    public static List<ExamInfo> getExamLists(String html){
        List<ExamInfo> examInfos = new ArrayList<>();

        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("tbody tr");
        for (Element element : elements){
            Elements elems = element.select("td");
            String className = elems.get(1).text();
            String examTime = elems.get(2).text();
            String examLocation = elems.get(3).text();
            ExamInfo info = new ExamInfo(className, examTime, examLocation);
            examInfos.add(info);
        }

        return examInfos;
    }

   // public static

}
