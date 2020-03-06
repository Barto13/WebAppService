import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from './login/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  // title = 'Sklep internetowy v0.3';

  // isLoggedIn = false;


   isLoggedIn$: Observable<boolean>;                  // {1}

  constructor(private authService: AuthenticationService) { }

  ngOnInit() {
    this.isLoggedIn$ = this.authService.isLoggedIn; // {2}
     //this.isLoggedIn = this.authService.isUserLoggedIn();
  }

  onLogout(){
    this.authService.logout();                      // {3}
  }
}