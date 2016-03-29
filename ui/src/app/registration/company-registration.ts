import {Component} from 'angular2/core';
import {ROUTER_DIRECTIVES, RouteParams, RouteConfig} from 'angular2/router'


@Component({
  // The selector is what angular internally uses
  // for `document.querySelectorAll(selector)` in our index.html
  // where, in this case, selector is the string 'home'
  selector: 'company-registration',  // <home></home>
  // We need to tell Angular's Dependency Injection which providers are in our app.
  //providers: ,
  // We need to tell Angular's compiler which directives are in our template.
  // Doing so will allow Angular to attach our behavior to an element
  // directives: ,
  // We need to tell Angular's compiler which custom pipes are in our template.
  pipes: [],
  // Our list of styles in our component. We may add more to compose many styles together
  styles: [require('./registration.css')],
  // Every Angular template is first compiled by the browser before Angular runs it's compiler
  template: require('./company-registration.html'),
  directives: [ROUTER_DIRECTIVES]
})
export class CompanyRegistration {
  
  constructor() {
    console.log("THis is the company registration component");
  }

  ngOnInit() {
    console.log('hello `Company Registration` component');
    // this.title.getData().subscribe(data => this.data = data);
  }

}
