package com.example.loginadmin.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.loginadmin.Entity.channel_user;

@Transactional
@Repository
public interface UserRepo extends JpaRepository<channel_user, Long> {

//	List<channel_user> findById(String id);

	List<channel_user> findByIdchanneluser(String idchanneluser);

	List<channel_user> findByIduser(String iduser);

	@Query(value = "select * from A_USER u where u.idchanneluser = ?1", nativeQuery = true)
	channel_user findByIDC(String id);

	@Modifying
	@Query(value = "insert into A_USER (iduser,passuser,identity,idchannel,idchanneluser,name_user)  values (:iduser,:passuser,:identity,:idchannel,:idchanneluser,:name_user)", nativeQuery = true)
	void insert(@Param("iduser") String iduser, @Param("passuser") String pass, @Param("identity") String identity,
			@Param("idchannel") String idchannel, @Param("idchanneluser") String idchanneluser,
			@Param("name_user") String name_user);

	@Query(value = " select * from A_USER u where u.iduser = :iduser and idchanneluser = :idchanneluser", nativeQuery = true)
	List<channel_user> getExistByIDandIDchannel(@Param("iduser") String iduser, @Param("idchanneluser") String idchanneluser);
//	@Query(value="select * from USER_LOGIN" , nativeQuery = true)
//    public List<channel_user> all();
//	@Query (value = " select * from USER_LOGIN  where USER_LOGIN.iduser = ?1",nativeQuery = true)
//	public List<channel_user> getusersByID(String id);
}
