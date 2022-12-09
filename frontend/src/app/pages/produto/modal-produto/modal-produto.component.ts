import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { ToastrService } from 'ngx-toastr';
import { Produto } from 'src/app/model/produto';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { ProdutoService } from 'src/app/service/produto.service';

@Component({
  selector: 'app-modal-produto',
  templateUrl: './modal-produto.component.html',
  styleUrls: ['./modal-produto.component.scss'],
})
export class ModalProdutoComponent implements OnInit {
  isVisible: boolean | undefined;
  produto: Produto;
  formProduto: FormGroup;

  constructor(
    private produtoService: ProdutoService,
    private formBuilder: FormBuilder,
    private activeModal: NgbActiveModal,
    private toastService: ToastrService
  ) {}

  ngOnInit(): void {
    this.createForm(this.produto);
  }

  createForm(produto?: Produto) {
    this.formProduto = this.formBuilder.group({
      id: [''],
      nome: ['', [Validators.required]],
      descricao: ['', [Validators.required]],
      valorUnidade: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
      status: ['', [Validators.required]],
    });

    if (produto) {
      this.formProduto.setValue({
        id: produto.id,
        nome: produto.nome,
        descricao: produto.descricao,
        valorUnidade: produto.valorUnidade,
        status: produto.status.toString(),
      });
    }
  }

  handleOk(): void {
    if (this.produto) {
      this.alterarProduto(this.formProduto.getRawValue() as Produto);
    } else {
      this.criarProduto(this.formProduto.getRawValue() as Produto);
    }
  }

  handleCancel(): void {
    this.activeModal.close();
  }

  alterarProduto(produto: Produto) {
    this.produtoService.alterar(produto).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-produtos').emit();
      this.toastService.success("Produto alterado","SUCESSO",{
        timeOut:7000
      })
    });
  }

  criarProduto(produto: Produto) {
    this.produtoService.criar(produto).subscribe(() => {
      this.handleCancel();
      EventEmitterService.get('carregar-produtos').emit();
      this.toastService.success("Produto cadastrado","SUCESSO",{
        timeOut:7000
      })
    });
  }
}
