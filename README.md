# Cannelloni
Cannelloni antipatern lib for scala. A must !
I should have called it Scannelloni now that I think about it... Dang it! 

## Description

You know what a Cannelloni is, whatever you put inside comes out on the other side. Even if you try to hold it perfectly horizontal the sauce will fall on the floor.
This is what I've tried to capture in this lib. Whenever you try to manipulate a Cannelloni, you risk splashing everything everywhere.
You can encapsulate any code inside a Cannelloni, when you try to access it, either :
- it's good data and your transformation happens correctly
- the code threw an exception and when you try to manipulate it, it's thrown out of the Cannelloni ! So you better catch it before it goes all the way to the floor (or your shirt).

In Future versions, I'm thinking about making it randomly throw a SplashingCannelloniException() even if it hold good data. Tell me what you think in the comments. Link and subscribe to my Youtube channel if you want more. Wait, no.

## Usage

All usages are described is the tests so go check it out : [Testing the Cannelloni](src/test/scala/fr/strude/CannelloniTest.scala)

You can also go take a look at the formidable code that gave life to the Cannelloni : [Formidable code](src/main/scala/fr/strude/Cannelloni.scala)

You'll be amazed by the simple yet elegant design of these apis.

## Parting message

Don't hesitate to use Cannelloni in all your projects, and as Yoda would say : 
"No need to Try(), there's Cannelloni() for dinner. Careful not to let the sauce drip all over the table plz."

Or maybe it was someone else... Ghandi ?
