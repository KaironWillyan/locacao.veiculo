<script lang="ts">
import AddSetor from '~/components/setor/addSetor.vue';
import { setorDto } from '~/models/Dto/setorDto';
import { defineEmits } from 'vue'
import { Axios } from 'axios';
import vuex from '~/plugins/vuex';

// const emit = defineEmits<{
//   (e: 'atualizarSetores', setores: Array<setorDto>): any
// }>()

const store = vuex
console.log(store);

export default defineComponent({
    setup() {
        const setores = ref([] as Array<setorDto>);
        const axios = useNuxtApp().$axios;
        const fetchSetores = async () => await (axios as Axios)
            .get("/setor")
            .then((response: any) => (setores.value = response.data));
        onMounted(fetchSetores);

        // function atualizarSetores(setoresFromEvent: Array<setorDto>) {
        //   setores.value = setoresFromEvent
        // }

        return { setores };
    },
    components: { AddSetor },
    
})

</script>

<template>
  <div class="d-flex grid-set">
    <div class="main-setor ">
      <h1>Registrar setor</h1>
         <div class="registro-setor ">
            <AddSetor @atualizarSetores="atualizarSetores"/>
         </div>
    </div>
    
      <div class="setores-cadastrados">
          <p>Setores</p>
          <p v-for="setor in setores"> {{ setor.nome }}</p>
      </div>
  </div>
</template>

<style scoped>
.main-setor{
    padding: 3%;
    text-align: center;  
}
.registro-setor {
    width: 60%;
    background-color: aqua;
}

.grid-set {
  display: grid;
  grid-gap: 6rem;
}

.setores-cadastrados{
  margin-left: 40%;
  padding: 5%;
  background-color: violet;
}
</style>