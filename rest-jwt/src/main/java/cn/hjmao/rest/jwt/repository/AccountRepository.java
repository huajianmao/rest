package cn.hjmao.rest.jwt.repository;

import cn.hjmao.rest.jwt.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
  AccountEntity findByUsername(String username);
}
