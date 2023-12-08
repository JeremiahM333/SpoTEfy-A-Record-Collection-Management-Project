<template>
  <!-- <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="collections scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <collection v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:collection="collection" />
    </div> -->

  <form class="container border " @submit.prevent="addCollection">
    <div>
      <div class="mb-3">
        <label for="exampleFormControlInput1" class="form-label">Collection Title</label>
        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Collection Title">
      </div>

      <div>
        <label for="formFileLg" class="form-label">Upload Collection Cover</label>
        <input class="form-control form-control-lg" id="formFileLg" type="file" accept="image/jpeg" @change=uploadImage>
        <img :src="previewImage" class="uploading-image" />
      </div>

      <div class="mb-3">
        <label for="visibilityInput" class="form-label">Choose Visibility</label>
        <select class="form-select" id="visibilityInput" aria-label="" v-model="newCollection.isPublic">
          <option value="true">Public</option>
          <option value="false">Private</option>
        </select>
      </div>

      <button type="submit" class="btn btn-primary" id="submit-btn">Create Collection</button>

    </div>
  </form>
</template>
  



<script>
import CollectionsService from '../services/CollectionsService';

export default {
  data() {
    return {
      newCollection: {
        userId: 0,
        collectionId: 0,
        collectionName: '',
        collectionCover: '',
        isPublic: true,
      },
      previewImage: 'https://cdn3.iconfinder.com/data/icons/ios-edge-glyph-1/25/Album-Collection-512.png',
      addCollectionErrors: false,
      addCollectionErrorMsg: 'There were problems submitting the collection.',
    }
  },
  methods: {
    uploadImage(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = e => {
        this.newCollection.collectionCover = e.target.result;
        this.previewImage = e.target.result;
        console.log(this.newCollection.collectionCover);
      };
    },
    addCollection() {
      if (this.newCollection.collectionName === '') {
        this.addCollectionErrors = true;
        this.addCollectionErrorMsg = 'You need a title for the collection.';
      } else {
        this.newCollection.userId = this.$store.state.user.id;

        CollectionsService
          .addCollection(this.newCollection)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/',                                  // Remember to send to Personal Collections
                // query: { registration: 'success' },
              });
            }
            console.log('Collection creation successful');
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    }
  }
};

</script>




<style scoped></style>