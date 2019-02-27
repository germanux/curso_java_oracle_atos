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
        <sql:setDataSource var="fuenteSQL" driver="org.apache.derby.jdbc.ClientDriver"
                           url="jdbc:derby://localhost:1527/UsuariosDB"
                           user="usuario" password="usuario"/>
        <sql:query dataSource="${fuenteSQL}"  var="resultListUsu">
            SELECT id, nombre, edad, email, password FROM Usuario
        </sql:query>
            <%--sql="SELECT id, nombre, edad, email, password FROM Usuario"--%>
        <div border="2">
            <c:forEach items="${resultListUsu.rows}" var="usu">
                <form action="usuarios.do" method="post" name="form_${usu.id}">                 
                    <input id="id" name="id" type="text"  size="4" readonly="true" value="${usu.id}"/>
                    <input id="nombre" name="nombre" type="text" required="true" value="${usu.nombre}"/>
                    <input id="edad" name="edad" type="number" required="true"  size="4" value="${usu.edad}"/>
                    <input id="email" name="email" type="email" required="true" value="${usu.email}"/>
                    <input id="password" name="password" type="password" required="true" value="${usu.password}"/>
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