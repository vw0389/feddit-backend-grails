package com.vweinert.feddit

class User {
    String username
    String email
    String password
    String about
    Date datePasswordChangedAt
    Boolean deleted
    Date dateAboutChangedAt
    Date dateCreated
    static constraints = {
        username size: 8..32, blank:false, unique:true, nullable: false
        email maxSize: 64, email:true, blank:false, unique:true, nullable: false
        password size: 8..32, blank:false, nullable: false
        aboutChangedAt nullable: true
        passwordChangedAt nullable: true
    }
    static mapping = {

        deleted defaultValue: "0"
        about sqlType: "longtext"
    }
}
