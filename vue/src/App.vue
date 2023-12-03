<template>
  <div class="container">
    <div v-bind:class="notificationClass" v-show="notification" v-on:click="clearNotification">
      {{ notification?.message }}
    </div>
  </div>
  <div id="capstone-app">



    <router-view />
  </div>
</template>

<script>

export default {

  computed: {

    notification() {
      return this.$store.notification;
    },
    notificationClass() {
      return {
        'status-message': true,
        error: this.notification?.type?.toLowerCase() === 'error',
        success: this.notification?.type?.toLowerCase() === 'success'
      };
    },
  },
  methods: {
    clearNotification() {
      this.$store.commit('CLEAR_NOTIFICATION');
    },
  }
}

</script>
