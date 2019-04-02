package acoes;

import acoes.BECA;
import acoes.CASA_POPULORUM;
import acoes.CCJ;
import acoes.USUARIO;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T00:11:56")
@StaticMetamodel(JOVEN_NIÑO.class)
public class JOVEN_NIÑO_ { 

    public static volatile SingularAttribute<JOVEN_NIÑO, String> Nombre;
    public static volatile SingularAttribute<JOVEN_NIÑO, Date> FechaNacimiento;
    public static volatile SingularAttribute<JOVEN_NIÑO, String> Apellido2;
    public static volatile SingularAttribute<JOVEN_NIÑO, String> Apellido1;
    public static volatile ListAttribute<JOVEN_NIÑO, BECA> becas;
    public static volatile SingularAttribute<JOVEN_NIÑO, String> Nacionalidad;
    public static volatile SingularAttribute<JOVEN_NIÑO, String> Descripcion;
    public static volatile SingularAttribute<JOVEN_NIÑO, Long> id;
    public static volatile SingularAttribute<JOVEN_NIÑO, CCJ> ccj;
    public static volatile SingularAttribute<JOVEN_NIÑO, CASA_POPULORUM> cp;
    public static volatile SingularAttribute<JOVEN_NIÑO, USUARIO> padrino;

}