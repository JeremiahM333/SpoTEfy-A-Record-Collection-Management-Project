<template>
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
