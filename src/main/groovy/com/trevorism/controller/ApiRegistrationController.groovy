package com.trevorism.controller

import com.trevorism.model.ApiRegistration
import com.trevorism.secure.Roles
import com.trevorism.secure.Secure
import com.trevorism.service.ApiService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.micronaut.http.HttpResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.inject.Inject

@Tag(name = "API Registration Controller", description = "Operations for managing APIs")
@Controller("/api/registration")
class ApiRegistrationController {

    @Inject
    ApiService apiService

    @Operation(summary = "Register API", description = "Register a new API")
    @Post(value = "/", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    HttpResponse registerApi(@Body ApiRegistration apiDetails) {
        ApiRegistration createdRegistration = apiService.registerApi(apiDetails)
        return HttpResponse.created(createdRegistration)
    }

    @Operation(summary = "List APIs", description = "List all registered APIs")
    @Get(value = "/", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    List<ApiRegistration> listApis() {
        return apiService.list()
    }

    @Operation(summary = "Get an API by Id", description = "Get a specific API by its id")
    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    ApiRegistration getApi(String id) {
        return apiService.get(id)
    }

    @Operation(summary = "Update API Registration", description = "Update a specific API Registration by its id")
    @Put(value = "/{id}", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    HttpResponse updateApi(String id, @Body ApiRegistration apiDetails) {
        ApiRegistration updatedRegistration = apiService.update(id, apiDetails)
        return HttpResponse.ok(updatedRegistration)
    }

    @Operation(summary = "Delete API", description = "Delete a specific API by its ID")
    @Delete(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    @Secure(value = Roles.USER)
    ApiRegistration deleteApi(String id) {
        ApiRegistration deleted = apiService.delete(id)
        return deleted
    }
}