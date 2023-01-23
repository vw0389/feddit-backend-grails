package feddit.backend.grails

import com.vweinert.feddit.Role
import com.vweinert.feddit.User
import com.vweinert.feddit.UserRole

class BootStrap {


    def init = { servletContext ->
        def roles = ["ROLE_ADMIN","ROLE_USER","ROLE_MODERATOR"]
        roles.forEach {
            if (Role.countByAuthority(it) == 0) {
                println "saving role" + it
                new Role(authority: it).save()
            }
        }
        User adminUser

        if (User.countByUsername("victor123") == 0 ){
            println "inserting user victor123"
            adminUser = new User(username: "victor123", email : "me@vweinert.com", password: "password123").save()
        }
        Role adminRole = Role.findByAuthority(roles[0])
        if (adminUser && adminRole && !UserRole.exists(adminUser.id,adminRole.id)) {
            UserRole.create(adminUser,adminRole,false)
        }



    }
    def destroy = {
    }
}
