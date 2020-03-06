import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../login/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

//  isLoggedIn = false;


   isLoggedIn$: Observable<boolean>;                  // {1}


  constructor(private route: ActivatedRoute,
    private router: Router,
    private authenticationService: AuthenticationService) { }

  ngOnInit() {
 //   this.isLoggedIn = this.authenticationService.isUserLoggedIn();
  //  console.log('menu ->' + this.isLoggedIn);
    this.isLoggedIn$ = this.authenticationService.isLoggedIn; // {2}
  }

  handleLogout() {
    this.authenticationService.logout();
  }

}
