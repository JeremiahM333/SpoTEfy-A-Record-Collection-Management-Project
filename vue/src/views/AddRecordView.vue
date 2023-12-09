<template>
  <div class="container">
    <form @submit.prevent="createRecord">
      <h1 class="text-center" id="form-header">Add Record</h1>

      <div class="mb-3">
        <label for="recordName" class="form-label">Record Name</label>
        <input type="text" class="form-control" id="recordName" aria-describedby="recordName" v-model="record.albumName">
      </div>
      <div class="mb-3">
        <label for="recordCover" class="form-label">Record Cover</label>
        <input type="text" class="form-control" id="recordCover" aria-describedby="recordCover"
          v-model="record.albumCover">
      </div>
      <div class="mb-3">
        <label for="releaseDate" class="form-label">Release Date</label>
        <input type="date" class="form-control" id="releaseDate" v-model="record.releaseDate">
      </div>
      <div class="mb-3">
        <select class="form-select" aria-label="Media Type" v-model="record.mediaType">
          <option selected>Media Type</option>
          <option value="Digital">Digital</option>
          <option value="Cd">Cd</option>
          <option value="Cassette">Cassette</option>
          <option value="Vinyl Record">Vinyl Record</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary" id="submit-btn">Add Record</button>
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
        mediaType: '',
        recordNotes: null
      }
    };
  }, methods: {
    createRecord() {
      RecordService.createRecord(this.record)
        .then((response) => {
          if (response.status == 201) {
            this.$router.push({
              path: '/library/' + this.$store.state.user.id,
            });
          }
        })
      //       .catch((error) => {
      //         const response = error.response;
      //         if (response.status === 400) {

      //         }
      //       });
    }

  }
}
</script>

<style scoped></style>