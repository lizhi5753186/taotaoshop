package com.lz.taotao.portal.service;

import com.lz.taotao.entity.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}
