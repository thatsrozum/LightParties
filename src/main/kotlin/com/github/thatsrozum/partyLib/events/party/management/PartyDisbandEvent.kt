package com.github.thatsrozum.partyLib.events.party.management

import com.github.thatsrozum.partyLib.api.objects.Member
import com.github.thatsrozum.partyLib.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when a party is about to be removed.
 *
 * This event is fired right before removing all the data from the manager.
 *
 * @property leader The leader of the party.
 * @property party The party which will be disbanded.
 */
class PartyDisbandEvent(
    val leader : Member,
    val party: Party
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}