package nl.stil4m.transmission.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class SetTorrentInfo {

    /**
     * Torrent's bandwidth priority
     */
    private Integer bandwidthPriority;

    /**
     * Maximum download speed (KBps)
     */
    @JsonProperty("downloadLimit")
    private Long downloadLimitInKBps;

    /**
     * {@code true} if {@code downloadLimitInKBps} is honored
     */
    private Boolean downloadLimited;

    /**
     * Indices of file(s) to download
     */
    @JsonProperty("files-wanted")
    private List<Integer> filesToDownload;

    /**
     * Indices of file(s) to not download
     */
    @JsonProperty("files-unwanted")
    private List<Integer> filesToSkip;

    /**
     * {@code true} if session upload limits are honored
     */
    private Boolean honorsSessionLimits;

    /**
     * Torrent list
     */
    private List<Long> ids;

    /**
     * New location of the torrent's content
     */
    private String location;

    /**
     * Maximum number of peers
     */
    @JsonProperty("peer-limit")
    private Integer peerLimit;

    /**
     * Indices of high-priority file(s)
     */
    @JsonProperty("priority-high")
    private List<Integer> highPriorityFiles;

    /**
     * Indices of low-priority file(s)
     */
    @JsonProperty("priority-low")
    private List<Integer> lowPriorityFiles;

    /**
     * Indices of normal-priority file(s)
     */
    @JsonProperty("priority-normal")
    private List<Integer> normalPriorityFiles;

    /**
     * Position of this torrent in its queue [0...n)
     */
    private Integer queuePosition;

    /**
     * Torrent-level number of minutes of seeding inactivity
     */
    private Integer seedIdleLimit;

    /**
     * Which seeding inactivity to use
     */
    private Integer seedIdleMode;

    /**
     * Torrent-level seeding ratio
     */
    private Double seedRatioLimit;

    /**
     * Which ratio to use
     */
    private Integer seedRatioMode;

    /**
     * Strings of announce URLs to add
     */
    @JsonProperty("trackerAdd")
    private List<String> trackersToAdd;

    /**
     * Ids of trackers to remove
     */
    @JsonProperty("trackerRemove")
    private List<String> trackersToRemove;

    /**
     * Pairs of <trackerId/new announce URLs>
     */
    @JsonProperty("trackerReplace")
    private List<String> trackersToReplace;

    /**
     * Maximum upload speed (KBps)
     */
    @JsonProperty("uploadLimit")
    private Long uploadLimitInKBps;

    /**
     * {@code true} if {@code uploadLimitInKBps} is honored
     */
    private Boolean uploadLimited;

}