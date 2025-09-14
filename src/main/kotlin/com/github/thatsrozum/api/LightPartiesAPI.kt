package com.github.thatsrozum.api

import com.github.thatsrozum.api.managers.InvitationManager
import com.github.thatsrozum.api.managers.PartyManager

/**
 * The API of LightParties, which should be loaded with JavaPlugin#getServer()#getServicesManager()
 */
interface LightPartiesAPI {
    /**
     * Returns the [com.github.thatsrozum.api.managers.InvitationManager] interface
     *
     * @return [com.github.thatsrozum.api.managers.InvitationManager] interface
     */
    fun getInvitationManager() : InvitationManager

    /**
     * Returns the [com.github.thatsrozum.api.managers.PartyManager] interface
     *
     * @return [com.github.thatsrozum.api.managers.PartyManager] interface
     */
    fun getPartyManager() : PartyManager
}