export interface Cliente{
    id:number;
    nome:string;
    dataNascimento:Date;
    endereco:string,
    cnpj?:number,
    cpf?:number
}
