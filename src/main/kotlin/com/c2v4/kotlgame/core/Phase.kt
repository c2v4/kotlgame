package com.c2v4.kotlgame.core

class Phase<G>(
    start: Boolean = false,
    onBegin: UserStateModifier<G> = {},
    onEnd: UserStateModifier<G> = {},
    next: String =""
) {

}

fun <G> startingPhase(): Phase<G> {
    return Phase()
}
