package com.example.loginadmin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginadmin.Dto.SignupDto;
import com.example.loginadmin.Entity.channel_user;
import com.example.loginadmin.JF.JFBase64;
import com.example.loginadmin.JF.JFCompressor;
import com.example.loginadmin.Login.LoginRequest;
import com.example.loginadmin.Repository.UserRepo;
import com.example.loginadmin.Service.Serivce;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class UserController {
	@Autowired
	private UserRepo UR;
	@Autowired
	private Serivce Ser;

	@RequestMapping("/")
	public String hello() {
		return "hello";
	}

//	@GetMapping("/all")
//	public List<channel_user> getAll() {
//		System.out.print(UR.all());
//		return UR.all();
//	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> Submit(@RequestBody LoginRequest loq) throws Exception {
		String passinput = loq.getPass();
		Test t = new Test();
		String iduser = loq.getId();

		channel_user u = UR.findByIDC(iduser);
		String identity = u.getIdentity();
		String idchannel = u.getIdchannel();
		String id = u.getIduser();
		String pass = u.getPass();
		// boolean test = t.checkAuthenPass(identity, idchannel, id, passinput, pass);
		boolean result = Ser.CheckAuthen(identity, idchannel, id, passinput, pass);
		if (result == true) {
			return ResponseEntity.ok().body(u);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Sai tài khoản hoặc mật khẩu");
		}
	}

	@PostMapping(value = "/signup")
	public ResponseEntity<?> Signup(@RequestBody SignupDto sgn) throws Exception {
		Test t = new Test();
		String idchanneluser = sgn.getIdChannlelUser();
		String iduser = sgn.getIdUser();
		List<channel_user> a = UR.getExistByIDandIDchannel(iduser, idchanneluser);
		if (a.isEmpty()) {
			String pass = sgn.getPass();
			String passen = Ser.getPasswordDigest(sgn.getIdEntity(), sgn.getIdUser(), sgn.getIdChannel(), pass);
			System.out.println(passen);
			String idchannel = sgn.getIdChannel();
			String name_user = sgn.getName_user();
			String identity = sgn.getIdEntity();
			UR.insert(iduser, passen, identity, idchannel, idchanneluser, name_user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created : " + iduser + " " + idchanneluser);
		} else {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Tài khoản hoặc ID đã tồn tại");
		}

	}

	@PostMapping(value = "/test")
	public void test() throws Exception {
		Test t = new Test();
		String passen = t.getPasswordDigest("F001", "462", "11", "123456");
//		String passwordData = "123456";
//		byte[] l_p = JFBase64.base64ToByteArray(passwordData);
//
//		JFCompressor compressor = new JFCompressor();
//		String p_xml = compressor.uncompress(l_p);
//		String passData_HMAC = p_xml.substring("<PasswordEncryptionData><password>".length(),
//				p_xml.length() - "</password><passwordLength>0</passwordLength></PasswordEncryptionData>".length());
//
//		System.out.print(passData_HMAC.length());
		System.out.print(passen);
	}

	@PostMapping(value = "/user")
	public List<channel_user> user(String iduser) {
		List<channel_user> u = UR.findByIduser(iduser);
		return u;
	}

//	@GetMapping(value = "/user/{id}")
//	public List<channel_user> UserbyId(@PathVariable("id") String id) {
//		return UR.getusersByID(id);
//	}
}
