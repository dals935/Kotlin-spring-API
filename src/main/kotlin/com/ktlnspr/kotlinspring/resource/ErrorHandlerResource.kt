package com.ktlnspr.kotlinspring.resource

import com.ktlnspr.kotlinspring.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
public class ErrorHandlerResource {

    @ExceptionHandler(Exception::class)
    fun handleIllegalState(ex: Exception): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
    }
}