<template>
    <div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-root-margin="0px 0px -40%"
        data-bs-smooth-scroll="true" class="collections scrollspy-example bg-body-tertiary rounded-2" tabindex="0">
        <collection class="collection-card" v-for="collection in this.collections" v-bind:key="collection.collectionId"
            v-bind:collection="collection" />
    </div>
</template>
  
<script>
export default {

};
</script>

<style scoped>
.collections {
    display: flex;
    flex-wrap: wrap;
    align-items: flex-start;
    align-content: flex-start;
    padding: 5px 0px 0px 5px;
    z-index: -3;
}
</style>
