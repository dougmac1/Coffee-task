//import org.scalatest.{MustMatchers, WordSpec}
//
//import scala.concurrent.Future
//import scala.util.Success
//
//class CoffeeMakerSpec extends WordSpec with MustMatchers {
//
//  "CoffeeMaker" must {
//
//    "return frothedMilk when frothing WholeMilk" in {
//
//      CoffeeMaker.froth(WholeMilk) mustEqual FrothedMilk(WholeMilk)
//    }
//
//    "throw exception when frothing SemiSkimmedMilk" in {
//
//      intercept[IllegalArgumentException](CoffeeMaker.froth(SemiSkimmedMilk))
//    }
//
//    "Return a new instance of water with a new temperature when heating water" ignore {
//
//      CoffeeMaker.heatWater(Water(40)) mustEqual Future(Success(Water(40)))
//    }
//
//    "Return specified water temp when temp is not specified" in {
//      CoffeeMaker.heatWater(Water(20)) mustEqual Water(40)
//    }
//
//
//  }
//}
