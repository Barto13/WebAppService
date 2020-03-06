import { Component, OnInit } from '@angular/core';

import { Observable } from "rxjs";
import { ProductService } from "../product.service";
import { Product } from "../product";
import { Router, ActivatedRoute  } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  
  // id: number;
  // product: Product;
  products: Observable<Product[]>;

  constructor(private productService: ProductService, private route: ActivatedRoute,
    private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.products = this.productService.getProductsList();
  }

  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          this.reloadData();
        });
  }

  productDetails(id: number){
    this.router.navigate(['P-details', id]);
  }

  updateProduct(id: number){
    this.router.navigate(['P-update', id]);
  }

//   ProductToCart(id: number){

//     this.productService.ProductToCart(id)
//     .subscribe(
//       data => {

//         this.reloadData();
//       });
// }
  //   this.product = new Product();

  //   this.id = this.route.snapshot.params['id'];
    
  //   this.productService.getProduct(this.id)
  //     .subscribe(data => {
  //       this.product = data;

        // this.productService.createProduct(this.product)
        // .subscribe(data => {
        //   this.gotoList();

      // });
    // this.product = new Product();

    // this.id = this.route.snapshot.params['id'];
    

    // this.productService.ProductToCart(id)
    // .subscribe(
    //   data => {
    //     this.reloadData();
    //   });
  

  payu(){
    this.router.navigate(['payment']);
  }

  
}