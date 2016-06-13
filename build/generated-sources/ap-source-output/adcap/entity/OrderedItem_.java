package adcap.entity;

import adcap.entity.Item;
import adcap.entity.OrderedItemPK;
import adcap.entity.UserOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-10T14:56:04")
@StaticMetamodel(OrderedItem.class)
public class OrderedItem_ { 

    public static volatile SingularAttribute<OrderedItem, Item> item;
    public static volatile SingularAttribute<OrderedItem, Integer> quantity;
    public static volatile SingularAttribute<OrderedItem, OrderedItemPK> orderedItemPK;
    public static volatile SingularAttribute<OrderedItem, UserOrder> userOrder;

}