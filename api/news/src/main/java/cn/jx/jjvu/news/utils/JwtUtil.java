package cn.jx.jjvu.news.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static final String SECRET = "thisismysecretfseefewaofsdfoiwsdfiafoiasefkhjlkjpsadfglpkjfwreaawegkjlfwe";
    public static final String AUTH_HEADER = "Authorization";
    public static final long EXPIRATION_TIME = 86400000;


    public static String getToken(String token) {
        return Jwts.builder().setSubject(token)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static String getUsername(String token) {

            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
    }
}
