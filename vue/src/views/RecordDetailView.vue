<template>
    <div class="background" id="main-page">

        <div class="container" id="form-margin">
            <div class="detail-body">
                <img id="image" :src="record.albumCover" @error="replaceWithDefault()">
                <h3 id="title">{{ record.albumName }}</h3>

                <div id="artist">
                    <h2 class="heading">Artists</h2>
                    <h4 v-for="artist in artists" v-bind:key="artist.artistId">{{ artist.artistName }}</h4>
                </div>
                <div id="genre">
                    <h2 class="heading">Genres</h2>
                    <h5 v-for="genre in genres" v-bind:key="genre.genreId">{{ genre.genreName }}</h5>
                </div>
                <div id="notes">
                    <h2 class="heading">Notes</h2>
                    <p>This is a wider card with supporting text below as a natural lead-in to
                        additional This is a wider card with supporting text below as a natural lead-in to
                        additional This is a wider card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.</p>
                </div>
                <div id="date">{{ record.releaseDate }}</div>
                <div id="mediaType">{{ record.mediaType }}</div>

                <div class="btn-group dropup">
                    <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                        Add To Collection
                    </button>
                    <ul class="dropdown-menu">
                        <li class="dropdown-item" v-for="collection in collections" v-bind:key="collection.collectionId">
                            {{ collection.collectionName }}
                            <input class="form-check-input" type="checkbox" id="checkboxNoLabel"
                                value="collection.collectionName">

                        </li>
                    </ul>
                </div>

            </div>
        </div>

    </div>
</template>


<script>

import RecordService from '../services/RecordService';
import ArtistsService from '../services/ArtistsService';
import GenresService from '../services/GenresService';
// import Collection from '../components/Collection.vue';
import CollectionsService from '../services/CollectionsService';


export default {
    data() {
        return {
            record: [],
            artists: [],
            genres: [],
            collections: []
        }
    },

    created() {
        RecordService.getRecordByRecordId(this.$store.state.currentRecord)
            .then(response => {
                this.record = response.data;
            });
        ArtistsService.getArtistsByRecordId(this.$store.state.currentRecord)
            .then(response => {
                this.artists = response.data;
            });
        GenresService.getGenresByRecordId(this.$store.state.currentRecord)
            .then(response => {
                this.genres = response.data;
            });
        CollectionsService.getCollectionsByUserId(this.$store.state.user.id)
            .then(response => {
                this.collections = response.data;
            });
    }
}


</script>



<style scoped>
.background {
    background-image: url(../resources/ezgif.com-gif-maker-10-.jpg);
    background-size: cover;
    height: 100%;
    padding-top: 3rem;
    padding-bottom: 5rem;
}


#form-margin {
    background-color: rgba(0, 0, 0, 0.5);
    color: white;
    border-radius: 1.5rem;

}

.detail-body {
    height: 70%;
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas:
        "image     artist"
        "image     genre"
        "image     notes"
        "title    date"
        "title     mediaType"
        "buttons    buttons"
    ;
    padding: 0%;
}

#image {
    grid-area: image;
    min-height: 30rem;
    min-width: 30rem;
    max-height: 30rem;
    max-width: 30rem;

    padding-top: 3rem;
    padding-left: 3rem;
    padding-bottom: 1.5rem;

}

#title {
    grid-area: title;
    padding-bottom: 10rem;
    text-align: center;
    padding-right: 8rem;
}

#artist {
    grid-area: artist;
}

#genre {
    grid-area: genre;
}

#date {
    grid-area: date;
}

#mediaType {
    grid-area: mediaType;
}

#notes {
    grid-area: notes;
}

#buttons {
    grid-area: buttons;
    padding-bottom: 2rem;
}

.heading {
    font-weight: bold;
}

.btn {
    background-color: #E5B80B;
    border-color: #E5B80B;
}

.btn:hover {
  background-color: #C09B09;
  border-color: white;
}
</style>