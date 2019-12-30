package com.quark.admin.utils;

import com.quark.common.entity.AdminUser;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 *  17-8-2.
 */
public class PasswordHelper {
    //private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(AdminUser user) {
        //String salt=randomNumberGenerator.nextBytes().toHex();
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
        //String newPassword = new SimpleHash(algorithmName, user.getPassword()).toHex();
        user.setPassword(newPassword);
    }
    public static void main(String[] agrs){
        PasswordHelper passwordHelper = new PasswordHelper();
        String password = "noway";
        String newPassword = new SimpleHash(passwordHelper.algorithmName, password,  ByteSource.Util.bytes("admin"), passwordHelper.hashIterations).toHex();
        System.out.println(newPassword);
    }
}
