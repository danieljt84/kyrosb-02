import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoComponent } from './produto.component';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzCardModule } from 'ng-zorro-antd/card';
import { DataTableProdutoComponent } from './data-table-produto/data-table-produto.component';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { ModalProdutoComponent } from './modal-produto/modal-produto.component';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NgbActiveModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';

const routes: Routes = [
  { path: '', component: ProdutoComponent }
];

@NgModule({
  declarations: [
    ProdutoComponent,
    DataTableProdutoComponent,
    ModalProdutoComponent
    ],
  imports: [
    CommonModule,
    NzTableModule,
    NzDropDownModule,
    FormsModule,
    NzIconModule,
    NzModalModule,
    NzDividerModule,
    ReactiveFormsModule,
    NgbModule,
    RouterModule.forChild(routes)
  ],
  providers:[NgbActiveModal]
})
export class ProdutoModule { }
