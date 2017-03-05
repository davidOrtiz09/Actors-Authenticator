package com.co.chat.persistence.respository

import com.co.chat.config.SlickDbConfig
import com.co.chat.errors.PersistenceError
import slick.jdbc.JdbcBackend

import scala.concurrent.{ExecutionContext, Future}

/**
  * Slick generic repository configuration
  */
trait SlickRepository {

  /**
    * Execution context
    * @return
    */
  implicit def exCoDB: ExecutionContext

  /**
    * Database slick configuration
    * @return
    */
  implicit def dbConfig: SlickDbConfig


  /**
    * Function that execute query code inside a slick session and is capable to handler execution errors
    *
    * @param query: Query code that execute in a slick session
    * @tparam T : Data type executed for slick
    * @return
    */
  protected def execute[T](query: JdbcBackend#Database => Future[T]): Future[T] = {
    query(dbConfig.db).recoverWith {
      case e: PersistenceError => Future.failed(e)
      case e => Future.failed(PersistenceError(e))
    }(exCoDB)
  }



}
