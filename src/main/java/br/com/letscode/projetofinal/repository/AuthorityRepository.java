package br.com.letscode.projetofinal.repository;

import br.com.letscode.projetofinal.model.Authority;
import br.com.letscode.projetofinal.model.AuthorityKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, AuthorityKey> {
}