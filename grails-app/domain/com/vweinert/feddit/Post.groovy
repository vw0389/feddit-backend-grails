package com.vweinert.feddit

class Post {
    String title
    String content
    Date dateModifiedAt
    static belongsTo = [user:User]
    Date dateCreated
    static hasMany = [comment:Comment]
    Boolean deleted
    static constraints = {
        title nullable: false, blank: false
        content nullable: false, blank: false
        dateModifiedAt nullable: true
    }
    static mapping = {
        deleted defaultValue: "0"
        content sqlType: "longtext"
    }
}
