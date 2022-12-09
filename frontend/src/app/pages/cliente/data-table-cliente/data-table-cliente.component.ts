import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/model/cliente';
import { ClienteService } from 'src/app/service/cliente.service';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { ModalClienteComponent } from '../modal-cliente/modal-cliente.component';

@Component({
  selector: 'app-data-table-cliente',
  templateUrl: './data-table-cliente.component.html',
  styleUrls: ['./data-table-cliente.component.scss'],
})
export class DataTableClienteComponent implements OnInit {
  searchIdValue = '';
  visible = false;
  clientes: Cliente[];
  listToDisplay: Cliente[];

  constructor(
    private clienteService: ClienteService,
    private modalService: NgbModal,
    private toastService: ToastrService
  ) {}

  ngOnInit(): void {
    EventEmitterService.get('carregar-clientes').subscribe(()=> this.carregarClientes())
    this.carregarClientes();
  }

  showModal(cliente: Cliente) {
    const ref = this.modalService.open(ModalClienteComponent);
    ref.componentInstance.cliente = cliente;
  }

  carregarClientes() {
    this.clienteService.listar().subscribe((data) => {
      this.clientes = data;
      this.listToDisplay = [...this.clientes];
    });
  }

  excluirProduto(id: number) {
    if (confirm('Deseja realmente excluir?') == true) {
      this.clienteService.excluir(id).subscribe(() => {
        this.carregarClientes();
        this.toastService.success('Cliente excluido', 'SUCESSO');
      });
    }
  }

  resetId(): void {
    this.visible = false;
    this.listToDisplay = [...this.clientes];
  }

  searchId(): void {
    this.visible = false;
    this.listToDisplay = this.clientes.filter(
      (cliente) => cliente.id.toString() == this.searchIdValue
    );
  }
}
