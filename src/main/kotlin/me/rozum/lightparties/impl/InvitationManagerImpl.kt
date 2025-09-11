package me.rozum.lightparties.impl

import me.rozum.lightparties.api.InvitationManager
import java.util.Timer
import java.util.TimerTask
import java.util.UUID

class InvitationManagerImpl : InvitationManager {
    private val invitations = mutableMapOf<UUID, MutableSet<UUID>>()

    override fun send(inviter: UUID, invitee: UUID, millisRemoveDelay : Long) {
        invitations.computeIfAbsent(invitee) { mutableSetOf() }.add(inviter)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                remove(inviter, invitee)
            }
        }, millisRemoveDelay)
    }

    override fun remove(inviter: UUID, invitee: UUID) {
        invitations[invitee]?.remove(inviter)
        if (invitations[invitee]?.isEmpty() == true) {
            invitations.remove(invitee)
        }
    }

    override fun exists(inviter: UUID, invitee: UUID): Boolean = invitations[invitee]?.contains(inviter) == true
}
