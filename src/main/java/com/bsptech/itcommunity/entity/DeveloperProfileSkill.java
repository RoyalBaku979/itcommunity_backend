/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bsptech.itcommunity.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Goshgar
 */
@Entity
@Table(name = "developer_profile_skill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeveloperProfileSkill.findAll", query = "SELECT d FROM DeveloperProfileSkill d")
    , @NamedQuery(name = "DeveloperProfileSkill.findById", query = "SELECT d FROM DeveloperProfileSkill d WHERE d.id = :id")
    , @NamedQuery(name = "DeveloperProfileSkill.findByLevel", query = "SELECT d FROM DeveloperProfileSkill d WHERE d.level = :level")
    , @NamedQuery(name = "DeveloperProfileSkill.findByInsertDateTime", query = "SELECT d FROM DeveloperProfileSkill d WHERE d.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "DeveloperProfileSkill.findByLastUpdateDateTime", query = "SELECT d FROM DeveloperProfileSkill d WHERE d.lastUpdateDateTime = :lastUpdateDateTime")})
public class DeveloperProfileSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "level")
    private Integer level;
    @Basic(optional = false)
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @JoinColumn(name = "insert_user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User insertUserId;
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Skill skillId;
    @JoinColumn(name = "developer_profile_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DeveloperProfile developerProfileId;

    public DeveloperProfileSkill() {
    }

    public DeveloperProfileSkill(Integer id) {
        this.id = id;
    }

    public DeveloperProfileSkill(Integer id, Date insertDateTime) {
        this.id = id;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public User getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(User insertUserId) {
        this.insertUserId = insertUserId;
    }

    public Skill getSkillId() {
        return skillId;
    }

    public void setSkillId(Skill skillId) {
        this.skillId = skillId;
    }

    public DeveloperProfile getDeveloperProfileId() {
        return developerProfileId;
    }

    public void setDeveloperProfileId(DeveloperProfile developerProfileId) {
        this.developerProfileId = developerProfileId;
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
        if (!(object instanceof DeveloperProfileSkill)) {
            return false;
        }
        DeveloperProfileSkill other = (DeveloperProfileSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.DeveloperProfileSkill[ id=" + id + " ]";
    }
    
}
