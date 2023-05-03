<script setup lang="ts">
import { Axios } from 'axios';
import { emit } from 'process';
import { setorDto } from '~/models/Dto/setorDto';

const axios = useNuxtApp().$axios;
// const axios = context.$axios as Axios;

let data = ref({
  nome: "",
} as setorDto)
async function addSetor(){
  await (axios as Axios)
  .post('/setor', {
    nome: data.value.nome ? data.value.nome : "" 
  })
  .then((res: any) => {
    data.value.nome = ""
    console.log(res)
  })

  // let setores = axios.get('/setor').then(res => res.data)

}
</script>

<template>
    <form >
      <div class="mb-3">
        <label class="form-label">Nome do Setor</label>
        <input @keyup.enter="addSetor" v-model="data.nome"  type="text" class="form-control" aria-describedby="emailHelp">
      </div>
      <button type="button" @click="addSetor" @keyup.enter="addSetor" class="btn btn-primary">Cadastrar</button>
    </form>
</template> 