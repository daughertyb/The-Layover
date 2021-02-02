<template>
  <div class="home">
   

    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <input type="text">

    <Landmark-Home/>


  </div>

</template>

<script>
import LandmarkHome from '../components/LandMarkHome'

export default {
  components: {
    LandmarkHome
  },
  name: "home",
  
};
</script>

<style>


</style>