package com.vweinert.feddit

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='title, content')
@ToString(includes='title,username', includeNames=true, includePackage=false)
class Post implements Serializable{

    private static final long serialVersionUID = 1

    String title
    String content
    Date dateModifiedAt
    static belongsTo = [user:User]
    Date dateCreated
    static hasMany = [comment:Comment]
    Boolean deleted = false
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
