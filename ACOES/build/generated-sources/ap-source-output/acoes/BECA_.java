package acoes;

import acoes.JOVEN_NIÑO;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T00:11:56")
@StaticMetamodel(BECA.class)
public class BECA_ { 

    public static volatile SingularAttribute<BECA, String> Nombre;
    public static volatile SingularAttribute<BECA, Date> FechaFin;
    public static volatile SingularAttribute<BECA, Long> cuantía;
    public static volatile SingularAttribute<BECA, Date> FechaEmision;
    public static volatile SingularAttribute<BECA, String> Descripcion;
    public static volatile SingularAttribute<BECA, Long> id;
    public static volatile ListAttribute<BECA, JOVEN_NIÑO> niños;

}