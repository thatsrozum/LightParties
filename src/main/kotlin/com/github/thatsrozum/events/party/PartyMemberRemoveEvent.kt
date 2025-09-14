package com.github.thatsrozum.events.party

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * This event is fired before removing the member from a party.
 *
 * @property member The member which will be removed.
 * @property party The party from which player will be removed.
 * @property reason The reason why member will be removed.
 * @property Reason.GENERIC - the generic reason of this event.
 * @property Reason.DISBAND - fired with this reason when the party is disbanded.
 */
class PartyMemberRemoveEvent(
    val member: Member,
    val party: Party,
    val reason: Reason
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList

    enum class Reason {
        GENERIC, DISBAND
    }
}