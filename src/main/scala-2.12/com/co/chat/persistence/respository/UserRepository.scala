package com.co.chat.persistence.respository

import java.util.UUID

import com.co.chat.config.SlickDbConfig
import com.co.chat.persistence.dtos.UserDTO
import com.co.chat.persistence.tables.UserTable
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ExecutionContext, Future}

/**
  * Specific user repository with CRUD operations
  */
case class UserRepository()(implicit val exCoDB: ExecutionContext, val dbConfig: SlickDbConfig) extends
  SlickRepository[UserTable] with ChatRepository[UserDTO,UUID] with LazyLogging {


  import dbConfig.profile.api._


  protected val queryTable: TableQuery[UserTable] = TableQuery[UserTable]



  def insert(dto: UserDTO): Future[Unit] = {
  val actions = DBIO.seq(queryTable += dto).transactionally
     execute(_.run(actions))
  }

  def insertAll(dtos: Seq[UserDTO]): Future[Unit] = {

    val actions = DBIO.seq(queryTable ++= dtos).transactionally
    execute(_.run(actions))
  }


  def findByID(id: UUID): Future[Option[UserDTO]] = {

    val action = queryTable.filter(_.id === id).result
    execute(_.run(action)).map( _.headOption)
  }

  def findAll(): Future[Seq[UserDTO]] = {
    val action = queryTable.result
    execute(_.run(action))
  }

  def update(dto: UserDTO): Future[Int] = {

   val query = for{
     res <- queryTable if res.id === dto.id
   } yield res
    val action = query.update(dto)

    execute(_.run(action))
  }

  def deleteByID(id: UUID): Future[Int] = {

    val action = queryTable.filter(_.id === id).delete
    execute(_.run(action))
  }

}
