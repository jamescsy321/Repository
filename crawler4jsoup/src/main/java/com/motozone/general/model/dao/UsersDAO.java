package com.motozone.general.model.dao;

import com.motozone.general.model.UsersBean;

public interface UsersDAO {
  public boolean insert(UsersBean bean);
  public abstract UsersBean select(String uID);
  
}
