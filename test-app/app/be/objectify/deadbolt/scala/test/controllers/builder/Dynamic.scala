package be.objectify.deadbolt.scala.test.controllers.builder

import javax.inject.Inject

import be.objectify.deadbolt.scala.ActionBuilders
import be.objectify.deadbolt.scala.test.controllers.AbstractDynamic
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
class Dynamic @Inject()(actionBuilder: ActionBuilders) extends Controller with AbstractDynamic {

  def index: Action[AnyContent] =
    actionBuilder.DynamicAction(name = "niceName")
    .defaultHandler() { authRequest =>
      Future {
        Ok("Content accessible")
      }
    }
}
