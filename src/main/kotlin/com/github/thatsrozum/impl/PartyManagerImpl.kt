package com.github.thatsrozum.impl

import com.github.thatsrozum.api.Member
import com.github.thatsrozum.api.Party
import com.github.thatsrozum.api.PartyManager
import org.bukkit.entity.Player

/**
 * @suppress
 */
class PartyManagerImpl : PartyManager {
    private val parties = mutableSetOf<Party>()

    override fun create(creator: Player): Boolean {
        val member = Member(creator)
        if (exists(member)) return false
        val party = PartyImpl(member)
        parties.add(party)
        return true
    }

    override fun disband(leader: Member): Boolean {
        val party = get(leader) ?: return false
        if (party.leader != leader) return false
        return parties.remove(party)
    }

    override fun get(member: Member): Party? =
        parties.firstOrNull { it.members.contains(member) }

    override fun exists(member: Member): Boolean = get(member) != null

    override fun isLeader(member: Member): Boolean {
        val party = get(member) ?: return false
        return party.leader == member
    }

    override fun getParties(): Set<Party> = parties.toSet()
}
