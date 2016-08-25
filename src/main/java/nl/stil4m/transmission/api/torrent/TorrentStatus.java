package nl.stil4m.transmission.api.torrent;

import java.util.NoSuchElementException;

public enum TorrentStatus {

    STOPPED(0L), // Torrent is stopped
    CHECK_WAIT(1L), // Queued to check files
    CHECK(2L), // Checking files
    DOWNLOAD_WAIT(3L), // Queued to download
    DOWNLOADING(4L), // Downloading
    SEED_WAIT(5L), // Queued to seed
    SEED (6L), // Seeding
    ISOLATED(7L); // Torrent can't find peers

    private Long longValue;

    TorrentStatus(long l) {
        this.longValue = l;
    }

    public static String get(Long longValue) {
        for (TorrentStatus torrentStatus : TorrentStatus.values()) {
            if (torrentStatus.getValue().equals(longValue)) {
                return torrentStatus.name();
            }
        }
        throw new NoSuchElementException(String.format("No Status with id: %s", longValue));
    }

    public Long getValue() {
        return longValue;
    }
}
