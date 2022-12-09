import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Cliente } from 'src/app/model/cliente';
import { ClienteService } from 'src/app/service/cliente.service';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-modal-cliente',
  templateUrl: './modal-cliente.component.html',
  styleUrls: ['./modal-cliente.component.scss'],
})
export class ModalClienteComponent implements OnInit {
  isVisible: boolean | undefined;
  cliente: Cliente;
  formCliente: FormGroup;
  tipoPessoa = '';
  constructor(
    private clienteService: ClienteService,
    private formBuilder: FormBuilder,
    private activeModal: NgbActiveModal,
    private toastService: ToastrService
  ) {}

  ngOnInit(): void {
    this.createForm(this.cliente);
    this.formCliente.get('tipoPessoa')?.valueChanges.subscribe((x) => {
      this.tipoPessoa = this.formCliente.get('tipoPessoa')?.value;
    });
  }

  createForm(cliente?: Cliente) {
    this.formCliente = this.formBuilder.group({
      id: [''],
      nome: ['', [Validators.required]],
      endereco: ['', [Validators.required]],
      dataNascimento: ['', [Validators.required]],
      tipoPessoa: [''],
      cpf: [],
      cnpj: [],
    });

    if (cliente) {
      this.formCliente.patchValue({
        id: cliente.id,
        nome: cliente.nome,
        endereco: cliente.endereco,
        dataNascimento: formatDate(cliente.dataNascimento, 'yyyy-MM-dd', 'en')
      });
      if (cliente.cpf) {
        this.tipoPessoa = 'FISICA';
        this.formCliente.patchValue({
          cpf: cliente.cpf,
          tipoPessoa:"FISICA"
        });
      }
      if (cliente.cnpj) {
        this.tipoPessoa = 'JURIDICA';
        this.formCliente.patchValue({
          cnpj: cliente.cnpj,
          tipoPessoa:"JURIDICA"
        });
      }
    }
  }

  handleOk(): void {
    if (this.cliente) {
      this.alterarCliente(this.formCliente.getRawValue() as Cliente);
    } else {
      this.criarCliente(this.formCliente.getRawValue() as Cliente);
    }
  }

  handleCancel(): void {
    this.activeModal.close();
  }

  alterarCliente(cliente: Cliente) {
    this.clienteService.alterar(cliente).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-clientes').emit();
      this.toastService.success('Cliente alterado', 'SUCESSO', {
        timeOut: 7000,
      });
    });
  }

  criarCliente(cliente: Cliente) {
    this.clienteService.criar(cliente).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-clientes').emit();
      this.toastService.success('Cliente cadastrado', 'SUCESSO', {
        timeOut: 7000,
      });
    });
  }
}
