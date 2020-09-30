package com.trendyol.playlist.repository;

import com.couchbase.client.java.Collection;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.playlist.domain.Playlist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlaylistRepository {
    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;

    public PlaylistRepository(Cluster couchbaseCluster, Collection playlistCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = playlistCollection;
    }
    public Playlist create(Playlist playlist){
        playlistCollection.insert(playlist.getId(), playlist);
        return playlist;
    }
    public void update(Playlist playlist){
        playlistCollection.replace(playlist.getId(), playlist);
    }

    public void delete(String id){
        playlistCollection.remove(id);
    }
    public Playlist findById(String id){
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }
    public List<Playlist> findAllByUserId(String userId){
        String statement = "Select id, name, description, followersCount, tracks, trackCount, userId from playlist WHERE userId=$userId";
        QueryResult query = couchbaseCluster.query(statement);
        return query.rowsAs(Playlist.class);
    }
}
