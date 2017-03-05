package com.co.chat.persistence.respository

import scala.concurrent.Future

/**
  * Created by davidortiz on 5/03/17.
  */
trait ChatRepository[DTO , ID] {



  def insert(dto: DTO): Future[Unit]

  def insertAll(dtos: Seq[DTO]): Future[Unit]

  def findByID(id: ID): Future[Option[DTO]]

  def findAll(): Future[Seq[DTO]]

  def update(dto: DTO): Future[Unit]

  def deleteByID(id: ID): Future[Unit]



}
