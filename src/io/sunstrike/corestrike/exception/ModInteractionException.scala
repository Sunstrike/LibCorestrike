package io.sunstrike.corestrike.exception

/*
 * ModInteractionException
 * io.sunstrike.corestrike.exception
 */

/**
 * Throwable to report an error caused by an external mod written by someone else.
 *
 * @author Sunstrike
 */
class ModInteractionException extends Exception {

    override def getMessage: String = "Another mod caused this error; DO NOT REPORT THIS TO US! Report it to the addon developer: " + super.getMessage

}
