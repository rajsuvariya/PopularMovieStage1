package com.rajsuvariya.popularmoviesstage1.data.remote.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created by @raj on 09/06/18.
 */
@Entity(tableName = "fav_movies")
public class MovieDetailsOutputModel {

    @SerializedName("adult")
    @Expose
    @Ignore
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("budget")
    @Expose
    @Ignore
    private Integer budget;
    @SerializedName("genres")
    @Expose
    @Embedded
    @Ignore
    private List<Genre> genres = null;
    @SerializedName("homepage")
    @Expose
    @Ignore
    private String homepage;
    @SerializedName("id")
    @Expose
    @PrimaryKey // Denotes id as the primary key
    private Integer id;
    @SerializedName("imdb_id")
    @Expose
    @Ignore
    private String imdbId;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("production_companies")
    @Expose
    @Ignore
    private List<ProductionCompany> productionCompanies = null;
    @SerializedName("production_countries")
    @Expose
    @Ignore
    private List<ProductionCountry> productionCountries = null;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("revenue")
    @Expose
    @Ignore
    private Integer revenue;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("spoken_languages")
    @Expose
    @Ignore
    private List<SpokenLanguage> spokenLanguages = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("videos")
    @Expose
    @Ignore
    private Videos videos;
    @SerializedName("credits")
    @Expose
    @Ignore
    private Credits credits;

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<ProductionCountry> getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(List<ProductionCountry> productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<SpokenLanguage> getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(List<SpokenLanguage> spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public Credits getCredits() {
        return credits;
    }

    public void setCredits(Credits credits) {
        this.credits = credits;
    }

    public class ProductionCompany {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("logo_path")
        @Expose
        private String logoPath;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("origin_country")
        @Expose
        private String originCountry;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginCountry() {
            return originCountry;
        }

        public void setOriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }

    }

    public class ProductionCountry {

        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @SerializedName("name")
        @Expose
        private String name;

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class Result {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("site")
        @Expose
        private String site;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("type")
        @Expose
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class SpokenLanguage {

        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("name")
        @Expose
        private String name;

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public class Videos {

        @SerializedName("results")
        @Expose
        @Ignore
        private List<Result> results = null;

        public List<Result> getResults() {
            return results;
        }

        public void setResults(List<Result> results) {
            this.results = results;
        }

    }

    public class Cast {

        @SerializedName("cast_id")
        @Expose
        private Integer castId;
        @SerializedName("character")
        @Expose
        private String character;
        @SerializedName("credit_id")
        @Expose
        private String creditId;
        @SerializedName("gender")
        @Expose
        private Integer gender;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("order")
        @Expose
        private Integer order;
        @SerializedName("profile_path")
        @Expose
        private String profilePath;

        public Integer getCastId() {
            return castId;
        }

        public void setCastId(Integer castId) {
            this.castId = castId;
        }

        public String getCharacter() {
            return character;
        }

        public void setCharacter(String character) {
            this.character = character;
        }

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getOrder() {
            return order;
        }

        public void setOrder(Integer order) {
            this.order = order;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

    }

    public class Credits {

        @SerializedName("cast")
        @Expose
        @Ignore
        private List<Cast> cast = null;
        @SerializedName("crew")
        @Expose
        @Ignore
        private List<Crew> crew = null;

        public List<Cast> getCast() {
            return cast;
        }

        public void setCast(List<Cast> cast) {
            this.cast = cast;
        }

        public List<Crew> getCrew() {
            return crew;
        }

        public void setCrew(List<Crew> crew) {
            this.crew = crew;
        }

    }

    public class Crew {

        @SerializedName("credit_id")
        @Expose
        private String creditId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("gender")
        @Expose
        private Integer gender;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("job")
        @Expose
        private String job;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("profile_path")
        @Expose
        private String profilePath;

        public String getCreditId() {
            return creditId;
        }

        public void setCreditId(String creditId) {
            this.creditId = creditId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProfilePath() {
            return profilePath;
        }

        public void setProfilePath(String profilePath) {
            this.profilePath = profilePath;
        }

    }


    @Override
    public String toString() {
        return "MovieDetailsOutputModel{" +
                ", id=" + id +
                ", originalTitle='" + originalTitle + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
