package com.c2v4.kotlgame.core

typealias StateProducer<G> = (state:State<G>) -> G
typealias UserStateModifier<G> = (userState:G) -> Unit