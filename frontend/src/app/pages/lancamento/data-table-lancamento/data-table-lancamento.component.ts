import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Lancamento } from 'src/app/model/lancamento';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { LancamentoService } from 'src/app/service/lancamento.service';
import { ModalLancamentoComponent } from '../modal-lancamento/modal-lancamento.component';

@Component({
  selector: 'app-data-table-lancamento',
  templateUrl: './data-table-lancamento.component.html',
  styleUrls: ['./data-table-lancamento.component.scss']
})
export class DataTableLancamentoComponent implements OnInit {

  searchIdValue='';
  visible = false;
  lancamentos: Lancamento[];
  listToDisplay: Lancamento[];
  constructor(private lancamentoService: LancamentoService,
    private modalService: NgbModal,
    private toastService: ToastrService) { }

  ngOnInit(): void {
    EventEmitterService.get('carregar-lancamentos').subscribe(()=> this.carregarLancamentos())
    this.carregarLancamentos();
  }

  showModal(lancamento: Lancamento) {
    const ref = this.modalService.open(ModalLancamentoComponent);
    ref.componentInstance.lancamento = lancamento;
  }

  carregarLancamentos() {
    this.lancamentoService.listar().subscribe((data) => {
      this.lancamentos = data;
      this.listToDisplay = [...this.lancamentos];
    });
  }

  excluirProduto(id: number) {
    if (confirm('Deseja realmente excluir?') == true) {
      this.lancamentoService.excluir(id).subscribe(() => {
        this.carregarLancamentos();
        this.toastService.success("Lançamento excluido","SUCESSO")
      });
    }
  }

  resetId(): void {
    this.visible = false;
    this.listToDisplay = [...this.lancamentos];
  }

  searchId(): void {
    this.visible = false;
    this.listToDisplay = this.lancamentos.filter(
      (lancamento) => lancamento.id.toString() == this.searchIdValue
    );
  }


}
