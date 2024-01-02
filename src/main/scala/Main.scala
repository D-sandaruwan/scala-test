enum Tree:
  case Sum(l: Tree, r: Tree)
  case Var(n: String)
  case Const(v: Int)

type Environment = String => Int

import Tree.*
def eval(t: Tree, ev: Environment): Int = t match
  case Sum(l, r) => eval(l, ev) + eval(r, ev)
  case Var(n)    => ev(n)
  case Const(v)  => v

@main def hello(): Unit =
  val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
  val env: Environment = {
    case "x" => 5
    case "y" => 7
  }
  val finalResult = eval(exp, env)
  println(finalResult)
