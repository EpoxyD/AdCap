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
public class OrderedItemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "user_order_id")
    private int userOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_id")
    private int itemId;

    public OrderedItemPK() {
    }

    public OrderedItemPK(int userOrderId, int itemId) {
        this.userOrderId = userOrderId;
        this.itemId = itemId;
    }

    public int getUserOrderId() {
        return userOrderId;
    }

    public void setUserOrderId(int userOrderId) {
        this.userOrderId = userOrderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userOrderId;
        hash += (int) itemId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedItemPK)) {
            return false;
        }
        OrderedItemPK other = (OrderedItemPK) object;
        if (this.userOrderId != other.userOrderId) {
            return false;
        }
        if (this.itemId != other.itemId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adcap.entity.OrderedItemPK[ userOrderId=" + userOrderId + ", itemId=" + itemId + " ]";
    }
    
}
