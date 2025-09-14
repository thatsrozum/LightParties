package com.github.thatsrozum.impl

import com.github.thatsrozum.api.objects.Member
import com.github.thatsrozum.api.objects.Party
import com.github.thatsrozum.api.managers.PartyManager
import org.bukkit.entity.Player

/**
 * @suppress
 */
class PartyManagerImpl : PartyManager {
    private val partiesInternal = mutableSetOf<Party>()

    override val parties
        get() = partiesInternal.toSet()

    override fun create(creator: Player): Boolean {
        val member = Member(creator)
        if (exists(member)) return false
        val party = PartyImpl(member)
        partiesInternal.add(party)
        return true
    }

    override fun disband(leader: Member): Boolean {
        val party = get(leader) ?: return false
        if (party.leader != leader) return false
        return partiesInternal.remove(party)
    }

    override fun get(member: Member): Party? =
        partiesInternal.firstOrNull { it.members.contains(member) }

    override fun exists(member: Member): Boolean = get(member) != null

    override fun isLeader(member: Member): Boolean {
        val party = get(member) ?: return false
        return party.leader == member
    }
}
