 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/Ecart/home">Ecart</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
           <!-- each <li> </li> is one menu option -->
        <li class="active"><a href="/Ecart/home">Home</a></li>
        <!-- <li class="dropdown"> is used to create a menu option which will have sub menu -->
        <li class="dropdown">
        
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
         <!-- <ul class="dropdown-menu">  is used to create the sub menu items -->
          <ul class="dropdown-menu">
          
          <!-- display category names as menu option  -->
           <c:forEach items="${categoryList}" var="category">
            <li><a href="${pageContext.request.contextPath}/showProductsByCategory/${category.categoryId}">${category.categoryName}</a></li>
             </c:forEach>
          </ul>
        </li>
        <security:authorize access="hasRole('ROLE_ADMIN')">
        <li><a href="#">Manage Product</a></li>
        <li><a href="#">Manage Category</a></li>
        </security:authorize>
        
        
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${pageContext.request.userPrincipal.name==null}">
        <li><a href="${pageContext.request.contextPath}/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name==null}">
        
        <li><a href="${pageContext.request.contextPath}/loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
      <c:if test="${pageContext.request.userPrincipal.name!=null}">
        
        <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </c:if>
      
      </ul>
    </div>
  </div>
</nav>