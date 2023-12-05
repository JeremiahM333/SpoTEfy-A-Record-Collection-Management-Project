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
      <h1>ΣpoTEfy</h1>
      <div class="loading">
        <img src="../resources/giphy.gif">


      </div>
    </div>
  </div>

  <div v-else id="main-page">

    <nav class="navbar navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">
          <img src="../resources/project-log.png" alt="" width="30" height="24" class="d-inline-block align-text-center ">
          ΣpoTEfy
        </a>
      </div>
    </nav>
    <div class="container" id="form-margin">
      <form @submit="showAlert = true">

        <h1 class="text-center" id="form-header">Please Log In</h1>
        <div v-show="showAlert" class=" alert alert-success" role="alert">
          Successful login!
        </div>
        <!-- <div class="alert alert-danger" role="alert">
          Invalid username and password!
        </div> -->
        <div class="mb-3">
          <label for="exampleInputEmail1" class="form-label">Email address</label>
          <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        </div>
        <div class="mb-3">
          <label for="exampleInputPassword1" class="form-label">Password</label>
          <input type="password" class="form-control" id="exampleInputPassword1">
        </div>
        <button type="submit" class="btn btn-primary" id="submit-btn">Submit</button>
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
          this.$router.push("/");
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


#form-margin {
  height: 50vh;
  margin-top: 5rem;
  background-color: rgba(0, 0, 0, 0.5);
  color: white;
  border-radius: 1.5rem;

}

#main-page {
  background-image: url("../resources/vinyl-records_istock.jpg");
  height: 100vh;
}

.form-text {
  color: white;
}

#form-header {
  color: white;
  padding: 1rem;
}


#submit-btn {

  background-color: #E5B80B;
  border-color: #E5B80B;
}

#submit-btn:hover {
  background-color: #C09B09;
  border-color: white;
}
</style>