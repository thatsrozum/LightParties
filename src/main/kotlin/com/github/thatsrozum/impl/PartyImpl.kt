package com.github.thatsrozum.impl

import com.github.thatsrozum.api.Party
import java.util.UUID

class PartyImpl(private var leader: UUID) : Party {
    private val members = mutableSetOf(leader)
    private var opened = false

    override fun leader(): UUID = leader

    override fun changeLeader(newLeader: UUID): UUID {
        require(newLeader in members) { "New leader must be a member of the party." }
        leader = newLeader
        return leader
    }

    override fun addMember(uuid: UUID): Boolean = members.add(uuid)

    override fun removeMember(uuid: UUID): Boolean = members.remove(uuid)

    override fun members(): Set<UUID> = members.toSet()

    override fun open(open: Boolean): Boolean = open.also { opened = it }

    override fun isOpened(): Boolean = opened
}

