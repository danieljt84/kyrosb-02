import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import {Cliente} from '../model/cliente'
@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private httpClient:HttpClient) { }

  listar():Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(environment.apiUrl+"/cliente/listar");
  }

  criar(cliente:Cliente):Observable<Response>{
    let headers = new HttpHeaders().append('Content-Type','application/json')
    return this.httpClient.post<Response>(environment.apiUrl+"/cliente/criar",cliente,{headers});
  }

  alterar(cliente:Cliente):Observable<Response>{
    return this.httpClient.put<Response>(environment.apiUrl+"/cliente/alterar",cliente);
  }

  excluir(id:number):Observable<Response>{
    return this.httpClient.delete<Response>(environment.apiUrl+"/cliente/"+id);
  }

}
