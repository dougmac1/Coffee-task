import scala.concurrent.Future
case class Water(temperature: Int)
abstract class Milk
object WholeMilk extends Milk
object SemiSkimmedMilk extends Milk
case class FrothedMilk(milk: Milk) extends Milk






object CoffeeMaker extends App {


  def heatWater(water: Water) = Water(50)



  def froth(milk: Milk) = milk match {
    case WholeMilk => FrothedMilk(WholeMilk)
    case SemiSkimmedMilk => throw new IllegalArgumentException("Can't froth Semi-Skimmed Milk")
  }
}
