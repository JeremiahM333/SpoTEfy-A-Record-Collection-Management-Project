<template>
  <!-- <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="collections scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <collection v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:collection="collection" />
    </div> -->

  <div class="add-collection-pg">

    <form class="container ">
      <div class="alert alert-danger" role="alert" v-if="createCollectionErrors">
        {{ createCollectionErrorMsg }}
      </div>

      <div>
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label"></label>
          <input type="text" class="form-control form-control-lg" id="exampleFormControlInput1"
            placeholder="Enter Collection Title Here" v-model="newCollection.collectionName">
        </div>

        <div>
          <label for="formFileLg" class="form-label">Upload Collection Cover</label>
          <input class="form-control form-control-lg" id="formFileLg" type="file" accept="image/jpeg" @change=uploadImage>
          <img :src="previewImage" id="previewImage" class="uploading-image" />
        </div>

        <div class="mb-3">
          <label for="visibilityInput" class="form-label">Choose Collection Visibility</label>
          <select class="form-select form-select-lg" id="visibilityInput" aria-label="" v-model="newCollection.public">
            <option value="true">Public</option>
            <option value="false">Private</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary" id="submit-btn" v-on:click.prevent="addCollection">Create
          Collection</button>

      </div>
    </form>

  </div>
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
        public: true,
      },
      disappear: false,
      previewImage: 'https://cdn3.iconfinder.com/data/icons/ios-edge-glyph-1/25/Album-Collection-512.png',
      createCollectionErrors: false,
      createCollectionErrorMsg: 'There were problems submitting the collection.',
    }
  },
  methods: {
    uploadImage(e) {
      const image = e.target.files[0];
      const reader = new FileReader();
      reader.readAsDataURL(image);
      reader.onload = e => {
        this.newCollection.collectionCover = e.target.result;

        console.log(e.target.result);

        this.previewImage = e.target.result;
        console.log(this.newCollection.collectionCover);
      };
    },
    addCollection() {
      if (this.newCollection.collectionName === '') {
        this.createCollectionErrors = true;
        this.createCollectionErrorMsg = 'You need a title for the collection.';
      } else {
        this.newCollection.userId = this.$store.state.user.id;

        console.log(this.newCollection.userId);

        CollectionsService
          .createCollection(this.newCollection)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/',                                  // Remember to send to Personal Collections
                // query: { registration: 'success' },
              });
            }
            // console.log('Collection creation successful');
          })
          .catch((error) => {
            const response = error.response;
            this.createCollectionErrors = true;
            if (response.status === 400) {
              this.createCollectionErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    }
  }
};

</script>




<style scoped>
.add-collection-pg {
  align-self: center;
  background-image: url(../resources/s-l1600.jpg);
  background-size: cover;
  padding-top: 40px;
  padding-bottom: 40px;
  height: 100%;
}


#previewImage {
  display: flex;
  justify-self: center;
  height: 30vh;
  margin-top: 2rem;
  margin-bottom: 2rem;
  margin-left: 11rem;
}

.container {
  width: 45%;
  background-color: black;
  opacity: 90%;
  border-radius: 1.5rem;
}

#submit-btn {
  background-color: #E5B80B;
  border-color: #E5B80B;
  margin-bottom: 2rem;
}

#submit-btn:hover {
  background-color: #c09b09;
  border-color: white;
}

.form-label {
  color: white;
}


</style>