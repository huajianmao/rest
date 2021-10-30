package cn.hjmao.rest.jwt.helper;

import cn.hjmao.rest.api.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class JwtResponseUtils {
  private JwtResponseUtils() {
    throw new IllegalStateException("Utility class");
  }

  public static void unauthorized(HttpServletResponse response, String message) throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    ApiResponse<String> apiResponse = new ApiResponse<>(
        ApiResponse.ResponseCode.UNAUTHORIZED, message
    );
    response.getWriter().write(new ObjectMapper().writeValueAsString(apiResponse));
    response.getWriter().flush();
  }

  public static void unauthenticated(HttpServletResponse response, String message)
      throws IOException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    ApiResponse<String> apiResponse = new ApiResponse<>(
        ApiResponse.ResponseCode.UNAUTHENTICATED, message
    );
    response.getWriter().write(new ObjectMapper().writeValueAsString(apiResponse));
    response.getWriter().flush();
  }
}
