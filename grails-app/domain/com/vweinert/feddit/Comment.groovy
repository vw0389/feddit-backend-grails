package com.vweinert.feddit

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Comment {
    String content
    Date dateModifiedAt

    Boolean deleted = false
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
