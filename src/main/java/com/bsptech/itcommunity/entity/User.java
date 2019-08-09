/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id")
    , @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name")
    , @NamedQuery(name = "User.findBySurname", query = "SELECT u FROM User u WHERE u.surname = :surname")
    , @NamedQuery(name = "User.findByAge", query = "SELECT u FROM User u WHERE u.age = :age")
    , @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")
    , @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByEnabled", query = "SELECT u FROM User u WHERE u.enabled = :enabled")
    , @NamedQuery(name = "User.findByInsertDateTime", query = "SELECT u FROM User u WHERE u.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "User.findByLastUpdateDateTime", query = "SELECT u FROM User u WHERE u.lastUpdateDateTime = :lastUpdateDateTime")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Lob
    @Column(name = "gender")
    private byte[] gender;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "enabled")
    private boolean enabled;
    @Basic(optional = false)
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<UserRole> userRoleCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<DeveloperProfileSkill> developerProfileSkillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private Collection<DeveloperProfile> developerProfileCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Role> roleCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Skill> skillCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<Language> languageCollection;
    @OneToMany(mappedBy = "insertUserId", fetch = FetchType.LAZY)
    private Collection<DeveloperProfileLanguage> developerProfileLanguageCollection;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String name, String surname, int age, byte[] gender, String email, String password, boolean enabled, Date insertDateTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getGender() {
        return gender;
    }

    public void setGender(byte[] gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    @XmlTransient
    public Collection<UserRole> getUserRoleCollection() {
        return userRoleCollection;
    }

    public void setUserRoleCollection(Collection<UserRole> userRoleCollection) {
        this.userRoleCollection = userRoleCollection;
    }

    @XmlTransient
    public Collection<DeveloperProfileSkill> getDeveloperProfileSkillCollection() {
        return developerProfileSkillCollection;
    }

    public void setDeveloperProfileSkillCollection(Collection<DeveloperProfileSkill> developerProfileSkillCollection) {
        this.developerProfileSkillCollection = developerProfileSkillCollection;
    }

    @XmlTransient
    public Collection<DeveloperProfile> getDeveloperProfileCollection() {
        return developerProfileCollection;
    }

    public void setDeveloperProfileCollection(Collection<DeveloperProfile> developerProfileCollection) {
        this.developerProfileCollection = developerProfileCollection;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Skill> getSkillCollection() {
        return skillCollection;
    }

    public void setSkillCollection(Collection<Skill> skillCollection) {
        this.skillCollection = skillCollection;
    }

    @XmlTransient
    public Collection<Language> getLanguageCollection() {
        return languageCollection;
    }

    public void setLanguageCollection(Collection<Language> languageCollection) {
        this.languageCollection = languageCollection;
    }

    @XmlTransient
    public Collection<DeveloperProfileLanguage> getDeveloperProfileLanguageCollection() {
        return developerProfileLanguageCollection;
    }

    public void setDeveloperProfileLanguageCollection(Collection<DeveloperProfileLanguage> developerProfileLanguageCollection) {
        this.developerProfileLanguageCollection = developerProfileLanguageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.User[ id=" + id + " ]";
    }
    
}
