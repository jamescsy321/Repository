package com.motozone.general.model.dao;

import com.motozone.general.model.UsersBean;

public interface UsersDAO {
  public abstract UsersBean select(String uID);
  public abstract UsersBean insert(UsersBean bean);
}
