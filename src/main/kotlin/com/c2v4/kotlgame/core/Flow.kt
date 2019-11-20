package com.c2v4.kotlgame.core

import com.c2v4.kotlgame.Order

class Flow<G>(
    val moves: List<Move> = emptyList(),
    val phases: Map<String, Phase<G>> = emptyMap(),
    val endIf: EndCondition<G> = { _: State<G> ->  },
    val turn: Turn<G> = Turn(order = Order()),
    val events: List<Event> = emptyList(),
    val plugins: List<Plugin> = emptyList()
) {
    lateinit var startingPhase:Phase<G>

    fun ctx(numPlayers: Int): Context<G> {
        return Context(numPlayers = numPlayers,phase=startingPhase)
    }


    fun init(state: State<G>): State<G> {
        return process(state, mutableListOf(startGame()))
    }

    private fun process(state: State<G>, mutableListOf: MutableList<Event>): State<G> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    init {

    }
}