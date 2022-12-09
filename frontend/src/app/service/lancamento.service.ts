import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Lancamento } from '../model/lancamento';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LancamentoService {

  constructor(private httpClient:HttpClient) { }

  listar():Observable<Lancamento[]>{
    return this.httpClient.get<Lancamento[]>(environment.apiUrl+"/lancamento/listar");
  }

  criar(lancamento:Lancamento):Observable<Response>{
    return this.httpClient.post<Response>(environment.apiUrl+"/lancamento/criar",lancamento);
  }

  alterar(lancamento:Lancamento):Observable<Response>{
    return this.httpClient.put<Response>(environment.apiUrl+"/lancamento/alterar",lancamento);
  }

  excluir(id:number):Observable<Response>{
    return this.httpClient.delete<Response>(environment.apiUrl+"/lancamento/"+id);
  }
}
