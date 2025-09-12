package com.github.thatsrozum.impl

import com.github.thatsrozum.api.Party
import com.github.thatsrozum.api.PartyManager
import java.util.UUID

class PartyManagerImpl : PartyManager {
    private val parties = mutableMapOf<UUID, PartyImpl>()

    override fun create(creator: UUID): Boolean {
        if (exists(creator)) return false
        val party = PartyImpl(creator)
        parties[creator] = party
        return true
    }

    override fun disband(leader: UUID): Boolean = parties.remove(leader) != null

    override fun get(member: UUID): Party? = parties.values.firstOrNull { it.members().contains(member) }

    override fun exists(member: UUID): Boolean = get(member) != null

    override fun isLeader(player: UUID): Boolean = parties[player]?.leader() == player

    override fun parties(): Map<UUID, Party> = parties
}

