package com.trendyol.playlist.service.PlaylistService;

import com.trendyol.playlist.domain.Playlist;
import com.trendyol.playlist.domain.Track;
import com.trendyol.playlist.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.create(playlist);
    }
    public void deletePlaylist(String id) {
        playlistRepository.delete(id);
    }
    public Playlist findById(String id) {
        return playlistRepository.findById(id);
    }

    public List<Playlist> findAllByUserId(String userId) {
        return playlistRepository.findAllByUserId(userId);
    }

    public void removeTrackByID(String id, Track track){
        Playlist playlist = playlistRepository.findById((id));
        playlist.deleteTrack(track);
        playlistRepository.update(playlist);
    }

    public void addTrackByID(String id, Track track) {
        Playlist playlist = playlistRepository.findById(id);
        playlist.addTrack(track);
        playlistRepository.update(playlist);
    }
}

