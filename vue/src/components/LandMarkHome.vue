<template>
  <div>
    <table>
      <select v-model="value" v-on:change="name">
        <option v-for="option in landmark" v-bind:key="option.id">
          {{ landmark }}
        </option>
      </select>
    </table>
     <!-- {{ landmark }} -->
  </div>
</template>

<script>
import Landmark from "@/services/AuthService.js";
export default {
  data() {
    return {
      landmark: [],
      value: "",
    };
  },

  created() {
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