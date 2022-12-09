import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Lancamento } from 'src/app/model/lancamento';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { LancamentoService } from 'src/app/service/lancamento.service';

@Component({
  selector: 'app-modal-lancamento',
  templateUrl: './modal-lancamento.component.html',
  styleUrls: ['./modal-lancamento.component.scss']
})
export class ModalLancamentoComponent implements OnInit {
  isVisible: boolean | undefined;
  lancamento: Lancamento;
  formLancamento: FormGroup;
  constructor( private lancamentoService: LancamentoService,
    private formBuilder: FormBuilder,
    private activeModal: NgbActiveModal,
    private toastService: ToastrService) { }

  ngOnInit(): void {
    this.createForm(this.lancamento);
  }

  createForm(lancamento?: Lancamento) {
    this.formLancamento = this.formBuilder.group({
      id: [''],
      clienteId: ['', [Validators.required]],
      produtoId: ['', [Validators.required]],
      valorTotal: ['', [Validators.required]],
      quantidadeVendida: ['', [Validators.required]],
      dataVenda:['',[Validators.required]]
    });

    if (lancamento) {
      this.formLancamento.setValue({
        id: lancamento.id,
        clienteId: lancamento.clienteId,
        produtoId: lancamento.produtoId,
        valorTotal: lancamento.valorTotal,
        quantidadeVendida: lancamento.quantidadeVendida,
        dataVenda:lancamento.dataVenda
      });
    }
  }

  handleOk(): void {
    if (this.lancamento) {
      this.alterarLancamento(this.formLancamento.getRawValue() as Lancamento);
    } else {
      this.criarLancamento(this.formLancamento.getRawValue() as Lancamento);
    }
  }
  handleCancel(): void {
    this.activeModal.close();
  }

  alterarLancamento(lancamento: Lancamento) {
    this.lancamentoService.alterar(lancamento).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-lancamentos').emit();
      this.toastService.success('Lançamento alterado', 'SUCESSO', {
        timeOut: 7000,
      });
    });
  }

  criarLancamento(lancamento: Lancamento) {
    this.lancamentoService.criar(lancamento).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-lancamentos').emit();
      this.toastService.success('Lançamento cadastrado', 'SUCESSO', {
        timeOut: 7000,
      });
    });
  }
}
