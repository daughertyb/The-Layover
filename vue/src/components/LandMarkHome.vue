<template>
  <div>
     <table>
      <select v-model="cityValue" v-on:change="location">
        <option v-for="city in cities" v-bind:key="city">
          {{ cities }} 
          {{ landmark }}
        </option>
      </select>
    </table> 
    <h1>HI</h1>
        {{ cities }} 
     {{ landmark }} 
  </div>
</template>

<script>
import Landmark from "@/services/APIServices.js";
export default {
  data() {
    return {
      landmark: [],
      value: "",

      cities: [],
      cityValue: "",
    
    };
  },

  created() {

    // window.alert(this.$store.state.token);
    // window.alert(this.$store.state.user);

    Landmark.allLandmark()
      .then((response) => {
        this.landmark = response.data;
        console.log(this.landmark);
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });

      Landmark.allCities()
      .then((response) => {
        this.cities = response.data;
        console.log(this.cities);
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });
  },

  methods: {
    name() {
      this.filler();
      Landmark;
    },
    filler() {
      for (let i = 0; i < this.landmark.length; i++) {
        if (this.landmark[i].img == null) {
          this.landmark[i].img = "favicon.ico";
        }
      }
    },
  },
};
</script>


<style>
</style>