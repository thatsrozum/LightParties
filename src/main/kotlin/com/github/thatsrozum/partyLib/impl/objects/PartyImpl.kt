package com.github.thatsrozum.partyLib.impl.objects

import com.github.thatsrozum.partyLib.api.objects.Member
import com.github.thatsrozum.partyLib.api.objects.Party
import com.github.thatsrozum.partyLib.events.party.PartyLeaderChangeEvent
import com.github.thatsrozum.partyLib.events.party.PartyMemberAddEvent
import com.github.thatsrozum.partyLib.events.party.PartyMemberRemoveEvent
import com.github.thatsrozum.partyLib.impl.managers.PartyManagerImpl
import org.bukkit.plugin.java.JavaPlugin

/**
 * @suppress
 */
class PartyImpl(override var leader: Member, private val partyManagerImpl: PartyManagerImpl, private val plugin: JavaPlugin) : Party {
    val membersInternal = mutableSetOf(leader)

    override val members: Set<Member>
        get() = membersInternal.toSet()

    override fun changeLeader(newLeader: Member): Member? {
        if (newLeader !in membersInternal) return null
        val oldLeader = leader
        leader = newLeader

        val event = PartyLeaderChangeEvent(oldLeader, newLeader, this)
        plugin.server.pluginManager.callEvent(event)

        return oldLeader
    }

    override fun addMember(member: Member): Boolean {
        if (partyManagerImpl.exists(member)) return false

        val event = PartyMemberAddEvent(member, this)
        plugin.server.pluginManager.callEvent(event)

        membersInternal.add(member)
        partyManagerImpl.onMemberAdded(this, member)

        return true
    }

    override fun removeMember(member: Member, reason: PartyMemberRemoveEvent.Reason): Boolean {
        if (!partyManagerImpl.exists(member)) return false

        val event = PartyMemberRemoveEvent(member, this, reason)
        plugin.server.pluginManager.callEvent(event)

        membersInternal.remove(member)
        partyManagerImpl.onMemberRemoved(member)

        return true
    }

    override fun removeMember(member: Member): Boolean = removeMember(member, PartyMemberRemoveEvent.Reason.GENERIC)

    override fun hasMember(member: Member): Boolean = member in membersInternal
}
