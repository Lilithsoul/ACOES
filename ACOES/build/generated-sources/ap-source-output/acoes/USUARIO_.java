package acoes;

import acoes.JOVEN_NIÑO;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-03T00:11:56")
@StaticMetamodel(USUARIO.class)
public class USUARIO_ { 

    public static volatile SingularAttribute<USUARIO, String> Nombre;
    public static volatile SingularAttribute<USUARIO, Date> FechaNacimiento;
    public static volatile SingularAttribute<USUARIO, String> Apellido2;
    public static volatile SingularAttribute<USUARIO, String> User_name;
    public static volatile SingularAttribute<USUARIO, String> Apellido1;
    public static volatile SingularAttribute<USUARIO, String> Telefono;
    public static volatile ListAttribute<USUARIO, JOVEN_NIÑO> apadrinados;
    public static volatile SingularAttribute<USUARIO, String> NIF;
    public static volatile SingularAttribute<USUARIO, Long> id;
    public static volatile SingularAttribute<USUARIO, String> email;
    public static volatile SingularAttribute<USUARIO, String> Password;

}