package com.vweinert.feddit

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='content')
@ToString(includes='content', includeNames=true, includePackage=false)
class Comment implements Serializable{

    private static final long serialVersionUID = 1

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
