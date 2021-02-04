<template>
  <div>
    <div class="dropDown">
      <header id="go-back-btn">
        <router-link to="/home">Go Back</router-link> |
        <router-link v-bind:to="{ name: 'cityLandmark' }">City Landmark</router-link>;
      </header>

      <select id="allCities" v-model="cityValue" v-on:change="cityName">
        <option v-for="city in cities" v-bind:key="city.name">
          
        </option>
      </select>

      <table>
        <tr id="cityPicked">
          {{
            cityChoice
          }}

          <tr v-for="option in cityResults" v-bind:key="option.id">
              <h2 class="results">{{ option.name }}</h2>
            
             <!--We will need this later if we want to bring photos over from assets <img v-bind:src="require(`../assets/${option.img}`)"/> -->
    
            </tr>
       
      </table>

      <!-- {{ cities }} 
     {{ landmark }}  -->
    </div>
  </div>
</template>

<script>
import City from "@/services/APIServices.js";
export default {
  data() {
    return {
    
      cities: [],
      cityValue: "",
      cityChoice: [],
      cityResults: [],
    };
  },

  
};
</script>


<style>

#allCities {
}
</style>