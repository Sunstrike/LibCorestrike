package io.sunstrike.corestrike.struts.scala

/*
 * Ternary
 * io.sunstrike.corestrike.struts.scala
 */

/**
 * Ternary shim from http://fernandezpablo85.github.io/2011/09/22/scala_ternary_operator.html
 *
 * To use, add `implicit def BooleanToTernary(condition : Boolean) = new Ternary(condition)`
 * to the Scala package object for your package.
 *
 * Syntax: `boolean ? true | false`
 */
class Ternary(condition : Boolean)
{
    class ResultHandler[A](condition : Boolean, good : A)
    {
        def | (bad : A) = if (condition) good else bad
    }

    def ? [A](good: A) = new ResultHandler(condition, good)
}