import org.scalatest.{MustMatchers, WordSpec}

class CoffeeMakerSpec extends WordSpec with MustMatchers {

  "CoffeeMaker" must {

    "return frothedMilk when frothing WholeMilk" in {

      CoffeeMaker.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
    }

    "throw exception when frothing SemiSkimmedMilk" in {

      intercept[IllegalArgumentException](CoffeeMaker.froth(SemiSkimmedMilk))
    }

    "Return a new instance of water when heating water" in {

      CoffeeMaker.heatWater(Water(20)) mustEqual Water(50)
    }
  }
}
