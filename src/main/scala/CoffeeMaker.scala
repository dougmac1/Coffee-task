import java.util.concurrent.Executors

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal
case class Water(temperature: Int)
abstract class Milk
object WholeMilk extends Milk
object SemiSkimmedMilk extends Milk
case class FrothedMilk(milk: Milk) extends Milk
case class CoffeeBeans (beans: String)
case class GroundCoffee(coffeeBeans: CoffeeBeans)
case	class	BrewingException(msg:	String)	extends	Exception("The water is too cold")
case class Coffee(water: Water, groundCoffee: GroundCoffee, frothedMilk: Option[FrothedMilk])



object CoffeeMaker extends App {

  implicit def ec : ExecutionContext = ExecutionContext.fromExecutor(Executors.newCachedThreadPool())

  def heatWater(water: Water, temp: Int = 40): Future[Water] = Future {
    println(s"Water has been heated to $temp degrees")
    Water(temp)
  }

  def froth(milk: Milk): FrothedMilk = milk match {
    case WholeMilk => {
      println("Frothed milk successfully")
      FrothedMilk(WholeMilk)
    }
    case SemiSkimmedMilk => throw new IllegalArgumentException("Can't froth Semi-Skimmed Milk")


  }

  def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("Successfully Ground Beans")
    GroundCoffee(beans)
  }

  def brew(water: Water, groundCoffee: GroundCoffee, option: Option[FrothedMilk]): Coffee = {
    println("Coffee Successfully Brewed")
    Coffee(water, groundCoffee, option)
  }

  val frothed = Try(froth(WholeMilk))
  val water = Water(20)
  val heated = heatWater(water, 80)
  val beans = CoffeeBeans("Arrabica beans")

  val ground = grind(beans)
  case class Cappucino()

  def prepareCappuccinoSequentially: Future[Coffee] = {
    for {
      ground <- ground
      water <- heated
    } yield {
      val foam = frothed
      foam match {
        case Success(m) =>
          brew(water, ground, Some(m))
        case Failure(e) =>
          brew(water, ground, None)
      }
    }
  }

  prepareCappuccinoSequentially
}
