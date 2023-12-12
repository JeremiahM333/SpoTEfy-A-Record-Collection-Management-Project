<template>
  <div class="picture-container">
    <img src="../resources/5-reasons-create-cds-of-your-releases.jpg" id="backgroundImage">

    <form @submit.prevent="addRecord" class="container">

      <div id="collectionForm">


        <div class="firstInput formInput mb-3">
          <div class="alert alert-danger" role="alert" v-if="createRecordError">
            {{ createRecordErrorMsg }}
          </div>

          <label for="recordName" class="form-label"></label>
          <input type="text" class="form-control form-control-lg" id="recordName" placeholder="Enter Record Name Here"
            aria-describedby="recordName" v-model="record.albumName">
        </div>

        <div id="pictureInput">
          <label for="formFileLg" class="form-label">Upload Record Cover</label>
          <input class="form-control form-control-lg" id="formFileLg" type="file" accept="image/jpeg" @change=uploadImage>
          <img :src="previewImage" id="previewImage" class="uploading-image" />
        </div>

        <div class="artistInput formInput mb-3 listInput">
          <!-- <label for="ArtistNames" class="form-label">Artists</label> -->
          <!-- <ul id="ArtistNames"> -->
            <li v-for="n in getNumOfArtists" v-bind:key="n" class="listItem">
              <input type="text" class="form-control form-control-lg artistNameInputs"
                placeholder="Enter Artist Name Here" aria-describedby="artistName" v-model="artists[n - 1]">
              <!-- <button type="button" class="btn btn-primary goldButtons removeButton"
                @click="removeArtist(n - 1)">X</button> -->
            </li>
          <!-- </ul> -->
          <button type="button" class="btn btn-primary goldButtons" id="add-artist" @click="numOfArtists++">Add Additional
            Artist</button>
        </div>

        <div class="genreInput formInput mb-3 listInput">
          <!-- <label for="GenreNames" class="form-label">Genres</label> -->
          <!-- <ul id="GenreNames"> -->
            <li v-for="n in getNumOfGenres" v-bind:key="n" class="listItem">
              <input type="text" class="form-control form-control-lg genreNameInputs" placeholder="Enter Genre Name Here"
                aria-describedby="genreName" v-model="genres[n - 1]">
              <!-- <button type="button" class="btn btn-primary goldButtons removeButton"
                @click="removeGenre(n - 1)">X</button> -->
            </li>
          <!-- </ul> -->
          <button type="button" class="btn btn-primary goldButtons" id="add-artist" @click="numOfGenres++">Add Additional
            Genre</button>
        </div>

        <div class="mb-3">
          <label for="releaseDate" class="form-label">Release Date</label>
          <input type="date" class="form-control form-control-lg" id="releaseDate" v-model="record.releaseDate">
        </div>

        <div class="mb-3">
          <label for="mediaInput" class="form-label">Choose Media Type</label>
          <select class="form-select form-select-lg" id="mediaInput" aria-label="Media Type" v-model="record.mediaType">
            <option value="Vinyl">Vinyl</option>
            <option value="Cassette">Cassette</option>
            <option value="CD">CD</option>
            <option value="Digital">Digital</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary goldButtons" id="submit-btn">Add Record</button>

      </div>

    </form>
  </div>
</template>

<script>
import RecordService from '../services/RecordService';
import ArtistsService from '../services/ArtistsService';
import GenresService from '../services/GenresService';

export default {
  data() {
    return {
      record: {
        userId: this.$store.state.user.id,
        albumName: '',
        albumCover: '',
        releaseDate: '',
        mediaType: 'Vinyl',
        recordNotes: null
      },
      artists: [''],
      genres: [''],
      numOfArtists: 1,
      numOfGenres: 1,
      previewImage: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
      createRecordError: false,
      createRecordErrorMsg: 'There was a problem submitting the record.',
    };

  },
  computed: {
    getNumOfArtists() {
      return this.numOfArtists;
    },
    getNumOfGenres() {
      return this.numOfGenres;
    }
  },
  methods: {
    addRecord() {
      if (this.record.albumName === '') {
        this.createRecordError = true;
        this.createRecordErrorMsg = 'You need a title.';
      } else {
        this.record.userId = this.$store.state.user.id;

        RecordService
          .createRecord(this.record, this.artists, this.genres)
          .then((response) => {
            if (response.status == 201) {
              this.record = response.data;

              let artistsToAdd = this.artists.filter(r => r != '');
              ArtistsService.addRecordToArtists(this.record.recordId, artistsToAdd);

              let genresToAdd = this.genres.filter(r => r != '');
              GenresService.addGenresToRecord(this.record.recordId, genresToAdd);

              this.$router.push(
                { name: "library", params: { userId: this.$store.state.user.id } }
              );
            }
          })
          .catch((e) => { this.createRecordErrorMsg = "Failed to create Record"; });
        // We should have put a list of artists and genres on the Record Model. Something learned for next time. Might fixed later if I have time
      }
    },
    uploadImage(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = e => {
        this.record.albumCover = e.target.result;

        console.log("This is line 101" + e.target.result);

        this.previewImage = e.target.result;

      };
    },
    removeArtist(index) {
      this.artists.pop(index);
    },
    removeGenre(index) {
      this.artists.pop(index);
    }
  }
}
</script>

<style scoped>
.picture-container {
  padding-top: 30px;
  padding-bottom: 70px;
  height: 100%;
}

#backgroundImage {
  position: fixed;
  width: 86%;
  top: 80px;
  bottom: 40px;
}

.container {
  width: 45%;
  background-color: black;
  opacity: 85%;
  border-radius: 1.5rem;
}

#form-header {
  color: white;
}

.form-label {
  color: white;
}

.goldButtons {
  background-color: #E5B80B;
  border-color: #E5B80B;
  align-self: flex-start;
}

.goldButtons:hover {
  background-color: #c09b09;
  border-color: white;
}

#submit-btn {
  margin-bottom: 1.5rem;
}

#previewImage {
  height: 30vh;
  align-self: center;
  margin-top: 1rem;
  margin-bottom: 1rem;
}

.alert {
  margin-bottom: 0px;
  margin-top: 1.5rem;
  width: 100%;
}

#collectionForm {
  display: flex;
  flex-direction: column;
}

#pictureInput {
  display: flex;
  flex-direction: column;
}

.listInput {
  margin-top: 0.5rem;
}

.listItem {
  display: flex;
  align-items: stretch;
}

.removeButton {
  height: 100%;
}

#add-artist {
  margin-top: 1rem;
}


</style>
