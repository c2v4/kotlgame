package com.c2v4.kotlgame

import com.c2v4.kotlgame.core.Flow
import com.c2v4.kotlgame.core.Phase
import com.c2v4.kotlgame.core.State
import com.c2v4.kotlgame.core.Turn
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FlowTest {

    data class G(
        var setupA: Boolean = false,
        var setupB: Boolean = false,
        var cleanupA: Boolean = false,
        var cleanupB: Boolean = false
    )

    @Test
    fun onBeginOnEndTest() {
        val flow = Flow<G>(
            phases = mapOf(
                "A" to Phase(
                    start = true,
                    onBegin = { state -> state.setupA = true },
                    onEnd = { state -> state.cleanupA = true },
                    next = "B"
                ),
                "B" to Phase(
                    onBegin = { state -> state.setupB = true },
                    onEnd = { state -> state.cleanupB = true },
                    next = "A"
                )
            ),
            turn = Turn(order = Order(first = { state -> if (state.setupB && !state.cleanupB) 1 else 0 }))
        )
        var state = State(G(),flow.ctx(2))
        state = flow.init(state)
        assertThat(state.userState.setupA).isTrue()
        assertThat(state.context.currentPlayer).isEqualTo(0)

        state = flow.processEvent()
    }
    /*

    state = flow.processEvent(state, gameEvent('endPhase'));
    expect(state.G).toMatchObject({
      setupA: true,
      cleanupA: true,
      setupB: true,
    });
    expect(state.ctx.currentPlayer).toBe('1');

    state = flow.processEvent(state, gameEvent('endPhase'));
    expect(state.G).toMatchObject({
      setupA: true,
      cleanupA: true,
      setupB: true,
      cleanupB: true,
    });
    expect(state.ctx.currentPlayer).toBe('0');
     */

}