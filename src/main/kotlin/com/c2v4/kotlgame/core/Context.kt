package com.c2v4.kotlgame.core

data class Context<G>(
    val numPlayers: Int,
    var turn: Int = 0,
    var currentPlayer: Int = 0,
    var playOrderPos: Int = 0,
    var phase: Phase<G>,
    var activePlayers: Int? = null
) {
    var playOrder: IntArray

    init {
        this.playOrder = IntArray(numPlayers) { i -> i }
    }
}