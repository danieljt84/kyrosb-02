import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalLancamentoComponent } from './modal-lancamento/modal-lancamento.component';

@Component({
  selector: 'app-lancamento',
  templateUrl: './lancamento.component.html',
  styleUrls: ['./lancamento.component.scss']
})
export class LancamentoComponent implements OnInit {
  isToShowModal = false;

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  showModal(): void {
    this.modalService.open(ModalLancamentoComponent);
  }

}
