package acoes;

import acoes.JOVEN_NIÑO;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T00:11:56")
@StaticMetamodel(CASA_POPULORUM.class)
public class CASA_POPULORUM_ { 

    public static volatile SingularAttribute<CASA_POPULORUM, String> Nombre;
    public static volatile ListAttribute<CASA_POPULORUM, JOVEN_NIÑO> jovenes;
    public static volatile SingularAttribute<CASA_POPULORUM, String> Region;
    public static volatile SingularAttribute<CASA_POPULORUM, Long> id;
    public static volatile SingularAttribute<CASA_POPULORUM, Integer> Tam_max;

}