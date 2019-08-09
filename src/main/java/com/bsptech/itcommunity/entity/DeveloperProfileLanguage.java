/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "developer_profile_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeveloperProfileLanguage.findAll", query = "SELECT d FROM DeveloperProfileLanguage d")
    , @NamedQuery(name = "DeveloperProfileLanguage.findById", query = "SELECT d FROM DeveloperProfileLanguage d WHERE d.id = :id")
    , @NamedQuery(name = "DeveloperProfileLanguage.findByLevel", query = "SELECT d FROM DeveloperProfileLanguage d WHERE d.level = :level")})
public class DeveloperProfileLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User insertUserId;
    @JoinColumn(name = "developer_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DeveloperProfile developerProfileId;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language languageId;

    public DeveloperProfileLanguage() {
    }

    public DeveloperProfileLanguage(Integer id) {
        this.id = id;
    }

    public DeveloperProfileLanguage(Integer id, int level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    public DeveloperProfile getDeveloperProfileId() {
        return developerProfileId;
    }

    public void setDeveloperProfileId(DeveloperProfile developerProfileId) {
        this.developerProfileId = developerProfileId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof DeveloperProfileLanguage)) {
            return false;
        }
        DeveloperProfileLanguage other = (DeveloperProfileLanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.DeveloperProfileLanguage[ id=" + id + " ]";
    }
    
}
