import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalClienteComponent } from './modal-cliente/modal-cliente.component';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent implements OnInit {
  isToShowModal = false;

  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {
  }

  showModal(): void {
    this.modalService.open(ModalClienteComponent);
  }

}
