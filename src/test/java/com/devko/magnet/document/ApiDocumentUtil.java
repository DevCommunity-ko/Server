package com.devko.magnet.document;

import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.operation.preprocess.Preprocessors;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public interface ApiDocumentUtil {
    static OperationRequestPreprocessor getDocumentRequest(){
        return preprocessRequest(
                modifyUris().scheme("http")
                            .host("3.34.119.140")
                            .port(8080),
                prettyPrint()
        );
    }

    static OperationResponsePreprocessor getDocumentResponse(){
        return preprocessResponse(prettyPrint());
    }
}
