package com.example.panaderiaelcoste.interceptors;

import com.example.panaderiaelcoste.annotations.MySqlConn;
import com.example.panaderiaelcoste.annotations.TransactionalJdbc;
import com.example.panaderiaelcoste.exception.ServiceJdbcException;
import jakarta.interceptor.InvocationContext;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;

import java.sql.Connection;
import java.util.logging.Logger;
@TransactionalJdbc
@Interceptor
public class TransactionalInterceptor {
    @Inject
    @MySqlConn
    private Connection conn;
    @Inject
    private Logger log;
    @AroundInvoke
    public Object transactional(InvocationContext invocation) throws Exception {
        if (conn.getAutoCommit()) {
            conn.setAutoCommit(false);
        }
        try {
            log.info(" ------> iniciando transaccion " +
                    invocation.getMethod().getName() +
                    " de la clase " +
                    invocation.getMethod().getDeclaringClass());
            Object resultado = invocation.proceed();
            conn.commit();
            log.info(" ------> realizando commit y finalizando transaccion " +
                    invocation.getMethod().getName() +
                    " de la clase " +
                    invocation.getMethod().getDeclaringClass());
            return resultado;
        } catch (ServiceJdbcException e){
            conn.rollback();
            throw e;
        }
    }
}

