import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClienteComponent } from './cliente.component';
import { ModalClienteComponent } from './modal-cliente/modal-cliente.component';
import { DataTableClienteComponent } from './data-table-cliente/data-table-cliente.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NzIconModule } from 'ng-zorro-antd/icon';


const routes: Routes = [
  { path: '', component: ClienteComponent }
];
@NgModule({
  declarations: [
    ClienteComponent,
    ModalClienteComponent,
    DataTableClienteComponent
  ],
  imports: [
    CommonModule,
    NzTableModule,
    NzDropDownModule,
    FormsModule,
    NzIconModule,
    NzDividerModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule.forChild(routes)
  ]
})
export class ClienteModule { }
