package com.trendyol.playlist.domain;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Track {
    private String name;
    private String lenght;
    private String artist;
}

