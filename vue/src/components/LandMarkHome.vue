<template>
  <div class="mainPage">
    <div>
      <div>
      <header id="title">
            {{$store.state.selectedLandmarks}}
        <H1>Select a City and Venue Type to Explore</H1>
        <!-- <button class="top-Itinerary-Button">Add Items to Itinerary</button> -->
      </header>

        <form action= "/itinerary">
      <div class="box-1">
        <router-link to="/itinerary" class="btn btn-one" v-on:click="addToItinerary">
          <span>Create an Itinerary</span>
        </router-link>
        </div>
        </form>
      </div>

      <section id="allCities">
        <!-- placeholder='Select a City' -->
        <select v-model="filter.city">
          <option :value="''" disabled selected>All Cities</option>
          <option v-for="city in cities" v-bind:key="city.id">
            {{ city }}
          </option>
        </select>

        <select v-model="filter.venueType">
          <option :value="''" disabled selected>All Venues</option>
          <option
            v-for="venueType in filteredLandmarks"
            v-bind:key="venueType.id"
          >
            {{ venueType.venueType }}
          </option>
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
            <div>
              <input
                type="checkbox"
                v-on:change="
                  selectLandmark(
                    option.name,
                    option.images,
                    option.venueType,
                    option.description
                  )
                "
                v-bind:id="option.id"
                v-bind:value="option.id"
              />
            </div>
          </div>
        </tr>
        <footer>
     <div class="box-1">
        <div class="btn btn-one">
          <span>Create an Itinerary</span>
        </div>
      </div>
     </footer>
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
      allLandmarks: [],
      selectedLandmarks: [],
      landmarkByCity: {
        images: "",
        name: "",
        description: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
        isChecked: false,
      },

      filter: {
        city: "",
        venueType: "",
        operatingDays: "",
        openingTime: "",
        closingTime: "",
      },
      selectedLandmark: {
        name: "",
        images: "",
        venueType: "",
        description: "",
      },
    };
  },
  created() {
    cityAPI
      .allCities()
      .then((response) => {
        this.cities = response.data;
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
  methods: {

  addToItinerary() {

    // pass the this.selectedLandmarks array to the mutator.
    this.$store.commit('ADDSELECTEDLANDMARKS', this.selectedLandmarks);
    
  },
    venueTypeFilter: function (val) {
      if (this.allVenueTypes.indexOf(val.id) === -1) {
        //arr.push(val.id);
        return val.id;
      }
    },

    selectLandmark(n, i, v, d) {
      this.selectedLandmark.name = n;
      this.selectedLandmark.images = i;
      this.selectedLandmark.venueType = v;
      this.selectedLandmark.description = d;

        let found = false;
        let indexFound = -123;

        for (let i = 0; i < this.selectedLandmarks.length; i++) {

          if (this.selectedLandmarks[i].name === this.selectedLandmark.name) {
            found = true;
            indexFound = i;
          }
        }

        if (found) {
          this.selectedLandmarks.splice(indexFound, 1);
        } else {

          let newLandMark = {
            name : this.selectedLandmark.name,
            images : this.selectedLandmark.images,
            venueType : this.selectedLandmark.venueType,
            description: this.selectedLandmark.description
          }

          this.selectedLandmarks.push(newLandMark);
        }
    },
  },



  computed: {
    filteredLandmarks() {
      let filteredVenues = this.allLandmarks;
      if (this.filter.city != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.location.includes(this.filter.city)
        );
      }

      if (this.filter.venueType != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.venueType.includes(this.filter.venueType)
        );
      }
      return filteredVenues;
    },
  },
};
</script>


<style>
@import "https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300";

/* html,
/* body {
  width: 100%;
  height: 100%;
  overflow: hidden;
  margin: 0;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  font-family: "Open Sans Condensed", sans-serif;
} */ 

div[class*="box"] {
  height: 33.33%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: right;
}


/* Top one makes whole color of button */
/* .box-1 {
  background-color: #4063a581;
} */


.btn {
  line-height: 50px;
  height: 50px;
  text-align: center;
  width: 250px;
  cursor: pointer;
  
}

.btn-one {
  /* Button text color */
  background-color: #4063a581;
  color: rgb(0, 0, 0);  
  transition: all 0.3s;
  position: relative;
  font-size: 1.5rem;
  font-weight: 600;
  border-radius: 25px;
  
}
.btn-one span {
  transition: all 0.3s;
}
.btn-one::before {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  opacity: 0;
  transition: all 0.3s;
  border-top-width: 1px;
  border-bottom-width: 1px;
  border-top-style: solid;
  border-bottom-style: solid;
  border-top-color: rgba(255, 255, 255, 0.5);
  border-bottom-color: rgba(255, 255, 255, 0.5);
  transform: scale(0.1, 1);
}
.btn-one:hover span {
  letter-spacing: 3px;
  
}
.btn-one:hover::before {
  opacity: 1;
  transform: scale(1, 1);
}
.btn-one::after {
  content: "";
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
  transition: all 0.3s;
  background-color: rgba(255, 255, 255, 0.1);
}
.btn-one:hover::after {
  opacity: 0;
  transform: scale(0.1, 1);
}

/* ---------------------------------------------------------------------------------------------------------------------------- */
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
  padding-bottom: 20px;
  font-weight: 500;
}

.mainPage {
  font-family: "Open Sans Condensed", sans-serif;
}

h2 {
  display: flex;
  justify-content: center;
  font-size: 2rem;
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
  margin-top: 10px;
}
</style>