package com.trendyol.playlist.controller;


import com.trendyol.playlist.domain.Playlist;
import com.trendyol.playlist.domain.Track;
import com.trendyol.playlist.service.PlaylistService.PlaylistService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {
    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }
    @PostMapping
    public ResponseEntity<Void>createPlaylist(@RequestBody Playlist playlist){
        playlistService.createPlaylist(playlist);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Playlist>> findAllByUserId(@RequestParam String userId){
        return ResponseEntity.ok(playlistService.findAllByUserId(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity findPlaylistById(@PathVariable String id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlaylistById(@PathVariable String id){
        playlistService.deletePlaylist(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("{id}/tracks")
    public ResponseEntity<Void> addTrackByID(@PathVariable String id, @RequestBody Track track) {
        playlistService.addTrackByID(id, track);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}/track")
    public ResponseEntity removeTrackByID(@PathVariable String id, @RequestBody Track track) {
        playlistService.removeTrackByID(id, track);
        return ResponseEntity.noContent().build();
    }
}
