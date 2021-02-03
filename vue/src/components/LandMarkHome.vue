<template>
  <div>
    <div class="dropDown">
      <header id="go-back-btn">
        <router-link to="/home">Go Back</router-link>
      </header>

      <select id="allCities" v-model="cityValue" v-on:change="cityName">
        <option v-for="city in cities" v-bind:key="city.name">
          {{ city }}
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
      city: [],
      cities: [],
      cityValue: "",
      cityChoice: [],
      cityResults: [],
    };
  },

  created() {
    // window.alert(this.$store.state.token);
    // window.alert(this.$store.state.user);

    // Landmark.allLandmark()
    //   .then((response) => {
    //     this.landmark = response.data;
    //     console.log(this.landmark);
    //   })
    //   .catch((error) => {
    //     if (error.response) {
    //       ("Ope, Not Available Option :O");
    //     }
    //   });

    City.allCities()
      .then((response) => {
        this.cities = response.data;
            // this.cityChoice = response.data.name;
        console.log(this.cities);
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });
  },

  methods: {
    cityName() {
      City;
      cityResults;
      this.filler();
      City.cityResults(this.cityValue)
    
        .then((response) => {
          this.cityChoice = response.data;
          // this.cityResults = response.data;
        })
        .catch((error) => {
          if (error.response) {
            alert("Not Available Option");
          }
        });
    },

    cityLandmarks(cityName){
    City;  
      this.cityValue = response.data;
    },

    filler() {
      for (let i = 0; i < this.city.length; i++) {
        if (this.city[i].img == null) {
          this.city[i].img = "favicon.ico";
        }
      }
    },
  },
};
</script>


<style>

#allCities {
}
</style>