import { Status } from "./status";

export interface Produto{
  id:number;
  nome:string;
  descricao:string;
  valorUnidade:number;
  status: Status;
}
