import { setorDto } from "./setorDto";

export interface funcinarioDto {
    id          :number;
    setor       :setorDto;
    nome        :string;
    cpf         :string;
    tipoCnh     :string;
    telefone    :string;
}