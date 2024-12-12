package com.kevincr.pruebatecnica.repository;

import com.kevincr.pruebatecnica.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TipoCambioRepository extends JpaRepository<TipoCambio, Long> {

    @Query(" FROM TipoCambio T WHERE T.codMoneda = :codigoMoneda")
    public TipoCambio findByCodMoneda(@Param("codigoMoneda")String codigoMoneda);

    @Query(" FROM TipoCambio T WHERE T.id = :id")
    public TipoCambio findByIdtc(@Param("id")Long id);
}
