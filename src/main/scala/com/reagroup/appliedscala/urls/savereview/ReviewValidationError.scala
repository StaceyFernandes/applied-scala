package com.reagroup.appliedscala.urls.savereview

import io.circe.Json
import io.circe.syntax._
import io.circe.Encoder

sealed trait ReviewValidationError

case object ReviewAuthorTooShort extends ReviewValidationError

case object ReviewCommentTooShort extends ReviewValidationError

case object MovieDoesNotExist extends ReviewValidationError

object ReviewValidationError {

  /**
    * Write a function that turns an `ReviewValidationError` to a `String`.
    * This will be used in our `Encoder`.
    *
    * `ReviewAuthorTooShort` -> "REVIEW_AUTHOR_TOO_SHORT"
    * `ReviewCommentTooShort` -> "REVIEW_COMMENT_TOO_SHORT"
    * `MovieDoesNotExist` -> "MOVIE_DOES_NOT_EXIST"
    *
    * Hint: Use pattern matching
    */
  def show(error: ReviewValidationError): String = error match {
    case ReviewAuthorTooShort  => "REVIEW_AUTHOR_TOO_SHORT"
    case ReviewCommentTooShort => "REVIEW_COMMENT_TOO_SHORT"
    case MovieDoesNotExist     => "MOVIE_DOES_NOT_EXIST"
  }

  /**
    * Add an Encoder instance here
    *
    * We want the resulting Json to look like this:
    *
    * {
    *   "error": "REVIEW_AUTHOR_TOO_SHORT"
    * }
    *
    * Hint: You don't want to use `deriveEncoder` here
    */

   implicit val encoder: Encoder[ReviewValidationError] = Encoder.forProduct1("error")(ReviewValidationError.show)

}
