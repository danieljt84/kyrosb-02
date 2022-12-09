import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LancamentoComponent } from './lancamento.component';
import { ModalLancamentoComponent } from './modal-lancamento/modal-lancamento.component';
import { DataTableLancamentoComponent } from './data-table-lancamento/data-table-lancamento.component';
import { NzTableModule } from 'ng-zorro-antd/table';
import { NzDropDownModule } from 'ng-zorro-antd/dropdown';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NzIconModule } from 'ng-zorro-antd/icon';
import { NzModalModule } from 'ng-zorro-antd/modal';
import { NzDividerModule } from 'ng-zorro-antd/divider';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  { path: '', component: LancamentoComponent }
];

@NgModule({
  declarations: [LancamentoComponent, ModalLancamentoComponent, DataTableLancamentoComponent],
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
  ]
})
export class LancamentoModule { }
