<template id="planet-detail-template">

    <div id="content-wrapper">

<div v-if="planet" class="detail-planet-container">
    {{console.log(this.planet)}}
    <h1>{{planet.name}}</h1>
    <img class="detail" v-bind:src="planet.pictureUrl" />
    <p>The mass of {{planet.name}} is {{planet.mass}} kg, it has a radius of {{planet.radius}} km,
        the eccentricity or the deviation of orbit is from a circularity is {{planet.eccentricity}}.</p>
    <p>It spins around the star {{planet.centralCelestialBody.name}} with an orbiting period of {{planet.orbitalPeriod}} days.</p>
    <p>Below you can see {{moons.length}} of {{planet.name}}`s moons</p>
</div>

        <ul class="moon-overview-list">
            <li v-for="moon in moons">
                <a v-if="moon" class="link-to-moon-details" :href="`/planet-systems/${planetSystem.name}/planets/${planet.name}/moons/${moon.name}`">
                <div class="single-moon-container" >
                        <h1>{{moon.name}}</h1>
                        <img v-if="moon.pictureUrl" class="list-image" v-bind:src="moon.pictureUrl">
                        <img v-else class="list-image" src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Icon-round-Question_mark.svg/480px-Icon-round-Question_mark.svg.png">
                    </div>
               </a>
            </li>
        </ul>
    </div>

</template>

<script>
    Vue.component("planet-detail", {
        template: "#planet-detail-template",

        data: () => ({
            planetSystem:null,
            planet: null,
            moons: []
        }),
        created() {
            const planetSystemId = this.$javalin.pathParams["planet-system-id"];
            console.log("Planet system id: " + planetSystemId);
            const planetId = this.$javalin.pathParams["planet-id"];
            fetch(`/api/planet-systems/${planetSystemId}/planets/${planetId}`)
                .then(res => res.json())
                .then(res =>{
                        this.planet = res;
                        this.moons= this.planet.moons;

                })
                .catch(() => alert("Error while fetching planet"));

                fetch(`/api/planet-systems/${planetSystemId}`)
                    .then(res => res.json())
                    .then( res => this.planetSystem = res)
                    .catch(() => alert("Error while fetching planetsystem"))
        }


    });
</script>
<style>
    ul{
       color:white;
    }
    div.detail-planet-container > p {
        max-width: 30em;
    }
    div.detail-planet-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        color: white;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

   img.detail{
        height: 120px;
        width: 120px;
        padding-bottom: 20px;
    }

    .moon-overview-list{
        color:black;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;

    }

    div.single-moon-container{
        overflow: hidden;
        color: white;
        background-color: rgba(0, 0, 0, 0.98);
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
    }

    .link-to-moon-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color:black;
    }

</style>