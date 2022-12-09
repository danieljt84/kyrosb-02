import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EventEmitterService } from 'src/app/service/event-emitter.service';
import { ModalProdutoComponent } from './modal-produto/modal-produto.component';

@Component({
  selector: 'app-produto',
  templateUrl: './produto.component.html',
  styleUrls: ['./produto.component.scss']
})
export class ProdutoComponent implements OnInit {
  isToShowModal = false;

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  showModal(): void {
    this.modalService.open(ModalProdutoComponent);
  }

}
