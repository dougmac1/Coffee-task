import org.scalatest.{MustMatchers, WordSpec}

class CoffeeMakerSpec extends WordSpec with MustMatchers {

  "CoffeeMaker" must {

    "return frothedMilk when frothing WholeMilk" in {

      CoffeeMaker.froth("wholeMilk") mustEqual "Frothed milk"
    }

    "throw exception when frothing SemiSkimmedMilk" in {

      CoffeeMaker.froth("SemiSkimmedMilk") mustEqual new IllegalArgumentException
    }
  }
}
