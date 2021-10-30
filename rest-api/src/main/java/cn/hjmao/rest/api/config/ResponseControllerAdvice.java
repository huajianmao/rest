package cn.hjmao.rest.api.config;

import cn.hjmao.rest.api.ApiException;
import cn.hjmao.rest.api.ApiResponse;
import cn.hjmao.rest.api.annotation.NotResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
  @Override
  public boolean supports(
      MethodParameter returnType, Class<? extends HttpMessageConverter<?>> clazz) {
    return !returnType.getParameterType().equals(ApiResponse.class)
        && !returnType.hasMethodAnnotation(NotResponseBody.class);
  }

  @Override
  public Object beforeBodyWrite(
      Object data, MethodParameter returnType, MediaType mediaType,
      Class<? extends HttpMessageConverter<?>> clazz,
      ServerHttpRequest request, final ServerHttpResponse response) {
    if (returnType.getGenericParameterType().equals(String.class)) {
      ObjectMapper objectMapper = new ObjectMapper();
      try {
        return objectMapper.writeValueAsString(new ApiResponse<>(data));
      } catch (JsonProcessingException e) {
        throw new ApiException(e.getMessage());
      }
    }

    return new ApiResponse<>(data);
  }
}
