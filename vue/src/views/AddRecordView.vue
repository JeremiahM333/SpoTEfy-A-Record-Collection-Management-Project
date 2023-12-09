<template>
  <div class="picture-container">
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

        <div class="mb-3">
          <label for="releaseDate" class="form-label">Release Date</label>
          <input type="date" class="form-control form-control-lg" id="releaseDate" v-model="record.releaseDate">
        </div>

        <div class="mb-3">
          <label for="mediaInput" class="form-label">Choose Media Type</label>
          <select class="form-select form-select-lg" aria-label="Media Type" v-model="record.mediaType">
            <!-- <option selected>Media Type</option> -->
            <option value="Vinyl">Vinyl</option>
            <option value="Cassette">Cassette</option>
            <option value="CD">CD</option>
            <option value="Digital">Digital</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary" id="submit-btn">Add Record</button>

      </div>

    </form>
  </div>
</template>

<script>
import RecordService from '../services/RecordService';

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
      previewImage: 'https://static.tumblr.com/exbflx8/z13m20ek0/cover.png',
      createRecordError: false,
      createRecordErrorMsg: 'There was a problem submitting the record.',
    };

  }, methods: {
    addRecord() {
      if (this.record.albumName === '') {
        this.createRecordError = true;
        this.createRecordErrorMsg = 'You need a title.';
      } else {
        this.record.userId = this.$store.state.user.id;

        RecordService
          .createRecord(this.record)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push(
                { name: "library", params: { userId: this.$store.state.user.id } }
              );
            }
          })
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

  }
}
</script>

<style scoped>
.picture-container {
  background-image: url(../resources/5-reasons-create-cds-of-your-releases.jpg);
  background-size: cover;
  padding-top: 30px;
  padding-bottom: 70px;
  height: 100%;
}

.container {
  width: 45%;
  background-color: black;
  opacity: 85%;
  border-radius: 1.5rem;
}

/* #previewImage {
  display: flex;
  justify-self: center;
  height: 30vh;
  margin-top: 2rem;
  margin-bottom: 1rem;
  margin-left: 11rem;
} */

#form-header {
  color: white;
}

.form-label {
  color: white;
}

#submit-btn {
  background-color: #E5B80B;
  border-color: #E5B80B;
  margin-bottom: 1.5rem;
  align-self: flex-start;
}

#submit-btn:hover {
  background-color: #c09b09;
  border-color: white;
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
</style>
