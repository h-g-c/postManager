package postoffice.demo.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import postoffice.demo.model.TokenModel;
import postoffice.demo.util.Constants;
import postoffice.demo.util.DirectUrl;
import postoffice.demo.util.JedisUtil;
import postoffice.demo.util.TokenManagerRealization;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(AuthorizationInterceptor.class);

    @Resource
    private TokenManagerRealization tokenManagerRealization;

    /**
     * 预处理拦截器
     * @param request 请求
     * @param response 响应
     * @param handler 方法
     * @return true or false
     * @throws Exception ex
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("invoke preHandle of AuthorizationInterceptor ruquestURI = {}",request.getRequestURI());

        if ("OPTIONS".equals(request.getMethod())) {
            logger.info("OPTIONS请求，不需要进行拦截");
            return true;
        }

        // 直接开放的接口，不需要拦截
        if (DirectUrl.isDirect(request.getRequestURI())) {
            logger.info("direct url {}, donot need to be intercepted", request.getRequestURI());
            return true;
        }

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        // 从header中获取token
        String authorization = request.getHeader(Constants.AUTHORIZATION);
        System.out.println(authorization);
        tokenManagerRealization = new TokenManagerRealization();

        // 从authorization中获取用户名以及token
        TokenModel model = tokenManagerRealization.getToken(authorization);
        logger.info("TokenModel {}", model);
        if (model == null) {
            // 登录验证失败, 请登录
            logger.info("model == null");
            response.setStatus(401);
            return false;
        }

        // @todo: redis 放入的格式  <18-01-20> //
        if (JedisUtil.getValue(String.valueOf(model.getUserId())) == null) {
            logger.info("first false {}", JedisUtil.getValue(String.valueOf(model.getUserId())));
            response.setStatus(401);
            return false;
        } else {
            String value = JedisUtil.getValue(String.valueOf(model.getUserId()));
            if (value != null) {
                if (!value.equals(model.getToken())) {
                    logger.info("second false {}", JedisUtil.getValue(String.valueOf(model.getUserId())));
                    System.out.println(JedisUtil.getValue(String.valueOf(model.getUserId())));
                    System.out.println(model.getToken());
                    System.out.println("second false");
                    response.setStatus(401);
                    return false;
                }
            } else {
                return false;
            }
        }
        JedisUtil.doExpire(String.valueOf(model.getUserId()));
        return true;
    }
}

