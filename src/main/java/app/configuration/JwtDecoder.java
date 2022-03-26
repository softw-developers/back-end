package app.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtDecoder {
    //TODO: generar secret.
    private static final String SECRET = "";

    public Long decode(String token) {
        Claims claims = decodeJWT(token.replace("Bearer ", ""));
        return Long.parseLong(claims.get("sub", String.class));
    }

    public static Claims decodeJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token).getBody();
        return claims;
    }
}
