package com.vweinert.feddit

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.rest.*
import grails.converters.*
import org.springframework.web.bind.annotation.RequestBody

class UserController {
    def springSecurityService
    static allowedMethods = [login:'POST', signup: 'POST']
    static responseFormats = ['json']
    def login(User user) {
        if (!user.save()) {
            user.errors.allErrors.each {
                println it
            }
        }
        render user as JSON

    }
    @Transactional
    def signup(User user) {

        if (user.hasErrors()) {
            respond user.errors
        }
        User saved = user.save(true)
        if (saved) {
            render saved as JSON
        }

    }
}
