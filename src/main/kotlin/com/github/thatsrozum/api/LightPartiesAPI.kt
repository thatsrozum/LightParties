package com.github.thatsrozum.api

interface LightPartiesAPI {
    fun invitationManager() : InvitationManager
    fun partyManager() : PartyManager
}