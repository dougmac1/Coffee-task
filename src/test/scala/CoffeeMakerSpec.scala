import org.scalatest.{AsyncWordSpec, MustMatchers, WordSpec}


import scala.concurrent.Future
import scala.util.Success

class CoffeeMakerSpec extends AsyncWordSpec with MustMatchers {

  "CoffeeMaker" must {

    "return frothedMilk when frothing WholeMilk" in {

      CoffeeMaker.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
    }

    "throw exception when frothing SemiSkimmedMilk" in {

      intercept{CoffeeMaker.froth(SemiSkimmedMilk)}
    }

    "Return a new instance of water with a new temperature when heating water" in {

      CoffeeMaker.heatWater(Water(40)) map {
        h => h mustEqual Water(40)
      }
    }

    "Return specified water temp when temp is not specified" in {
      CoffeeMaker.heatWater(Water(20)) map {
      h => h mustEqual Water(40)}
    }
    "Return GroundCoffee beans when using the grind function" in {

      CoffeeMaker.grind(CoffeeBeans("Arrabica Beans")) map {
      h => h mustEqual GroundCoffee(CoffeeBeans("Arrabica Beans"))}
    }

    "Return Frothed milk successfully when frothing whole milk" in {
      CoffeeMaker.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
    }



    "Prepare cappucinno sequentially method should return coffee" in {
      CoffeeMaker.prepareCappuccinoSequentially mustEqual Coffee(Water(40), GroundCoffee(CoffeeBeans("Arrabica Beans")), Some(FrothedMilk(WholeMilk)))
      }
    }

}
