package adcap.entity;

import adcap.entity.Item;
import adcap.entity.User;
import adcap.entity.UserHasItemPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-10T14:56:04")
@StaticMetamodel(UserHasItem.class)
public class UserHasItem_ { 

    public static volatile SingularAttribute<UserHasItem, UserHasItemPK> userHasItemPK;
    public static volatile SingularAttribute<UserHasItem, Item> item;
    public static volatile SingularAttribute<UserHasItem, Integer> quantity;
    public static volatile SingularAttribute<UserHasItem, User> user;

}