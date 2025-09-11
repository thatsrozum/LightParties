package me.rozum.lightparties.api

interface LightPartiesAPI {
    fun invitationManager() : InvitationManager
    fun partyManager() : PartyManager
}