package nl.stil4m.transmission.api.domain;

public class Tracker {

    private String announce;
    private Long id;
    private String scrape;
    private Long tier;

    public String getAnnounce() {
        return announce;
    }

    public void setAnnounce(String announce) {
        this.announce = announce;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScrape() {
        return scrape;
    }

    public void setScrape(String scrape) {
        this.scrape = scrape;
    }

    public Long getTier() {
        return tier;
    }

    public void setTier(Long tier) {
        this.tier = tier;
    }
}
