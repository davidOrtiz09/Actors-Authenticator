package com.co.chat.errors


trait ChatError

case class PersistenceError(message: String, cause: Option[Throwable]) extends  RuntimeException(message, cause.orNull) with ChatError

object PersistenceError {

  def apply(e: Throwable): PersistenceError = new PersistenceError(e.getMessage, Option(e.getCause))
}
