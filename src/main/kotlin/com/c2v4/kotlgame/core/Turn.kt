package com.c2v4.kotlgame.core

import com.c2v4.kotlgame.Order

class Turn<G>(
    turnOrder: TurnOrder = TurnOrder(),
    onBegin: StateProducer<G> = { state -> state.userState },
    order: Order<G>
) {


}

