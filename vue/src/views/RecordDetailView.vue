<template>
    <div class="background" id="main-page">

        <div class="container" id="form-margin">
            <div class="detail-body">
                <img id="image" :src="useDefaultCoverArt ? defaultCoverArt : record.albumCover"
                    @error="replaceWithDefault()">
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
                    <h2 class="heading">Notes <button type="button" class="btn btn-primary btn-sm edit-btn">Edit
                            Notes</button></h2>
                    <p>This is a wider card with supporting text below as a natural lead-in to
                        additional This is a wider card with supporting text below as a natural lead-in to
                        additional This is a wider card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.</p>
                </div>
                <div id="date">{{ record.releaseDate }}</div>
                <div id="mediaType">{{ record.mediaType }}</div>

                
                    <div class="btn-group dropup button-container buttons" id="buttons">
                        <button class="btn btn-secondary dropdown-toggle collection-btn" type="button" data-bs-toggle="dropdown"
                            aria-expanded="false">
                            Collections
                        </button>
                        <ul class="dropdown-menu">
                            <li class="dropdown-item" v-for="collection in collections"
                                v-bind:key="collection.collectionId">
                                {{ collection.collectionName }}
                                <input class="form-check-input" type="checkbox" id="checkboxNoLabel"
                                    v-bind:value="collection.collectionId" v-model="collectionCheckbox">
                                <!-- // filter collections shown if record is already in that collection -->
                            </li>
                        </ul>
                
                    <div>
                        <button class="btn btn-primary add-btn" type="submit"
                            v-on:click.prevent="addRecordToCollection">Add</button>
                    </div>
                    </div>
            </div>
        </div>

    </div>
</template>


<script>

import RecordService from '../services/RecordService';
import ArtistsService from '../services/ArtistsService';
import GenresService from '../services/GenresService';
import CollectionsService from '../services/CollectionsService';


export default {
    data() {
        return {
            record: {},
            artists: [],
            genres: [],
            collections: [],
            collectionCheckbox: [],
            defaultCoverArt: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
            useDefaultCoverArt: false
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
    },


    methods: {
        addRecordToCollection() {
            CollectionsService
                .addRecordToCollection(this.record.recordId, this.collectionCheckbox)
        },
        replaceWithDefault() {
            this.useDefaultCoverArt = true;
        }
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
        "title      date"
        "title     mediaType"
        "buttons   ."
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

.add-btn {
    background-color: #E5B80B;
    border-color: #E5B80B;
    min-width: 15rem;
    max-width: 15rem;
    margin: 2rem;
}

.collection-btn {
    background-color: #E5B80B;
    border-color: #E5B80B;
    min-width: 15rem;
    max-width: 15rem;
    margin: 2rem;
}

.edit-btn {
    background-color: #E5B80B;
    border-color: #E5B80B;
}

.add-btn:hover {
    background-color: #C09B09;
    border-color: white;
}

.collection-btn:hover {
    background-color: #C09B09;
    border-color: white;
}

.edit-btn:hover {
    background-color: #C09B09;
    border-color: white;
}
.button-container {
    display: inline-flex;
    align-items: flex-start;

    
}

</style>