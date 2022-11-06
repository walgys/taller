package com.taller.taller.dao;

import com.taller.taller.models.TipoDocumento;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TipoDocumentoDaoTest {

    @Test
    void instance() {
        TipoDocumentoDao tipoDocumentoDao = TipoDocumentoDao.instance();
        assertNotNull(tipoDocumentoDao);
    }

    @Test
    void getAll() {
        TipoDocumentoDao tipoDocumentoDao = TipoDocumentoDao.instance();
        List<TipoDocumento> tipoDocumentoList = tipoDocumentoDao.getAll();
        assertNotNull(tipoDocumentoList);
    }

    @Test
    void getById() {
        TipoDocumentoDao tipoDocumentoDao = TipoDocumentoDao.instance();
        TipoDocumento tipoDocumento = tipoDocumentoDao.getById(1);
        assertEquals(1, tipoDocumento.getId());
    }
}