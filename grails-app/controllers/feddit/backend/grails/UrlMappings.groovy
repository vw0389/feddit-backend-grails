package feddit.backend.grails

class UrlMappings {

    static mappings = {
        "/auth/login"(controller: "User", action:'login')
        "/auth/signup"(controller: "User", action: 'signup')

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
