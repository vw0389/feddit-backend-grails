package com.vweinert.feddit

class User {
    String username
    Date createdAt
    String email
    String password
    String about
    Date passwordChangedAt
    Boolean deleted
    Date aboutChangedAt
    static constraints = {
        username size: 8..32, blank:false, unique:true, nullable: false
        email maxSize: 64, email:true, blank:false, unique:true, nullable: false
        password size: 8..32, blank:false, nullable: false

    }
}
