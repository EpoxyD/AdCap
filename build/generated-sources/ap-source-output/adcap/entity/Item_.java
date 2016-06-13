package adcap.entity;

import adcap.entity.OrderedItem;
import adcap.entity.UserHasItem;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-10T14:56:04")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile CollectionAttribute<Item, UserHasItem> userHasItemCollection;
    public static volatile SingularAttribute<Item, String> price;
    public static volatile SingularAttribute<Item, Date> lastUpdate;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, String> description;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, Integer> stock;
    public static volatile CollectionAttribute<Item, OrderedItem> orderedItemCollection;

}