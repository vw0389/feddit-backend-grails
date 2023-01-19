package com.vweinert.feddit

class Post {
    String title
    String content
    Date dateModifiedAt
    User user
    Date dateCreated
    static hasMany = [comment:Comment]
    static constraints = {
    }
    static mapping = {
        autoTimestamp true
        deleted defaultValue: "0"
    }
}
