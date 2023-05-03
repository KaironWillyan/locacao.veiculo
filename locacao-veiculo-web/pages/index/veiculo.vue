<script lang="ts">
import { Axios } from 'axios';
import AddVeiculo from '~/components/veiculo/AddVeiculo.vue';

export default defineComponent({
    setup() {
        const veiculos = ref([]);
        const axios = useNuxtApp().$axios;
        const fetchVeiculo = async () => await (axios as Axios)
            .get("/veiculo")
            .then((res) => veiculos.value = res.data);
        onMounted(fetchVeiculo);
        return { veiculos };
    },
    components: { AddVeiculo }
});
</script>

<template>
    <div class="main-vei d-flex">
        <div class="cad-vei">
            <AddVeiculo />
        </div>

        <div class="exi-vei" >
            <h1>Veiculo</h1>
            <p v-for="veiculo in veiculos">{{veiculo}}</p>
        </div>
        
    </div>
</template>

<style scoped>
 .main-vei{
   display: flex;
   flex-wrap: wrap;
}

.cad-vei{
    flex: 30%;
    padding: 20px;
}

.exi-vei{
    flex:60%;
    padding: 20px;
}
</style>