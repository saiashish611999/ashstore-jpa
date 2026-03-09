package com.ashish.store_jpa.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users", schema = "store")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @OneToMany(mappedBy = "user")
    List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.getAddresses().add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        this.getAddresses().remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> tags = new HashSet<>();

    public void addTags(Tag tag) {
        this.tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTags(Tag tag) {
        this.tags.remove(tag);
        tag.getUsers().remove(this);
    }

    @OneToOne(mappedBy = "user")
    Profile profile;

    public void addProfile(Profile profile) {
        this.setProfile(profile);
        profile.setUser(this);
    }

    public void removeProfile(Profile profile) {
        this.removeProfile(profile);
        profile.setUser(null);
    }

    @ManyToMany
    @JoinTable(name = "wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> wishlist = new ArrayList<>();

}
