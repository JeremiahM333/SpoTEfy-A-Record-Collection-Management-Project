<template>
  <!-- <div id="login">
    <form v-on:submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link v-bind:to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
   -->

  <div v-if="isLoading" class="text-center">
    <div class="container justify-content-end">
      <h1>SpoTEfy</h1>
      <div class="loading">
        <img src="src\giphy.gif">


      </div>
    </div>
  </div>

  <div v-else >

    <nav class="navbar navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="/docs/5.0/assets/brand/bootstrap-logo.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
      SpoTEfy
    </a>
  </div>
</nav>
<div class="container border rounded">
    <form @submit="showAlert = true">
     
      <h1 class="text-center log-in-class">Please Log In</h1>
      <div v-show="showAlert" class=" alert alert-success" role="alert">
        Successful login!
      </div>
      <div class="alert alert-danger" role="alert">
        Invalid username and password!
      </div>
      <div class="mb-3 row gy-2">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
      </div>
      <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
      </div>
      <button type="submit" class="btn btn-primary new-class">Sign in</button>
    </form>
  </div>
  </div>
</template>

<script>
import { computed } from "vue";
import authService from "../services/AuthService";

export default {
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false,
      showAlert: false,
      isLoading: false
    };


  },
  computed: {

  },

  methods: {

  
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
          this.isLoading = false;

          // TODO set up submit form and loading gif.

        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

/* .form-container {
background-color: black;
opacity: 90%;
}  */

.new-class {
  margin-bottom: 2rem;
  margin-top: 1rem;
}

.log-in-class {
  margin-top: 1rem;
  margin-bottom: 2rem;
}




</style>