package com.trendyol.playlist.domain;

import lombok.*;
import java.util.UUID;
import java.util.List;

@Getter
@Setter
public class Playlist {
    private String id;
    private String name;
    private String description;
    private int followersCount;
    private List<Track> tracks;
    private int trackCount;
    private String userId;


    public Playlist(String name, String description, int followersCount, List<Track> tracks, String userId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.userId = userId;
    }

    public Playlist(String id, String name, String description, int followersCount, List<Track> tracks, int trackCount, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.followersCount = followersCount;
        this.tracks = tracks;
        this.trackCount = trackCount;
        this.userId = userId;
    }

    public void addTrack(Track track) {
        this.tracks.add(track);
        this.trackCount += 1;
    }

    public void deleteTrack(Track track) {
        for (Track obj : this.tracks) {
            if (obj.getName().equals(track.getName()))
            {
                this.tracks.remove(track);
                this.trackCount -= 1;
            }
        }
    }
}


