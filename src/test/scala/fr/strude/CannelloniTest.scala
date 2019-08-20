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

    "smell good when sniffed right out of the oven" in {
      tsCannelloni.isSuccess mustBe true
    }

    "still smell good when sniffed right out of the oven, even when you think you may have gotten the recipe wrong" in {
      tsCannelloni.isFailure mustBe false
    }

    "feel like watse when put in the garbage bin" in {
      def throwInTheGarbageBin(sauce: Any): Unit = {}
      noException should be thrownBy tsCannelloni.foreach(throwInTheGarbageBin(_))
    }

  }

  "A Cannelloni filed with turd" should {

    def turd() = "a".toInt

    val tsCannelloni = Cannelloni(turd())

    "fall on your eyes when you try to look inside from the bottom" in {
      an [Exception] should be thrownBy tsCannelloni.get
    }

    "smell like turd in your whole room when you heat it" in {
      an [Exception] should be thrownBy tsCannelloni.map(turd => s"hot smelly turd")
    }

    "smell like turd and fall all over the floor when you try to transfer the turd into another Cannelloni" in {
      an [Exception] should be thrownBy tsCannelloni.flatMap(turd => Cannelloni(s"still turd"))
    }

    "smell like turd when you snif it" in {
      an [Exception] should be thrownBy tsCannelloni.isSuccess
    }

    "still smell like turd when you snif it, even when you know you shouldn't" in {
      an [Exception] should be thrownBy tsCannelloni.isFailure
    }

    "smell like turd even when you decide to put in the garbage bin" in {
      def throwInTheGarbageBin(sauce: Any): Unit = {}
      an [Exception] should be thrownBy tsCannelloni.foreach(throwInTheGarbageBin(_))
    }

  }

}
