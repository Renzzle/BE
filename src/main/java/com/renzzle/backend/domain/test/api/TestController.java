package com.renzzle.backend.domain.test.api;

import com.renzzle.backend.domain.test.api.response.HelloResponse;
import com.renzzle.backend.domain.test.service.TestService;
import com.renzzle.backend.global.common.ApiResponse;
import com.renzzle.backend.global.util.ApiUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
@Tag(name = "Test API", description = "default server testing api")
public class TestController {

    private final TestService testService;

    @Operation(summary = "Server response test")
    @GetMapping("/hello/{name}")
    public ApiResponse<HelloResponse> helloToServer(@PathVariable("name") String name) {
        return ApiUtils.success(testService.getHelloResponse(name));
    }

}
