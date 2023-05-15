import { setorDto } from "~/models/Dto/setorDto";

export const useSetorStore = defineStore("setor-store", {
    state: () => ({
        setores: [] as setorDto[]
    }),
    actions: {
        async getAll() {
            try{
                const data = await $fetch<setorDto[]>("http://localhost:8080/setor");
                    this.setores = data as setorDto[];
                return data ;
            }catch(e: any){
                useToast().error(e.message);
            }
        },

        async createSetor(data: setorDto) {
            await $fetch("http://localhost:8080/setor", {
                method: 'POST',
                body: {data}.data,
            })
            .catch((e)=> {
                useToast().error(e.data.message);
            })
            .then(async ()=>{
                await this.getAll();
                useToast().success("Setor cadastrado");
            });
        },

        async updateSetor(data: setorDto) {
            await $fetch(`http://localhost:8080/setor/${data.id}`, {
                method: "PUT",
                body: {data},
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Setor atualizado");
            });
        },

        async deleteSetor(id: number) {
            await $fetch(`http://localhost:8080/setor/${id}`, {
                method: 'DELETE',
            })
            .catch((e)=>{
                useToast().error(e.data.message);
            })
            .then(async()=>{
                await this.getAll();
                useToast().success("Setor deletado")
            })
        }
    }
})