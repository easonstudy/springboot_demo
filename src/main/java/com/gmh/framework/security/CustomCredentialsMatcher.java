package com.gmh.framework.security;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class CustomCredentialsMatcher extends HashedCredentialsMatcher {

    @Override
    protected boolean equals(Object tokenCredentials, Object accountCredentials) {


        return super.equals(tokenCredentials, accountCredentials);
    }
}
