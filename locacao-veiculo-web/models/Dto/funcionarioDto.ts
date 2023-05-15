import { setorDto } from "./setorDto";

export interface funcionarioDto {
    id          ?:number;
    setor       :setorDto;
    nome        :string;
    cpf         :string;
    tipoCnh     :string;
    telefone    :string;
}