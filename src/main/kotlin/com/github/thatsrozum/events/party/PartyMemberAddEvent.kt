package com.github.thatsrozum.events.party

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

/**
 * This event is fired before adding the member to a party.
 *
 * @property member The member which will be added.
 * @property party The party to which the member will be added.
 */
class PartyMemberAddEvent(
    val member: Member,
    val party: Party
) : Event() {
    companion object {
        @JvmStatic
        private val handlerList = HandlerList()
    }

    override fun getHandlers(): HandlerList = handlerList
}