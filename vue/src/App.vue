<template>
<div class="container">
  <div v-bind:class="notificationClass" v-show="notification" v-on:click="clearNotification">
{{ notification?.message }}
  </div>
</div>
  <div id="capstone-app">
    <div id="nav">

      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <nav class="navbar navbar-light bg-light">
      <div class="container-fluid">
        <router-link class="navbar-brand" href="#" v-bind:to="{ name: 'home' }">
          <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24"
            class="d-inline-block align-text-top">
          Home
        </router-link>

      </div>
    </nav>
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
    'status-message':true, 
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
