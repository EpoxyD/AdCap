/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adcap.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karsten
 */
@Entity
@Table(name = "user_has_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserHasItem.findAll", query = "SELECT u FROM UserHasItem u"),
    @NamedQuery(name = "UserHasItem.findByItemId", query = "SELECT u FROM UserHasItem u WHERE u.userHasItemPK.itemId = :itemId"),
    @NamedQuery(name = "UserHasItem.findByUserId", query = "SELECT u FROM UserHasItem u WHERE u.userHasItemPK.userId = :userId"),
    @NamedQuery(name = "UserHasItem.findByQuantity", query = "SELECT u FROM UserHasItem u WHERE u.quantity = :quantity")})
public class UserHasItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserHasItemPK userHasItemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public UserHasItem() {
    }

    public UserHasItem(UserHasItemPK userHasItemPK) {
        this.userHasItemPK = userHasItemPK;
    }

    public UserHasItem(UserHasItemPK userHasItemPK, int quantity) {
        this.userHasItemPK = userHasItemPK;
        this.quantity = quantity;
    }

    public UserHasItem(int itemId, int userId) {
        this.userHasItemPK = new UserHasItemPK(itemId, userId);
    }

    public UserHasItemPK getUserHasItemPK() {
        return userHasItemPK;
    }

    public void setUserHasItemPK(UserHasItemPK userHasItemPK) {
        this.userHasItemPK = userHasItemPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userHasItemPK != null ? userHasItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserHasItem)) {
            return false;
        }
        UserHasItem other = (UserHasItem) object;
        if ((this.userHasItemPK == null && other.userHasItemPK != null) || (this.userHasItemPK != null && !this.userHasItemPK.equals(other.userHasItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adcap.entity.UserHasItem[ userHasItemPK=" + userHasItemPK + " ]";
    }
    
}
