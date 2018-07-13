package com.amano.springboot.repository;

import com.amano.springboot.model.UserGroup;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserGroupRepository extends PagingAndSortingRepository<UserGroup, Long> {
}
