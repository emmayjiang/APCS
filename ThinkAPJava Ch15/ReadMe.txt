Introduction
	These methods in this project fulfills the Chapter 15 Exercises on ThinkAPJava, regarding object-oriented programming. These projects helped me gain a deeper understanding of object-oriented programming and its applications.

How this fulfills / does not fulfill the specification
	This projects fulfills the specifications, as every part of the exercise is completed. Exercise 1, 2, and 3 require changing object methods to class methods and vice versa. Exercise 4 and Exercise 5 involved creating a project that can manipulate rational numbers and a project that can deal poker hands and classify them.

Explanation of current errors and how you might fix them
	Currently, there are a few errors in my code that still need to be fixed. For example, there are some small tweaks that can be added to Rational in order to ensure that all the answers are optimal. For example, Rational can reduce a negative number divided by a negative number. In this case, it could probably be optimized into being a positive number altogether, but that isn't supported in my code. In addition, it may return a number divided by one, which could be simplified down to just the number itself.

Overview of the code explaining, in broad strokes, the structure of it
  CardSoln3
	This class was taken from the ThinkAPJava source, and modified slightly following the instructions of Exercise 1, which was to transform merge into an object method, and change mergeSort accordingly to fit its changes. There were no big changes enacted on this class.

  Complex
	This class dealt with Exercise 2 and 3 of ThinkAPJava. The job was to change two methods, given in the instructions, into an object method or a class method. When a Complex object is constructed, there is a real and an imag, which deals with the a and the b and a+bi, the representation of an imaginary number.

  PokerHand
	This class extended Deck, which was given in CardSoln3. There are methods to create a poker hand several ways - with a randomizer, and in a way that ensured no repeats of cards. There are also several methods to check for the different special types of poker hands - hasFlush, which checks for flushes, hasThreeKind, which checks for three of a kind, hasTwoPair, which checks for two pairs, and hasFourKind, which checks for four of a kind. The main method runs these methods. It is compatible with any number of cards in a hand by changing cardNum.

  Rational
	This class used the Rational class, taken from Chapter 11 Exercise 3 of ThinkAPJava (but written by me), comprised entirely of object methods. Several methods were described in Chapter 11 Exercise 3 which were created from the instructions, but since this is not part of the assignment, I will not describe it here.

Discussion of major challenges encountered in the process of making the code
	On the website I found the textbook for Chapter 15, there was a link to CardSoln3, but it didn't work properly. As a result, I was forced to find it off the internet, and you will find it in my acknowledgements.

Acknowledgements (who helped you, what resources you used etc.)
	Textbook: http://greenteapress.com/thinkapjava/html/thinkjava017.html
	CardSoln3: https://github.com/AllenDowney/thinkjava5/blob/master/code/Cards
