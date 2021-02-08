<template>
  <div>
    <div class="mainPage">
      <header id="title">
        <H1>Select a City and Venue Type Type to Explore</H1>

      </header>
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
          <option v-for="venueType in filteredLandmarks" v-bind:key="venueType.id">
            {{venueType.venueType}}
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
              v-on:change="selectLandmark(option.name, option.images, option.venueType, option.description)"
              v-bind:id="option.id"
              v-bind:value="option.id"
             
            />
            </div>
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
        isChecked: false
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
      }
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
    methods: {
    venueTypeFilter: function(val) {
      if(this.allVenueTypes.indexOf(val.id) === -1) {
        //arr.push(val.id);
        return val.id;
      }
    },

    selectLandmark: function(n, i, v, d) {
       this.selectedLandmark.name = n;
       this.selectedLandmark.images = i;
       this.selectedLandmark.venueType = v;
       this.selectedLandmark.description = d;

        for (i=0; i < this.selectedLandmarks.length; i++){
       if (this.selectedLandmark == this.selectedLandmarks[i]) {
         console.log("am I here?");
         this.selectedLandmarks.remove(this.selectedLandmark);
       } else {
         this.selectedLandmarks.push(this.selectedLandmark);
       }
        }

    }
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