<template>
  <div>
    <div class="mainPage">
      <header id="go-back-btn">
        <router-link to="/home">Go Back</router-link> 
        
        <!-- <router-link v-bind:to="{ name: 'cityLandmark' }">City Landmark</router-link> -->
      </header>

{{filter.city}} | {{filter.venue}} | {{filteredByVenueType}} | {{cities}}
      <section id="allCities">
        <!-- placeholder='Select a City' -->
      <select v-model='filter.city'>
       <option :value="''" disabled selected>Select a City</option>
        <option v-for="city in cities" v-bind:key="city.id">
         {{city}} 
        </option>
      </select>

      <select v-model='filter.venue'>
       <option>Park</option>
       <option>Museum</option>
       <option>Zoo</option>
       <option>Library</option>
      </select>

      </section>

    
      <table>
        <tr>
    
          <tr v-for="option in filteredByVenueType" v-bind:key="option.name"> 
            <div class="results">
              <h2>{{ option.cityValue }}</h2>
        
            <h2>  {{option.name}} </h2>
              
              <div id="landmark-description">
              <br>
               {{option.description}}> 
              </div>
               <br>
                <img id="landmark-imgs" :src="option.images">
                <br>
                <div id="venueType">
                {{option.venueType}}
                </div>
                <br>
                <div id="operatingDays">
                {{option.operatingDays}}
                </div>
                <br> 
                <div id="openingTime-closingTime">
                {{option.openingTime}}
                <br>
                {{option.closingTime}}
                </div>
            </div>
            </tr>

<!--
      <section id="allVenueTypes">
      <select>
        <option v-for="venueType in filteredByVenueType " v-bind:key="venueType.name">
         {{venueType}} 
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
      City: [],
      cities: [],
      cityValue: "",
      cityChoice: [],
      cityResults: [],
      venueType: [],

    landmarkByCity : {
    images: '',
    name: '',
    description: '',
    venueType: '',
    operatingDays: '',
    openingTime: '',
    closingTime: ''
    },

    filter: {
    city: '',
    venueType: '',
    operatingDays: '',
    openingTime: '',
    closingTime: '',
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
  computed: {

   filteredByVenueType() {
      let filteredVenues = this.cityResults;
      if (this.filter.city != "") {
        filteredVenues = filteredVenues.filter((option) =>
          option.city
            .toLowerCase()
            .includes(this.filter.city.toLowerCase())
        );
      }

      return filteredVenues;
   }


  },

  methods: {

  }

  
};
</script>


<style>

 .results {
   display: grid;
   border: solid 3px;
   padding: 50px

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
border: solid
 2px;
padding-left: 20px;
}

 #mainPage {
  
}

h2 {
  display: flex;
  justify-content: center;
}

div > header  {
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

#openingTime-closingTime{
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