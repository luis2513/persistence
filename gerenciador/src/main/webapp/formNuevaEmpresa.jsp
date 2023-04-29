<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/nuevaEmpresa" var="LinkServLetNuevaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


      <form action="${ LinkServLetNuevaEmpresa }" method="post">
      
           Nombre Empresa : <input type="text" name="nombre"/> 
           Fecha Abertura : <input type="text" name="fecha"/> 
           
           <input type="submit"/>
      
      </form>
</body>
</html>