import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { UserService } from "../user.service";
import { User } from "../user";
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: Observable<User[]>;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.users = this.userService.getUsersList();
  }

  deleteUser(id: number) {
    this.userService.deleteUser(id)
      .subscribe(
        data => {
          this.reloadData();
        });
  }

  userDetails(id: number){
    this.router.navigate(['U-details', id]);
  }

  updateUser(id: number){
    this.router.navigate(['U-update', id]);
  }
}