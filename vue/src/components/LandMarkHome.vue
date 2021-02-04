<template>
  <div>
    <div class="dropDown">
      <header id="go-back-btn">
        <router-link to="/home">Go Back</router-link> 
        <!-- <router-link v-bind:to="{ name: 'cityLandmark' }">City Landmark</router-link> -->
      </header>

      <select id="allCities" v-on:change="captureCityName($event)">
        <option v-for="city in cities" v-bind:key="city.id">
         {{city}} 
        </option>
      </select>

      <table>
        <tr id="cityPicked">
          {{
            
          }}
          
          <tr v-for="option in cityResults" v-bind:key="option.name"> 
            <div class="results">
              <h2>{{ option.cityValue }}</h2>
             <!-- <img v-bind:src="require(`../assets/${option.img}`)"/> -->
            <h2>  {{option.name}} </h2>
              
              <br>
               {{option.description}}
               <br>
                <img :src="option.images">
                <br>
                {{option.venueType}}
                <br>
                {{option.operatingDays}}
                <br> 
                {{option.openingTime}}
                <br> 
                {{option.closingTime}}
            </div>

            </tr>
       
      </table>
    </div>
  </div>
</template>

<script>
import cityAPI from "@/services/APIServices.js";
export default {
  data() {
    return {
      City: [],
      cities: [],
      cityValue: "",
      cityChoice: [],
      cityResults: [],

    landmarkByCity : {
    images: '',
    name: '',
    description: '',
    venueType: '',
    operatingDays: '',
    openingTime: '',
    closingTime: ''
    }
  };
  },
    created() {

    cityAPI.allCities()
      .then(
        (response) => {
          this.cities = response.data;
            // this.cityChoice = response.data.name;
          console.log(this.cities);
        }
      
      )
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });
  }, 
  methods: {
    captureCityName(event) {
      const selectBox = event.target;
      const index = event.target.selectedIndex;

      const value = selectBox.options[index].value;
      this.cityValue = value;

      // 1. call your API here to get landmarks by city.
        // 1a. When the results get back assign the results to an array in the data section.
      
    cityAPI.getLandmarkByCity(this.cityValue).then (
      (response) => {
        this.cityResults = response.data;
      }
    )
    }
  }

  
};
</script>


<style>

 .results {
   border: solid 2px;
   padding: 50px

}
</style>