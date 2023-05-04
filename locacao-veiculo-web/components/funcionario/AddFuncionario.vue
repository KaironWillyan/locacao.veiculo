<script setup lang="ts">
import { Axios } from 'axios';
import { formatWithOptions } from 'util';
import { SetorAddSetor } from '~/.nuxt/components';
import { funcinarioDto } from '~/models/Dto/funcionarioDto';
import { setorDto } from '~/models/Dto/setorDto';
import Setor from '~/pages/index/setor.vue';


const axios = useNuxtApp().$axios;

let data = ref ({
     nome: '',
     cpf: '',
     telefone: '',
     tipoCnh: '',
     setor: {},
} as funcinarioDto);

async function addOperador() {
    await (axios as Axios)
      .post('/operador', {
        nome: data.value.nome,
        cpf: data.value.cpf,
        telefone: data.value.telefone,
        tipoCnh: data.value.tipoCnh,
        setor: data.value.setor
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
        <label class="form-label">cpf</label>
        <input @keyup.enter="addOperador" v-model="data.cpf" type="text" class="form-control">
      </div>
      <div class="mb-3">
        <label class="form-label">telefone</label>
        <input @keyup.enter="addOperador" v-model="data.telefone" type="text" class="form-control">
      </div>
      <div class="mb-3">
        <label class="form-label">tipo cnh</label>
        <input @keyup.enter="addOperador" v-model="data.tipoCnh" type="password" class="form-control">
      </div>
      <div class="mb-3">
        <select class="form-select form-select-sm" aria-label=".form-select-sm example">
            <option selected>Selecione o setor</option>
            <option v-for="setor in setores">{{ setor.nome }}</option>
        </select>
      </div>
      <button @keyup.enter="addOperador" @click="addOperador" type="button" class="btn btn-primary">Cadastrar</button>
    </form>
        
    </template>