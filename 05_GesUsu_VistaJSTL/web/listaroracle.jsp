<%-- 
    Document   : index
    Created on : 21-feb-2019, 20:42:40
    Author     : IEUser
--%>
<%@include file="head.jsp" %>
<html>
    <%= head() %>
    <body>
        <!--  RECORDAR EN SQL DATASOURCE, QUE HAY QUE USAR EL ATRIBUTO sql="..."-->
        <%@include file="header.jsp" %>
        <h1>Todos los usuarios SQL</h1>
        <sql:setDataSource var="fuenteSQL" driver="oracle.jdbc.driver.OracleDriver"
                           url="jdbc:oracle:thin:@localhost:1521:XE"
                           user="system" password="oracle"/>
        <form action="" method="GET">
            <INPUT type="number" id="nota_min" name="nota_min"/>
            <input type="submit" value="CONSULTAR" />
        </form>
        <c:choose>
            <c:when test="${empty param.nota_min}">
                No hay minimo
                <sql:query dataSource="${fuenteSQL}"  var="resultListUsu">
                    SELECT id, nombre, edad, nota FROM Usuario
                </sql:query>
            </c:when>
            <c:otherwise>
                Nota minima: ${param.nota_min}
                <sql:query dataSource="${fuenteSQL}"  var="resultListUsu">
                    SELECT id, nombre, edad, nota FROM Usuario WHERE nota >= ${param.nota_min}
                </sql:query>
            </c:otherwise>
        </c:choose>
            <%--sql="SELECT id, nombre, edad, email, password FROM Usuario"--%>
        <div border="2">
            <c:forEach items="${resultListUsu.rows}" var="usu">
                <form action="usuarios.do" method="post" name="form_${usu.id}">                 
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="${usu.id}"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="${usu.nombre}"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="${usu.edad}"/>
                    <input id="nota" name="nota" type="number" value="${usu.nota}"/>
                    <input class="method" id="method" name="method" type="text" size="4" readonly="true" value="PUT"/>
                    
                    <input type="submit" value="EDIT" 
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='PUT'; })"/>
                    <input type="submit" value="ELIM"                           
                           onclick="Array.from(document.getElementsByClassName('method')).forEach((thisInput) => { thisInput.value='DELETE'; })"/><br/>
                </form>
            </c:forEach>
        </div>
    </body>
</html>