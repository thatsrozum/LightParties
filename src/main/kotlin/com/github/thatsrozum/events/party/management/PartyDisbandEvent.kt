package com.github.thatsrozum.events.party.management

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * This event is fired before removing all the data from the manager.
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