package com.vweinert.feddit

class Comment {
    String content
    Date dateModifiedAt

    Boolean deleted
    static belongsTo = [user:User,post:Post]
    Date dateCreated
    static constraints = {
        content nullable: false, blank: false
        dateModifiedAt nullable: true
    }
    static mapping = {
        deleted defaultValue: "0"
        content sqlType: "longtext"
    }
}
