<template id="observations-overview">
    <div>
        <center> <h2>Map of life-Observations</h2></center>
    <center><p><a class="button" :href="`observations/create`">Create observation</a></p></center>
        <ul class="observations-overview-list">
            <li v-for="observation in observations">
                <a :href="`/observations/${observation.name.trim()}`" class="link-to-observation-details">
                    <div class="single-observation-container" >
                        <h1>{{observation.id}} - {{observation.name}}</h1>
                        <h1>{{observation.animal.name}}</h1>
                        <img v-if="observation.pictureUrl" class="cover-image-frontpage" v-bind:src="observation.pictureUrl">
                    </div>
                </a>
            </li>
        </ul>
    </div>
</template>
<script>
    Vue.component("observations-overview", {
        template: "#observations-overview",
        data: () => ({
            observations: [],
        }),
        created() {
            fetch("/api/observations")
                .then(res => res.json())
                .then(res => {
                    this.observations = res;
                })
                .catch(() => alert("Error while fetching observations"));
        }
    });
</script>
<style>
    li{
        list-style-type: none;
    }

    .observations-overview-list{
        margin-top: 50px;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }

    .observation-overview-list li{
        padding: 10px;

    }

    .link-to-observation-details{
        width: 400px;
        height:100px;
        text-decoration: none;
        color: black;
    }

    div.single-observation-container{
        overflow: hidden;
        width: 300px;
        background-color: white;
        opacity: 0.96;
        text-align: center;
        border: 1px solid black ;
        border-radius: 15px;
        margin: 20px;
    }

    div.single-observation-container:hover{
        opacity: 1.0;
        overflow: hidden;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.cover-image-frontpage {
        width: 125px;
        height: 125px;
        padding-bottom: 20px;
        max-height: 280px;
    }

    .button {
        padding: 15px;
        margin: 10px;
        border: 2px solid black;
        color: black;
        border-radius: 15px;
    }

    .button a{
        color: black;
        text-decoration: none;
        font-weight: bold;
    }

    .button:hover{
        border: 2px solid black;
    }
    h2{
        font-size: 50px;
        color: black;
        font-family: "DejaVu Sans Mono";
    }

</style>