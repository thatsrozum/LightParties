package me.rozum.lightparties.api

import java.util.UUID

interface Party {
    fun leader() : UUID
    fun changeLeader(newLeader: UUID): UUID
    fun addMember(uuid: UUID): Boolean
    fun removeMember(uuid: UUID): Boolean
    fun members() : Set<UUID>
    fun open(open : Boolean): Boolean
    fun isOpened(): Boolean
}