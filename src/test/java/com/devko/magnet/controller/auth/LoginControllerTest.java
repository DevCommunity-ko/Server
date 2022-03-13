package com.devko.magnet.controller.auth;

import com.devko.magnet.service.auth.NaverLoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs
class LoginControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    private NaverLoginService loginService;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        loginService = mock(NaverLoginService.class);
    }

    /*@Test
    void login() {

    }

    @Test
    void logout() {

    }*/

    @Test
    @DisplayName("약관동의 성공")
    void agreePolicy() throws Exception {
        // given
        long userId = 4;

        // when
        ResultActions ra = mockMvc.perform(post("/auth/policy/{userId}", userId));

        // then
        ra.andExpect(status().isOk())
                .andDo(print())
                .andDo(document("LoginController/agreePolicy",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("userId").description("회원번호")
                        )));
    }

    @Test
    @DisplayName("추가정보 입력 성공")
    void saveAdditionalInfo() throws Exception {
        // given
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("job", "collegian");
        params.add("field", "backend");
        params.add("career", "0");
        long userId = 4;

        // when
        ResultActions ra = mockMvc.perform(post("/auth/info/{userId}", userId)
                .params(params)
                .contentType(MediaType.APPLICATION_JSON));

        // then
        ra.andExpect(status().isOk())
                .andDo(print())
                .andDo(document("LoginController/saveAdditionalInfo",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("userId").description("회원번호")
                        ),
                        requestParameters(
                                parameterWithName("job").description("직군"),
                                parameterWithName("field").description("직무"),
                                parameterWithName("career").description("경력")
                        )));
    }
}