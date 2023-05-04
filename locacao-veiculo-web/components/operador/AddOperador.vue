<script setup lang="ts">
import { Axios } from 'axios';
import { operadorDto } from '~/models/Dto/operdorDto';

const axios = useNuxtApp().$axios;

let data = ref ({
    nome: "",
    email: "",
    password: "",
    cpf: "",
    tipo: "",
} as operadorDto);

async function addOperador() {
    await (axios as Axios)
      .post('/operador', {
        nome: data.value.nome,
        email: data.value.email,
        password: data.value.password,
        cpf: data.value.cpf,
        tipo: data.value.tipo,
    })
    .then((res: any) => data.value = res.data)
}
</script>



<template>

<form>
  <div class="mb-3">
    <label class="form-label">Nome</label>
    <input type="text" @keyup.enter="addOperador" v-model="data.nome" class="form-control" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label class="form-label">email</label>
    <input @keyup.enter="addOperador" v-model="data.email" type="text" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">password</label>
    <input @keyup.enter="addOperador" v-model="data.password" type="password" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">cpf</label>
    <input @keyup.enter="addOperador" v-model="data.cpf" type="text" class="form-control">
  </div>
  <div class="mb-3">
    <label class="form-label">Tipo</label>
    <input @keyup.enter="addOperador" v-model="data.tipo" type="text" class="form-control">
  </div>
  <button @keyup.enter="addOperador" @click="addOperador" type="button" class="btn btn-primary">Cadastrar</button>
</form>
    
</template>