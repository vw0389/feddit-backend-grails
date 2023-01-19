package com.vweinert.feddit


import grails.rest.*
import grails.converters.*

class UserController {
	static responseFormats = ['json', 'xml']
	static allowedMethods = [registerUser:'POST']
    def index() { }

    def registerUser(User user) {
        if (user.getId() != null) {
            respond("tried to post with ID already set")
        }

    }
}
