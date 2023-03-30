package ghb.informatik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import ghb.informatik.models.CinemaEvent;
import ghb.informatik.models.CinemaHall;
import ghb.informatik.models.Movie;

@Controller
public class CinemaEventController {
    
    
    Movie m1, m2, m3, m4, m5, m6;
    CinemaHall ch1, ch2;
    CinemaEvent ce1, ce2, ce3, ce4, ce5, ce6, ce7, ce8, ce9, ce10;


    public CinemaEventController(){
        createDemoData();
    }

    @GetMapping("/setseat")
    public String setSeats(@RequestParam(name="cinemaevent", required = true, defaultValue = "0") int cinemaevent, Model model){
        model.addAttribute("activePage", "seatView");
        model.addAttribute("rows", getAllCE()[cinemaevent].getCinemahall().getRows());
        model.addAttribute("cols", getAllCE()[cinemaevent].getCinemahall().getCols());
        model.addAttribute("ce", getAllCE()[cinemaevent]);
        return "index.html";
    }

    @GetMapping("/saveseat")
    public RedirectView saveseatseat(@RequestParam(name="cinemaevent", required = true, defaultValue = "0") int cinemaevent, @RequestParam(name="r", required = true, defaultValue = "0") int row, @RequestParam(name="c", required = true, defaultValue = "0") int col,Model model){
        getAllCE()[cinemaevent].getSeats()[row][col].setStatus(true);
        model.addAttribute("activePage", "home");
        return new RedirectView("/");
    }

    @GetMapping("/")
    public String index(@RequestParam(name="activePage", required = false, defaultValue = "home") String activePage, Model model){
        CinemaEventController cec = new CinemaEventController();
        model.addAttribute("activePage", activePage);
        model.addAttribute("cinemaEvents", cec.getAllCE());
        return "index.html";
    }

    /*
        AUFGABE 3
    */    
    private void createDemoData(){
        ch1 = new CinemaHall(4, 4, 1);
        ch2 = new CinemaHall(18, 18, 2);

        m1 = new Movie("Star Wars Episode 1");
        m1.setDesc("Der erste Teil der tollen Saga!");
        m1.setImgLink("https://m.media-amazon.com/images/I/51KCZ507V3L._SY445_.jpg");
        m1.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m1.setFsk(12);
        m1.setLength(116);

        m2 = new Movie("Andor Movie");
        m2.setDesc("Andor als Film - kommt bestimmt!");
        m2.setImgLink("https://assets.cdn.moviepilot.de/files/a5bf14f36668cd9902b34aee8f52776b4a9cd6cbfc868b66f56993d27a73/limit/500/1000/andor_digital_keyart_payoff_v6_lg_faa0a1e6.jpeg");
        m2.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m2.setFsk(12);
        m2.setLength(131);
        
        m3 = new Movie("Minions");
        m3.setDesc("Die kleinen gelben Verrückten :) !");
        m3.setImgLink("https://www.cinema.de/sites/default/files/styles/schema_org/public/sync/cms3.cinema.de/imgdb/import/dreams2/1070/653/0/107065309016.jpg?itok=urAZ6VrE");
        m3.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m3.setFsk(6);
        m3.setLength(109);

        m4 = new Movie("Der Pate");
        m4.setDesc("Zeitloser Klassiker...");
        m4.setImgLink("https://assets.cdn.moviepilot.de/files/907722fd26722acf79b0969a472768c7c8efe900c48e0fb0b8e93fb2eb99/limit/500/1000/MV5BNTUxOTdjMDMtMWY1MC00MjkxLTgxYTMtYTM1MjU5ZTJlNTZjXkEyXkFqcGdeQXVyNTA4NzY1MzY%40._V1_SY1000_CR0%2C0%2C706%2C1000_AL_.jpg");
        m4.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m4.setFsk(16);
        m4.setLength(178);

        //neuer Film 1
        m5 = new Movie("James Bond");
        m5.setDesc("Casino Royal");
        m5.setImgLink("https://m.media-amazon.com/images/I/51KCZ507V3L._SY445_.jpg");
        m5.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m5.setFsk(12);
        m5.setLength(106);

        //neuer Film 2
        m6 = new Movie("MAtrix 4");
        m6.setDesc("Nach wie vor nicht gesehen");
        m6.setImgLink("https://assets.cdn.moviepilot.de/files/907722fd26722acf79b0969a472768c7c8efe900c48e0fb0b8e93fb2eb99/limit/500/1000/MV5BNTUxOTdjMDMtMWY1MC00MjkxLTgxYTMtYTM1MjU5ZTJlNTZjXkEyXkFqcGdeQXVyNTA4NzY1MzY%40._V1_SY1000_CR0%2C0%2C706%2C1000_AL_.jpg");
        m6.setExternalLink("https://de.wikipedia.org/wiki/Star_Wars:Episode_I%E2%80%93_Die_dunkle_Bedrohung");
        m6.setFsk(16);
        m6.setLength(168);


        

        ce1 = new CinemaEvent(0, m1, ch1, "11.10.2022, 19:00 Uhr");
        ce2 = new CinemaEvent(1, m2, ch2, "12.10.2022, 19:30 Uhr");
        ce3 = new CinemaEvent(2, m3, ch1, "14.10.2022, 19:30 Uhr");
        ce4 = new CinemaEvent(3, m4, ch2, "11.10.2022, 21:30 Uhr");
        ce5 = new CinemaEvent(4, m4, ch1, "12.10.2022, 19:00 Uhr");
        ce6 = new CinemaEvent(5, m3, ch2, "15.10.2022, 20:30 Uhr");
        ce7 = new CinemaEvent(6, m2, ch1, "16.10.2022, 21:15 Uhr");
        ce8 = new CinemaEvent(7, m1, ch2, "18.10.2022, 20:30 Uhr");

        //Unterschiedliche CH
        ce9 = new CinemaEvent(7, m5, ch1, "18.10.2022, 20:30 Uhr");
        ce10 = new CinemaEvent(7, m6, ch2, "18.10.2022, 20:30 Uhr");
    }

    public CinemaEvent[] getAllCE(){
        CinemaEvent[] allCinemaEvents = new CinemaEvent[10];
        
        allCinemaEvents[0] = getCe1();
        allCinemaEvents[1] = getCe2();
        allCinemaEvents[2] = getCe3();
        allCinemaEvents[3] = getCe4();
        allCinemaEvents[4] = getCe5();
        allCinemaEvents[5] = getCe6();
        allCinemaEvents[6] = getCe7();
        allCinemaEvents[7] = getCe8();
        allCinemaEvents[8] = getCe9();
        allCinemaEvents[9] = getCe10();

        return allCinemaEvents;
    }

    public CinemaEvent getCe1() {
        return ce1;
    }
    public CinemaEvent getCe2() {
        return ce2;
    }
    public CinemaEvent getCe3() {
        return ce3;
    }
    public CinemaEvent getCe4() {
        return ce4;
    }
    public CinemaEvent getCe5() {
        return ce5;
    }
    public CinemaEvent getCe6() {
        return ce6;
    }
    public CinemaEvent getCe7() {
        return ce7;
    }
    public CinemaEvent getCe8() {
        return ce8;
    }
    public CinemaEvent getCe9() {
        return ce9;
    }
    public CinemaEvent getCe10() {
        return ce10;
    }
    

    
    public CinemaHall getCh1() {
        return ch1;
    }
    public CinemaHall getCh2() {
        return ch2;
    }
    public Movie getM1() {
        return m1;
    }
    public Movie getM2() {
        return m2;
    }
    public Movie getM3() {
        return m3;
    }
    public Movie getM4() {
        return m4;
    }

    public Movie getM5() {
        return m5;
    }

    public Movie getM6() {
        return m6;
    }
    



}
