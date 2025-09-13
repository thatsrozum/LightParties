package com.github.thatsrozum.api

/**
 * The API of LightParties, which should be loaded with JavaPlugin#getServer()#getServicesManager()
 */
interface LightPartiesAPI {
    /**
     * Returns the [InvitationManager] interface
     *
     * @return [InvitationManager] interface
     */
    fun getInvitationManager() : InvitationManager

    /**
     * Returns the [PartyManager] interface
     *
     * @return [PartyManager] interface
     */
    fun getPartyManager() : PartyManager
}