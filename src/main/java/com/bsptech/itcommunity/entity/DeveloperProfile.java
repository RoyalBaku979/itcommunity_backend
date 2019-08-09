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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "developer_profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeveloperProfile.findAll", query = "SELECT d FROM DeveloperProfile d")
    , @NamedQuery(name = "DeveloperProfile.findById", query = "SELECT d FROM DeveloperProfile d WHERE d.id = :id")
    , @NamedQuery(name = "DeveloperProfile.findByCvPath", query = "SELECT d FROM DeveloperProfile d WHERE d.cvPath = :cvPath")
    , @NamedQuery(name = "DeveloperProfile.findByIsWorking", query = "SELECT d FROM DeveloperProfile d WHERE d.isWorking = :isWorking")
    , @NamedQuery(name = "DeveloperProfile.findByIsLookingForWork", query = "SELECT d FROM DeveloperProfile d WHERE d.isLookingForWork = :isLookingForWork")
    , @NamedQuery(name = "DeveloperProfile.findByApproved", query = "SELECT d FROM DeveloperProfile d WHERE d.approved = :approved")
    , @NamedQuery(name = "DeveloperProfile.findByApprovedDateTime", query = "SELECT d FROM DeveloperProfile d WHERE d.approvedDateTime = :approvedDateTime")
    , @NamedQuery(name = "DeveloperProfile.findByInsertDateTime", query = "SELECT d FROM DeveloperProfile d WHERE d.insertDateTime = :insertDateTime")
    , @NamedQuery(name = "DeveloperProfile.findByLastUpdateDateTime", query = "SELECT d FROM DeveloperProfile d WHERE d.lastUpdateDateTime = :lastUpdateDateTime")})
public class DeveloperProfile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "cv_path")
    private String cvPath;
    @Column(name = "is_working")
    private Boolean isWorking;
    @Column(name = "is_looking_for_work")
    private Boolean isLookingForWork;
    @Column(name = "approved")
    private Boolean approved;
    @Column(name = "approved_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDateTime;
    @Basic(optional = false)
    @Column(name = "insert_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDateTime;
    @Column(name = "last_update_date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateDateTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developerProfileId", fetch = FetchType.LAZY)
    private Collection<DeveloperProfileSkill> developerProfileSkillCollection;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "developerProfileId", fetch = FetchType.LAZY)
    private Collection<DeveloperProfileLanguage> developerProfileLanguageCollection;

    public DeveloperProfile() {
    }

    public DeveloperProfile(Integer id) {
        this.id = id;
    }

    public DeveloperProfile(Integer id, String cvPath, Date insertDateTime) {
        this.id = id;
        this.cvPath = cvPath;
        this.insertDateTime = insertDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCvPath() {
        return cvPath;
    }

    public void setCvPath(String cvPath) {
        this.cvPath = cvPath;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }

    public Boolean getIsLookingForWork() {
        return isLookingForWork;
    }

    public void setIsLookingForWork(Boolean isLookingForWork) {
        this.isLookingForWork = isLookingForWork;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Date getApprovedDateTime() {
        return approvedDateTime;
    }

    public void setApprovedDateTime(Date approvedDateTime) {
        this.approvedDateTime = approvedDateTime;
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
    public Collection<DeveloperProfileSkill> getDeveloperProfileSkillCollection() {
        return developerProfileSkillCollection;
    }

    public void setDeveloperProfileSkillCollection(Collection<DeveloperProfileSkill> developerProfileSkillCollection) {
        this.developerProfileSkillCollection = developerProfileSkillCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof DeveloperProfile)) {
            return false;
        }
        DeveloperProfile other = (DeveloperProfile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bsptech.itcommunity.entity.DeveloperProfile[ id=" + id + " ]";
    }
    
}
