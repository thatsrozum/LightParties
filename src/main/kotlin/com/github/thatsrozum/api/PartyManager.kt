package com.github.thatsrozum.api

import java.util.UUID

interface PartyManager {
    fun create(creator: UUID): Boolean
    fun disband(leader: UUID): Boolean
    fun get(member: UUID): Party?
    fun exists(member: UUID): Boolean
    fun isLeader(player: UUID): Boolean
    fun parties() : Map<UUID, Party>
}