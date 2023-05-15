<script setup lang="ts">
import { SetorAddSetor } from '~/.nuxt/components';
import { setorDto } from '~/models/Dto/setorDto';

const setorStore = await useSetorStore()

let data = ref({
  nome: ''
} as setorDto)


async function addSetor(){
  await setorStore
  .createSetor({
    nome: data.value.nome
  })
}

</script>

<template>
    <form >
      <div class="mb-3">
        <label class="form-label">Nome do Setor</label>
        <input @keyup.enter="addSetor" v-model="data.nome"  type="text" class="form-control" aria-describedby="emailHelp">
      </div>
      <button type="button" @click="addSetor" @keyup.enter="addSetor()" class="btn btn-primary">Cadastrar</button>
    </form>
</template> 