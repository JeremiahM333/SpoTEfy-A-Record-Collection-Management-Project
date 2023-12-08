<template>
  <!-- <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="collections scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <collection v-for="collection in collections" v-bind:key="collection.collectionId" v-bind:collection="collection" />
    </div> -->

  <form class="container border ">
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
        <select class="form-select" aria-label="" v-model="newCollection.isPublic">
          <option selected>Choose visibility</option>
          <option value="true">Public</option>
          <option value="false">Private</option>
        </select>
      </div>

    </div>
  </form>
</template>
  



<script>
export default {
  data() {
    return {
      newCollection: {
        userId: 0,
        collectionId: 0,
        collectionCover: '',
        isPublic: false,
      },
      previewImage: ''
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
    }
  }


};



</script>




<style scoped></style>