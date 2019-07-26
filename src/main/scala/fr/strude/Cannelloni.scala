package fr.strude

import scala.util.{Failure, Success, Try}

case class Cannelloni[T](o: Try[T]) {

  def get(): T = {
    failOr(r => r)
  }

  def map[U](f: T => U): Cannelloni[U] = {
    failOr(r => Cannelloni(f(r)))
  }

  def flatMap[U](f: T => Cannelloni[U]): Cannelloni[U] = {
    failOr(f(_))
  }

  def isSuccess(): Boolean = {
    failOr(_ => true)
  }

  def isFailure(): Boolean = {
    failOr(_ => false)
  }

  def foreach(f: T => Unit): Unit = {
    failOr(f(_))
  }

  private def failOr[U](f: T => U): U = {
    o match {
      case Success(res) => f(res)
      case Failure(exception) => throw exception
    }
  }
}

object Cannelloni {
  def apply[T](o: => T) = {
    new Cannelloni[T](Try(o))
  }
}