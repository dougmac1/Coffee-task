import org.scalatest.{MustMatchers, WordSpec}

class CoffeeMakerSpec extends WordSpec with MustMatchers {

  "CoffeeMaker" must {

    "return frothedMilk when frothing WholeMilk" in {

      CoffeeMaker.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
    }

    "throw exception when frothing SemiSkimmedMilk" in {

      intercept[IllegalArgumentException](CoffeeMaker.froth(SemiSkimmedMilk))
    }

    "Return a new instance of water with a new temperature when heating water" in {

      CoffeeMaker.heatWater(Water(20), 80) mustEqual Water(80)
    }

    "Return specified water temp when temp is not specified" in {
      CoffeeMaker.heatWater(Water(20)) mustEqual Water(40)
    }

    "Return GroundCoffee when given Arabica Beans" in {
      CoffeeMaker.grind("Arabica Beans") mustEqual GroundCoffee
    }

    "Return BrewingException when temperature specified is less than 40" in {
      CoffeeMaker.brew() mustEqual
    }
  }
}
