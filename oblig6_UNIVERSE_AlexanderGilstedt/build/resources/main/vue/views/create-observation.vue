<template id="create">
    <div class="form-style">
        <h2>Create new Observation</h2>
        <form class="create" @submit="checkForm" :action=`/api/observations/create` method="post">
            <div v-if="errors.length">
                <b>Please correct the following error(s):</b>
                <ul>
                    <li v-for="error in errors">{{ error }}</li>
                </ul>
            </div>

            <p>
                <h1>Location-info</h1>
                <label for="locationName">Name</label>
                    <input type="text" name="locationName" id="locationName" v-model="locationName">
            </p>

            <p>
                <label for="longitude">Longitude<label>
                    <input type="number" step="0.000001" name="longitude" id="longitude" v-model="longitude" min="0">
            </p>

            <p>
                <label for="latitude">Latitude<label>
                    <input type="number" step="0.000001" name="latitude" id="latitude" v-model="latitude" min="0">
            </p>

            <br>

            <label for="bioms">Bioms (Remove unwanted)</label>
            <br>
            <input type="text" name="bioms" id="bioms" v-model="bioms">


            <br>

            <h3>Planet-info</h3>
            <p>
                <label for="planetName">Name</label>
                <input type="text" name="planetName" id="planetName" v-model="planetName">
            </p>

            <p>
                <label for="radius">Radius</label>
                <input type="number" step="0.2" name="radius" id="radius" v-model="radius" min="0">
            </p>

            <p>
                <label for="mass">Mass</label>
                <input type="number" step="0.1" name="mass" id="mass" v-model="mass" min="0">
            </p>

            <br>
            <br>

            <p></p>

            <h1>Animal-info</h1>
            <p>
            <label for="animalName">Name</label>
            <input type="text" name="animalName" id="animalName" v-model="animalName">
            </p>

            <p>
                <label for="scientificName"> Scientific name</label>
                <input type="text" name="scientificName" id="scientificName" v-model="scientificName">
            </p>

            <p>
                <label for="numberOfLegs">Number of legs<label>
                    <input type="number" step="1" name="numberOfLegs" id="numberOfLegs" v-model="numberOfLegs" min="0">
            </p>


            <h3>Please select Animal type, and fill in all data</h3>


            <select name="selected" id="selected" v-model="selected">

            <option>Choose animal-type</option>
            <option v-for="option in optionData" v-bind:value="option.id">
                {{option.name}}
            </option>
        </select>

            <!--Divs for dynamicly displaying input data based on selected type-->

            <div v-if="selected===1">
                <p>
                    <label for="canFly">Can Fly<label>
                        <input type="checkbox" name="canFly" id="canFly" v-model="canFly">
                 </p>
                <br>
                <p>
                    <label for="weight">Weight in Kg<label>
                        <input type="number" step="0.5" name="weight" id="weight" v-model="weight" min="0">
                </p>

                <p>
                    <label for="topSpeed">Top speed Km/h<label>
                        <input type="number" step="0.5" name="topSpeed" id="topSpeed" v-model="topSpeed" min="0">
                </p>
            </div>

            <div v-if="selected===2">
                <p>
                    <label for="livesAtSea">Lives at sea<label>
                        <input type="checkbox" name="livesAtSea" id="livesAtSea" v-model=" livesAtSea">
                </p>
                <br>
                <p>
                    <label for="length">Length in m<label>
                        <input type="number" step="0.5" name="length" id="length" v-model="length" min="0">
                </p>

            </div>

            <div v-if="selected===3">
                <p>
                    <label for="hasTale">Has tale<label>
                        <input type="checkbox" name="hasTale" id="hasTale" v-model=" hasTale">
                </p>
                <br>

                <p>
                    <label for="habitat">Habitat<label>
                        <input type="text" name="habitat" id="habitat" v-model="habitat">
                </p>

            </div>


            <br>
            <br>

            <h1>Observation-info</h1>

            <p>
                <label for="name">Id<label>
                    <input step="1" type="number" name="id" id="id" v-model="id">
            </p>

            <p>
                <label for="name">Name<label>
                    <input type="text" name="name" id="name" v-model="observationName">
            </p>

            <p>
                <label for="date">Date<label>
                    <input type="date" name="date" id="date" v-model="dateTime">
            </p>


            <p>
                <label for="number">Number of Observations<label>
                    <input type="number" step="1" name="number" id="number" v-model="number">
            </p>

            <p>
                <label for="pictureUrl">Picture URL<label>
                    <input type="url" name="pictureUrl" id="pictureUrl" v-model="pictureUrl">
            </p>

            <p>
                <label for="notes">Notes<label>
                    <input type="text" name="notes" id="notes" v-model="notes">
            </p>

            <br>

            <p>
                <input type="submit" value="Create Observation">
             </p>

        </form>
    </div>

</template>
<script>
    Vue.component("create-observation", {
        template: "#create",
        data: () => ({
            //Location-data
            locationName: null,
            longitude: null,
            latitude: null,

            biomList: "Select",
            bioms:[],

            //Planet-data
            planetName: null,
            radius: null,
            mass: null,


            //Animal-data
            animalName: null,
            scientificName:null,
            numberOfLegs:null,
            type: null,
            //bird
            canFly:false,
            weight: null,
            topSpeed: null,
            //invertebrate
            livesAtSea: null,
            length: null,
            //amphibian
            hasTale: null,
            habitat: null,

            selected: "Choose animal-type",
            optionData:[
                {id:1 ,name:"Bird"},
                {id: 2, name:"Amphibian"},
                {id:3 , name: "Invertebrate"},

            ],

            //observation data//
            id:null,
            observationName: null,
            dateTime: null,
            number: null,
            pictureUrl: null,
            notes: null,

            //Error- list//
            errors: []

        }),

        created(){
            fetch(`/api/observations/biomTypes`)
                .then(res => res.json())
                .then(res => this.bioms= res)
                .catch("Error while fetching biom-types")
        },
        methods:{
            checkForm:function(e) {
                const urlRegex = "/^(?:(?:(?:https?|ftp):)?\\/\\/)(?:\\S+(?::\\S*)?@)?(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\\.(?:[a-z\u00a1-\uffff]{2,})))(?::\\d{2,5})?(?:[/?#]\\S*)?$/i";
                if(this.locationName &&this.bioms && this.planetName && this.animalName && this.scientificName && this.id && this.observationName && this.dateTime && this.number  && this.notes) return true;

                this.errors = [];
                if (!this.locationName) this.errors.push("Location -Name required");
                if (!this.bioms) this.errors.push("Biom/Bioms required");
                if (!this.planetName) this.errors.push("Planet - Name required");
                if (!this.animalName) this.errors.push("Animal - Name required");
                if (!this.scientificName) this.errors.push("Animal -Scientific Name required");
                if (!this.id) this.errors.push("Observation -ID required");
                if (!this.observationName) this.errors.push("Observation -Name required");
                if (!this.dateTime) this.errors.push("Observation -date required");
                if (!this.number) this.errors.push("Observation - number required");
                if (!this.notes) this.errors.push("Observation -Notes required");
                e.preventDefault();
            }
        }

    });
</script>
<style>
    .form-style{
        font-family: 'Open Sans Condensed', arial, sans;
        width: 500px;
        padding: 30px;
        background: white;
        border: 1px solid black;
        margin: 50px auto;
        box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -moz-box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.22);
        -webkit-box-shadow:  0px 0px 15px rgba(0, 0, 0, 0.22);

    }
    .form-style h2{
        background: #4D4D4D;
        text-transform: uppercase;
        font-family: 'Open Sans Condensed', sans-serif;
        color: white;
        font-size: 18px;
        font-weight: 100;
        padding: 20px;
        margin: -30px -30px 30px -30px;
    }
    .form-style input[type="text"],
    .form-style input[type="date"],
    .form-style input[type="datetime"],
    .form-style input[type="email"],
    .form-style input[type="number"],
    .form-style input[type="search"],
    .form-style input[type="time"],
    .form-style input[type="url"],
    .form-style input[type="password"],
    .form-style textarea,
    .form-style select
    {
        box-sizing: border-box;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        outline: none;
        display: block;
        width: 100%;
        padding: 7px;
        border: none;
        color: black;
        border-bottom: 1px solid #ddd;
        background: transparent;
        margin-bottom: 10px;
        font: 16px Arial, Helvetica, sans-serif;
        height: 45px;
    }
    .form-style textarea{
        resize:none;
        overflow: hidden;
    }
    .form-style input[type="button"],
    .form-style input[type="submit"]{
        background: none;
        display: inline-block;
        cursor: pointer;
        font-family: 'Open Sans Condensed', sans-serif;
        font-size: 14px;
        text-decoration: none;
        text-transform: uppercase;
        padding: 10px;
        margin: 10px;
        border: 1px solid black;
        color: black;
        border-radius: 15px;
    }
    .form-style input[type="button"]:hover,
    .form-style input[type="submit"]:hover {
        border: 2px solid black;
    }

    .create {
        color: black;
    }

    h1{
        font-size: 20px;
    }

    h3{
        font-size: 15px;
    }

    ul{
        color: black;
    }
</style>
