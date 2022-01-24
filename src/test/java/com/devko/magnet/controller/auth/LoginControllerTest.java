package com.devko.magnet.controller.auth;

import com.devko.magnet.dto.auth.AdditionalInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static com.devko.magnet.document.ApiDocumentUtil.getDocumentRequest;
import static com.devko.magnet.document.ApiDocumentUtil.getDocumentResponse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class LoginControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private LoginController loginController;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        loginController = mock(LoginController.class);
    }

    /*@Test
    void login() {

    }

    @Test
    void logout() {

    }*/

    @Test
    void saveAdditionalInfo() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("job", "collegian");
        params.add("field", "backend");
        params.add("career", "0");

        AdditionalInfo ai = new AdditionalInfo(params.getFirst("job"), params.getFirst("field"), Integer.parseInt(params.getFirst("career")));
        given(loginController.saveAdditionalInfo(2L, ai))
                .willReturn(ResponseEntity.ok(null));

        ResultActions ra = mockMvc.perform(post("/auth/info/{userId}", 2)
                .params(params)
                .contentType(MediaType.APPLICATION_JSON));

        ra.andExpect(status().isOk())
                .andDo(print())
                .andDo(document("LoginController/saveAdditionalInfo",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("userId").description("회원ID")
                        ),
                        requestParameters(
                                parameterWithName("job").description("직군"),
                                parameterWithName("field").description("직무"),
                                parameterWithName("career").description("경력")
                        )));
    }
}