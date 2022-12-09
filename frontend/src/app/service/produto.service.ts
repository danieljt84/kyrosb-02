import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produto } from '../model/produto';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private httpClient:HttpClient) { }

  listar():Observable<Produto[]>{
    return this.httpClient.get<Produto[]>(environment.apiUrl+"/produto/listar");
  }

  criar(produto:Produto):Observable<Response>{
    return this.httpClient.post<Response>(environment.apiUrl+"/produto/criar",produto);
  }

  alterar(produto:Produto):Observable<Response>{
    return this.httpClient.put<Response>(environment.apiUrl+"/produto/alterar",produto);
  }

  excluir(id:number):Observable<Response>{
    let headers = new HttpHeaders()
    .append("Access-Control-Allow-Origin","http://192.186.1.15")
    return this.httpClient.delete<Response>(environment.apiUrl+"/produto/"+id,{headers});
  }

}
