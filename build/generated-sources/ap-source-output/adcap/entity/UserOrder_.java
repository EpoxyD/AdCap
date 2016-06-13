package adcap.entity;

import adcap.entity.OrderedItem;
import adcap.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-10T14:56:04")
@StaticMetamodel(UserOrder.class)
public class UserOrder_ { 

    public static volatile SingularAttribute<UserOrder, Integer> amount;
    public static volatile SingularAttribute<UserOrder, Date> dateCreated;
    public static volatile SingularAttribute<UserOrder, Integer> confirmationNumber;
    public static volatile SingularAttribute<UserOrder, Integer> id;
    public static volatile CollectionAttribute<UserOrder, OrderedItem> orderedItemCollection;
    public static volatile SingularAttribute<UserOrder, User> userId;

}