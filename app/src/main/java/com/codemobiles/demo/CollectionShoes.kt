package com.codemobiles.demo

class CollectionShoes {
    var title: String?=null
    var PRICE: String?=null
    var ImageUrl: String?=null


    constructor(){

    }

    constructor(PRICE: String?, ImageUrl: String?, title: String?) {
        this.PRICE = PRICE
        this.ImageUrl = ImageUrl
        this.title = title
    }



}