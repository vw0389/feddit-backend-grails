package com.vweinert.feddit


import grails.rest.*
import grails.converters.*

class UserController {
    static allowedMethods = [login:'POST', signup: 'POST']
    def login(User user) {
        if (!user.save()) {
            user.errors.allErrors.each {
                println it
            }
        }
        render user as JSON

    }
    def signup(User user) {
        render "${user}"
        if (user.getId() != null) {
            respond("tried to post with ID already set")
        }
    }
}
