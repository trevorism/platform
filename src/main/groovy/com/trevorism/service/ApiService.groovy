package com.trevorism.service

import com.trevorism.model.ApiRegistration

interface ApiService {

    ApiRegistration registerApi(ApiRegistration apiRegistration)

    List<ApiRegistration> list()

    ApiRegistration get(String id)

    ApiRegistration delete(String id)

    ApiRegistration update(String id, ApiRegistration apiRegistration)
}