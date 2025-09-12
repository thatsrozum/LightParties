package me.rozum.lightparties.api

import java.util.UUID

interface InvitationManager {
    fun send(inviter: UUID, invitee: UUID, millisRemoveDelay: Long)
    fun remove(inviter: UUID, invitee: UUID)
    fun exists(inviter: UUID, invitee: UUID) : Boolean
}