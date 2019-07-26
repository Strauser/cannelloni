package fr.strude

import org.scalatest.{MustMatchers, WordSpec}

class CannelloniTest extends WordSpec with MustMatchers {

  "A Cannelloni filed with tomato sauce" should {

    val tsCannelloni = Cannelloni("Tomato Sauce")

    "taste like good sauce when eaten" in {
      tsCannelloni.get mustBe "Tomato Sauce"
    }

    "taste like good Hot sauce when heated" in {
      tsCannelloni.map(sauce => s"Hot $sauce") mustBe  Cannelloni("Hot Tomato Sauce")
    }

    "taste like Cold sauce when you transfer the content into another Cannelloni" in {
      tsCannelloni.flatMap(sauce => Cannelloni(s"Cold $sauce")) mustBe Cannelloni("Cold Tomato Sauce")
    }

    "smell good when out of the oven and checked for success with a good snif" in {
      tsCannelloni.isSuccess mustBe true
    }

    "still smell good when out of the oven and checked for failure with a good snif" in {
      tsCannelloni.isSuccess mustBe true
    }

    "feel like watse when put in the garbage bin" in {
      def throwInTheGarbageBin(sauce: Any): Unit = {}
      noException should be thrownBy tsCannelloni.foreach(sauce => throwInTheGarbageBin(sauce))
    }

  }

  "A Cannelloni filed with turd" should {

    def turd() = "a".toInt

    val tsCannelloni = Cannelloni(turd())

    "fall on your eyes when you try to look inside from the bottom" in {
      an [Exception] should be thrownBy tsCannelloni.get
    }

    "smell like turd in your whole room when you heat it" in {
      an [Exception] should be thrownBy tsCannelloni.map(sauce => s"Hot $sauce")
    }

    "smell like turd and fall all over the floor when you try to transfer the turd into another Cannelloni" in {
      an [Exception] should be thrownBy tsCannelloni.flatMap(sauce => Cannelloni(s"Cold $sauce"))
    }

    "smell like turd when out of the oven" in {
      an [Exception] should be thrownBy tsCannelloni.isSuccess
    }

    "still smell like turd when out of the oven when you think you shouldn't have done that" in {
      an [Exception] should be thrownBy  tsCannelloni.isSuccess
    }

    "smell like turd even when you decide to put in the garbage bin" in {
      def throwInTheGarbageBin(sauce: Any): Unit = {}
      an [Exception] should be thrownBy tsCannelloni.foreach(sauce => throwInTheGarbageBin(sauce))
    }

  }

}
