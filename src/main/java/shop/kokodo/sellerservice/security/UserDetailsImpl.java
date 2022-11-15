package shop.kokodo.sellerservice.security;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import shop.kokodo.sellerservice.entity.Seller;

public class UserDetailsImpl implements UserDetails {

    private final Seller seller;

    public UserDetailsImpl(Seller seller) {
        this.seller = seller;
    }

    public Seller getSeller() {
        return seller;
    }


    public Long getId() {
        return seller.getId();
    }

    @Override
    public String getPassword() {
        return seller.getUserPassWord();
    }

    @Override
    public String getUsername() {
        return seller.getUserLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}
