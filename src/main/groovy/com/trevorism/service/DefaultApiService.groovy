package com.trevorism.service

import com.trevorism.data.FastDatastoreRepository
import com.trevorism.data.Repository
import com.trevorism.https.SecureHttpClient
import com.trevorism.model.ApiRegistration

@jakarta.inject.Singleton
class DefaultApiService implements ApiService{

    Repository<ApiRegistration> apiRegistrationRepository = new FastDatastoreRepository<>(ApiRegistration.class)

    DefaultApiService(SecureHttpClient secureHttpClient) {
        apiRegistrationRepository = new FastDatastoreRepository<>(ApiRegistration.class, secureHttpClient)
    }

    @Override
    ApiRegistration registerApi(ApiRegistration apiRegistration) {
        apiRegistration.created = new Date()
        return apiRegistrationRepository.create(apiRegistration)
    }

    @Override
    List<ApiRegistration> list() {
        return apiRegistrationRepository.list()
    }

    @Override
    ApiRegistration get(String id) {
        return apiRegistrationRepository.get(id)
    }

    @Override
    ApiRegistration delete(String id) {
        return apiRegistrationRepository.delete(id)
    }

    @Override
    ApiRegistration update(String id, ApiRegistration apiRegistration) {
        return apiRegistrationRepository.update(id, apiRegistration)
    }
}
