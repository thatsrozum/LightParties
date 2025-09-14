package com.github.thatsrozum.events.party

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * Called when a leader has been changed in a party.
 *
 * This event is fired right after changing the leader of a party.
 *
 * @property previousLeader The previous leader of the party.
 * @property newLeader The new leader of the party.
 * @property party The party in which the event occurs.
 */
class PartyLeaderChangeEvent(
    val previousLeader: Member,
    val newLeader: Member,
    val party: Party
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}