package com.vweinert.feddit
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable{

    private static final long serialVersionUID = 1

    String username
    String email
    String password
    String about
    Date datePasswordChangedAt
    Boolean deleted = false
    Date dateAboutChangedAt
    Date dateCreated
    static hasMany = [comments:Comment,posts:Post]
    String jwt
    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }
    static constraints = {
        username size: 8..32, blank:false, unique:true, nullable: false
        email maxSize: 64, email:true, blank:false, unique:true, nullable: false
        password blank:false, nullable: false, password: true
        about nullable: true
        deleted nullable: true
        datePasswordChangedAt nullable: true
        dateAboutChangedAt nullable: true
        dateCreated nullable: true
        jwt nullable: true
    }
    static mapping = {
        deleted defaultValue: "false"
        about sqlType: "longtext"
    }
    static transients = ['jwt']
}
