package com.bank.virtualbank.repositories;

import org.springframework.data.repository.CrudRepository;
import com.bank.virtualbank.entities.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {

}
