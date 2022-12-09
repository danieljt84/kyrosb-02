import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Produto } from 'src/app/model/produto';
import { Status } from 'src/app/model/status';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { ProdutoService } from 'src/app/service/produto.service';
import { ModalProdutoComponent } from '../modal-produto/modal-produto.component';

@Component({
  selector: 'app-data-table-produto',
  templateUrl: './data-table-produto.component.html',
  styleUrls: ['./data-table-produto.component.scss'],
})
export class DataTableProdutoComponent implements OnInit {
  searchIdValue='';
  visible = false;
  produtos: Produto[];
  listToDisplay: Produto[];
  constructor(
    private produtoService: ProdutoService,
    private modalService: NgbModal,
    private toastService: ToastrService
  ) {}

  ngOnInit(): void {
    EventEmitterService.get('carregar-produtos').subscribe(()=> this.carregarProdutos())
    this.carregarProdutos();
  }

  showModal(produto: Produto) {
    const ref = this.modalService.open(ModalProdutoComponent);
    ref.componentInstance.produto = produto;
  }

  carregarProdutos() {
    this.produtoService.listar().subscribe((data) => {
      this.produtos = data;
      this.listToDisplay = [...this.produtos];
    });
  }

  excluirProduto(id: number) {
    if (confirm('Deseja realmente excluir?') == true) {
      this.produtoService.excluir(id).subscribe(() => {
        this.carregarProdutos();
        this.toastService.success("Produto excluido","SUCESSO")
      });
    }
  }

  resetId(): void {
    this.visible = false;
    this.listToDisplay = [...this.produtos];
  }

  searchId(): void {
    this.visible = false;
    this.listToDisplay = this.produtos.filter(
      (produto) => produto.id.toString() == this.searchIdValue
    );
  }

}
