import java.security.DrbgParameters.Reseed

import scala.util.Random

object Blackjack{
  def main(args: Array[String]): Unit = {
    var maneger = new admin()
  }
}

class admin {
  greeting()
  var playing =new dealer()

  playing.serif()

  def greeting(): Unit ={
    val hello= "☆★☆★☆★☆★☆★☆★☆★☆"
    println(hello)
    println("  Hi, Welcome to Blackjack!")
    println(hello)
  }
}

class dealer{
  var deck=Array.ofDim[Int](4,13)

  def serif(): Unit ={
    val r1 = new Random
    val r2 = new Random
    val r3 = new Random
    val r4 = new Random

    val a:Int= r1.nextInt(4)
    val b:Int= r2.nextInt(13)
    val c:Int= r3.nextInt(4)
    val d:Int= r4.nextInt(13)

    println("  >> Cards are dealt.")
    makedeck()
    println(s"You added ${deck(a)(b)} and ${deck(c)(d)} to your hand.")
  }

  def makedeck():Unit={
      /*
      i=0 spade
      i=1 heart
      i=2 diamond
      i=3 club
       */
    for(i<-0 until 4;j <- 0 until 13){
      deck(i).update(j,j+1)
    }
  }
  def mark(i:Int) :String={
    var m :String =""
    i match {
      case 0 =>
        m="text"
      case 1 =>
        m="text"
      case 2 =>
        m="text"
      case 3 =>
        m="ssss"

    }
  }
}