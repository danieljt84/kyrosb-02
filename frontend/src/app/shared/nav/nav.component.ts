import { Component, ElementRef, OnInit, Renderer2, ViewChild } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  username="";
  @ViewChild("sidebar") sidebar: ElementRef;
  @ViewChild("content") content: ElementRef;
  constructor(private elRef: ElementRef, private renderer: Renderer2) {}

  ngOnInit(): void {
  }

  openSideBar(){
    const active = this.sidebar.nativeElement.classList.contains('open');
    this.renderer[active ? 'removeClass' : 'addClass'](this.sidebar.nativeElement, 'open');
    this.renderer[active ? 'removeClass' : 'addClass'](this.content.nativeElement, 'open');
  }
}
