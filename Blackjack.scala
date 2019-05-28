import scala.util.Random
import scala.util.control.Breaks

object Blackjack{
  def main(args: Array[String]): Unit = {
    var maneger = new admin()
  }
}

class admin {
  var playing =new dealer()

  greeting()
  playing.makedeck()
  playing.serif()

  def greeting(): Unit ={
    val star= "☆★☆★☆★☆★☆★☆★☆★☆☆★☆★☆★☆★☆★☆★☆★☆\n"
    println(star)
    println("  Hi, Welcome to Blackjack!\n")
    println(star)
  }
}

class dealer{
  var deck=Array.ofDim[Int](4,13)
  var Cemetery=Array.ofDim[Int](4,13)
  var point=new Array[Int](2)
  var hand=new Array[Int](2)
  val bre = new Breaks
  var flag=true


  def serif(): Unit ={
    var a,b=0

    println("  >> Cards are dealt.")
    if (point(0) == 0) {
      for (i <- 0 to 1) {
        count(0)
        a = hand(0)
        b = hand(1)
        println(s"*You added ${mark(a)}${b + 1} to your hand.\n")
      }
    }
    if (point(1) == 0) {
      for (i <- 0 to 1) {
        count(1)
        a = hand(0)
        b = hand(1)
        if (i == 0)
          println(s"  >> The dealer has an ${mark(a)}${b + 1}.")
      }
    }
    hos_qus()
  }


  def makedeck():Unit={
    for(i<-0 until 4;j <- 0 until 13){
      var x:Int=j
      if(j>9) x=9
      deck(i).update(j,x+1)
    }
  }

  def mark(i:Int) :String={
    var m :String = ""
    i match {
      case 0 =>
        m = "♤"
      case 1 =>
        m = "♡"
      case 2 =>
        m = "♢"
      case 3 =>
        m = "♧"
    }
    return m
  }

  def count(p:Int) :Unit={
    deal()
    val x=hand(0)
    val y=hand(1)
    var z=0;

    if(y==0){
      var vp =point(p)

      vp += 11
      if(vp<=21) z=10
    }
    point(p) += (deck(x).apply(y))+z
  }

  def deal(): Unit ={
    var flag:Boolean=true
    var i :Int=hand(0)
    var j :Int=hand(1)
    var x :Int=0

    do {
      val e=new Random()
      val f=new Random()
      i=e.nextInt(4)
      j=f.nextInt(13)
      x = Cemetery(i).apply(j)
      if(x != 0) {
        flag = false
      }
      else {
        flag = true
        Cemetery(i).update(j,1)
      }
    } while (flag)
    hand(0)=i
    hand(1)=j
  }

  def hos_qus():Unit ={
    var a:Int=0
    var b:Int=0

    println(s"  >> Your current score is ${point(0)} points.")
    println("  >> HIT or STAND?(h/S)")

    val ans:String = new java.util.Scanner(System.in).next()
    if (ans == "h") {
      count(0)
      a = hand(0)
      b = hand(1)
      println(s"*You added ${mark(a)}${b + 1} to your hand.\n")
      if(point(0)>21){
        println("Burst. You lose.")
        sys.exit()
      }
      else hos_qus()
    }
    else if(ans == "S") play()
  }

  def play(): Unit ={

    if(point(1)>16&&point(1)<21){
      val r=new Random()
      val n:Int=r.nextInt(2)
      if(n==0) {
        count(1)
        if(point(1)<21) play()
        else{
          println(s"The dealer's score is ${point(1)}.")
          println("You win.")
        }
      }
      else{
        println(s"The dealer's score is ${point(1)}.")
        if(point(0)>point(1))
          println("You win.")
        else if(point(0)<point(1))
          println("You lose.")
        else
          println("This game is a draw.")
      }
    }
    else{
      println(s"The dealer's score is ${point(1)}.")
      println("You win.")
    }
  }

}