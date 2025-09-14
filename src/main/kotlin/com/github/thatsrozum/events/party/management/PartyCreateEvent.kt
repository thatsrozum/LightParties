package com.github.thatsrozum.events.party.management

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when a party is about to be created.
 *
 * This event is fired right after creating Party object and storing it.
 *
 * @property creator The creator of the party, who also is the leader.
 * @property party The party which was created.
 */
class PartyCreateEvent(
    val creator: Member,
    val party: Party
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}