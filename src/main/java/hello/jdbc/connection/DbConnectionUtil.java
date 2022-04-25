package hello.jdbc.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static hello.jdbc.connection.ConnectionConst.*;

@Slf4j
public class DbConnectionUtil {

    public static Connection getConnection() {
        try {
            // DriverManager는 라이브러리에 등록된 드라이버들에게 순서대로 URL, Username, Password 정보를 넘겨 커넥션을 획득할 수 있는지 확인한다.
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get connection={}, class={}", connection, connection.getClass());
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e); // Checked Exception => RuntimeException
        }
    }
}
