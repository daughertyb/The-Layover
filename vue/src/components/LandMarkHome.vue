<template>
  <div>
    <div class="mainPage">
      <header id="go-back-btn">
        <router-link to="/home">Go Back</router-link>

        <!-- <router-link v-bind:to="{ name: 'cityLandmark' }">City Landmark</router-link> -->
      </header>
{{filteredVenues}}
      <section id="allCities">
        <!-- placeholder='Select a City' -->
        <select v-model="filter.city">
          <option :value="''" disabled selected>Select a City</option>
          <option v-for="city in cities" v-bind:key="city.id">
            {{ city }}
          </option>
        </select>

        <select v-model="filter.venue">
          <option>Park</option>
          <option>Museum</option>
          <option>Zoo</option>
          <option>Library</option>
        </select>
      </section>
       <table>
        <tr></tr>

        <tr v-for="option in filteredLandmarks" v-bind:key="option.id">
          <div class="results">
            <h2>{{ option.cityValue }}</h2>

            <h2>{{ option.name }}</h2>

            <div id="landmark-description">
              <br />
              {{ option.description }}
            </div>
            <br />
            <img id="landmark-imgs" :src="option.images" />
            <br />
            <div id="venueType">
              {{ option.venueType }}
            </div>
            <br />
            <div id="operatingDays">
              {{ option.operatingDays }}
            </div>
            <br />
            <div id="openingTime-closingTime">
              {{ option.openingTime }}
              <br />
              {{ option.closingTime }}
            </div>
          </div>
        </tr>

        <!--
      <section id="allVenueTypes">
      <select>
        <option v-for="landmark in filteredLandmarks" v-bind:key="landmark.name">
         {{landmark}} 
        </option>
      </select>
      </section>
-->
      </table>
    </div>
  </div>
</template>

<script>
import cityAPI from "@/services/APIServices.js";
export default {
  data() {
    return {
      cities: [],
      cityValue: "",

      // cityResults: [],
      venueType: [],
      allLandmarks: [],

      landmarkByCity: {
        images: "",
        name: "",
        description: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
      },

      filter: {
        city: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
      },
    };
  },
  created() {
    cityAPI
      .allCities()
      .then((response) => {
        this.cities = response.data;

        console.log(this.cities);
      })
      .catch((error) => {
        if (error.response) {
          ("Ope, Not Available Option :O");
        }
      });

    // 1. Load up all the data we need
    cityAPI.getAllLandmarks().then((response) => {
      this.allLandmarks = response.data;
    });
  },
  computed: {
    //   filteredByVenueType() {
    //     let filteredVenues = this.cityResults;
    //     if (this.filter.city != "") {
    //       filteredVenues = filteredVenues.filter((option) =>
    //         option.city
    //           .toLowerCase()
    //           .includes(this.filter.city.toLowerCase())
    //       );
    //     }
    //     return filteredVenues;
    //  }

    filteredLandmarks() {
      let filteredVenues = this.allLandmarks;
      if (this.filter.city != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.city.includes(this.filter.city)
        );
      }
      return filteredVenues;
    },

     filteredVenueType() {
      let filteredVenues = this.allLandmarks;
      if (this.filter.venueType != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.city.toLowerCase().includes(this.filter.venueType.toLowerCase())
        );
      }
      return filteredVenues;
    },


  },




  methods: {},
};
</script>


<style>
.results {
  display: grid;
  border: solid 3px;
  padding: 50px;
}

#landmark-imgs {
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  height: 450px;
  width: auto;
  margin: auto 0;
  grid-row: 6;
}

#landmark-description {
  font-size: 30px;
  border: solid 2px;
  padding-left: 20px;
}

#mainPage {
}

h2 {
  display: flex;
  justify-content: center;
}

div > header {
  display: flex;
  justify-content: space-around;
}

#allCities {
  display: flex;
  justify-content: center;
}

#venueType {
  display: flex;
  justify-content: center;
  font-size: 30px;
}

#operatingDays {
  display: flex;
  justify-content: center;
  font-size: 30px;
}

#openingTime-closingTime {
  display: flex;
  justify-content: center;
  font-size: 30px;
}

html {
  background-color: rgba(89, 106, 116, 0.411);
}

.results {
  background-color: rgba(69, 107, 138, 0.424);
}

#go-back-btn {
  font-size: 20px;
  padding-bottom: 20px;
}

select {
  font-size: 20px;
  background-color: rgba(123, 112, 230, 0.479);
}
</style>