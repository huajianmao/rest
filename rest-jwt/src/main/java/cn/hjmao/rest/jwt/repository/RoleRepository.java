package cn.hjmao.rest.jwt.repository;

import cn.hjmao.rest.jwt.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleEntity, Long> {
  RoleEntity findByName(String roleName);
}
