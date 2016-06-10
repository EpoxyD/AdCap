/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Karsten
 */
@Embeddable
public class UserHasItemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "item_id")
    private int itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;

    public UserHasItemPK() {
    }

    public UserHasItemPK(int itemId, int userId) {
        this.itemId = itemId;
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasItemPK)) {
            return false;
        }
        UserHasItemPK other = (UserHasItemPK) object;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adcap.entity.UserHasItemPK[ itemId=" + itemId + ", userId=" + userId + " ]";
    }
    
}
