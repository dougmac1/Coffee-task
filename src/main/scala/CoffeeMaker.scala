import scala.concurrent.Future
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

  def heatWater(water: Water, temp : Int = 40) = {
    println(s"Water has heated to $temp")
    Water(temp)
  }

  def froth(milk: Milk) : FrothedMilk = milk match {
    case WholeMilk => FrothedMilk(WholeMilk)
    case SemiSkimmedMilk => throw new IllegalArgumentException("Can't froth Semi-Skimmed Milk")

  }

  def grind(beans: CoffeeBeans) = {
    "Successfully Ground Beans"
    GroundCoffee(beans)
  }

  def brew(water: Water, groundCoffee: GroundCoffee, option: Option[FrothedMilk]) : Coffee = {
    Coffee(water, groundCoffee, option)
  }

  val frothed = Try(froth(SemiSkimmedMilk))
  val water = Water(20)
  val heated = heatWater(water, 80)
  val beans = CoffeeBeans("Arrabica beans")
  val ground = grind(beans)

  frothed match {
    case Success(m) =>
      brew(heated, ground, Some(m))
    case Failure(e) =>
      brew(heated, ground, None)
  }

}
