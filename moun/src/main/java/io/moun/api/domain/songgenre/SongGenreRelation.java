package io.moun.api.domain.songgenre;

import io.moun.api.domain.genre.Genre;
import io.moun.api.domain.member.Member;
import io.moun.api.domain.position.Position;
import io.moun.api.domain.song.Song;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "song_genre_relation",
        uniqueConstraints = {@UniqueConstraint(
                name = "UniqueSongAndGenre",
                columnNames = {
                        "song_id", "genre_id"
                }
        )}
)
public class SongGenreRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
