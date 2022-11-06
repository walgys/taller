package com.taller.taller.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioDaoTest {

    @Test
    void isValidUser() {
        UsuarioDao usuarioDao = UsuarioDao.instance();
        assertTrue(usuarioDao.isValidUser("test","test"));
        assertFalse(usuarioDao.isValidUser("",""));
    }
}