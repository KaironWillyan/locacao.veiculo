import { operadorDto } from "~/models/Dto/operdorDto";

export const useOperadorStore = defineStore("operador-store", {
    state: () => ({
        operador: [] as operadorDto[]
    }),
    actions: {
        async getAll(){
            try{
                let data = await $fetch<operadorDto[]>("http://localhost:8080/operador")                
                    this.operador = data as operadorDto[];
                return data;
            }catch(e: any) {
                useToast().error(e.message);    
            }
        },

        async createOperador(data: operadorDto) {
            await $fetch("http://localhost:8080/operador", {
                method: 'POST',
                body: {data}.data,
            })
            .catch((e)=> {
                useToast().error(e.data.message);
            })
            .then(async ()=>{
                await this.getAll();
                useToast().success("Operador cadastrado");
            });
        },

        async updateFuncionario(id: number,data: operadorDto) {
            await $fetch(`http://localhost:8080/operador/${id}`, {
                method: "PUT",
                body: {data}.data,
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Operador atualizado");
            });
        },

        async deleteFuncionario(id: number) {
            await $fetch(`http://localhost:8080/operador/${id}`, {
                method: 'DELETE',
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Operador deletado")
            })
        }
    }
})