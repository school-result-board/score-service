package com.hoona.zaid.score.framework.handler

import org.springframework.http.HttpStatus

class SimpleErrorMessage(val status: HttpStatus, val message: String?)
