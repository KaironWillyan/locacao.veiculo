<script lang="ts" >
import { Axios } from 'axios';
import AddOperador from '~/components/operador/AddOperador.vue';
import { operadorDto } from '~/models/Dto/operdorDto';


export default defineComponent({
    setup() {
        const operadores = ref([] as Array<operadorDto>);
        const axios = useNuxtApp().$axios;
        const fetchOperador = async () => await (axios as Axios)
            .get("/operador")
            .then((res) => (operadores.value = res.data));
        onMounted(fetchOperador);
        return { operadores };
    },
    components: { AddOperador }
});

</script>

<template>
    <div class="main-ope">
        <div class="cad-ope">
            <h1>Registrar Operador</h1>
            <AddOperador />
        </div>
    
        <div class="exi-op">
            <p>operadores</p>
            <p v-for="operador in operadores">{{ operador }}</p>
    
        </div>
    </div> 
</template>

<style scoped>
 .main-ope{
   display: flex;
   flex-wrap: wrap;
   margin: 10px;
}

.cad-ope{
    flex: 30%;
    padding: 20px;
}

.exi-ope{
    flex:60%;
    padding: 20px;
}
</style>