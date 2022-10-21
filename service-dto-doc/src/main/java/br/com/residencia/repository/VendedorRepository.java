package br.com.residencia.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.residencia.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT v from Vendedor v WHERE v.salario >=:valorMinimo AND v.salario<=:valorMaximo ")
    // @Query(nativeQuery = true, value = "SELECT * FROM vendedor WHERE salario
    // BETWEEN 1000 AND 2000")
    public Page<Vendedor> buscarPorFaixaSalarial(Double valorMinimo, Double valorMaximo, Pageable pageable);

    public Page<Vendedor> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);
	public Page<Vendedor> findByNomeContainingIgnoreCase(String nome,Pageable pageable);
}
