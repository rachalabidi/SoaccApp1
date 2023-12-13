<%@ page import="Entiter.Enseignant" %>
<%@ page import="Entiter.Departement" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Teachers Management</title>

 <!-- Include Bootstrap CSS and JS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
  <!-- Include Material Icons font from Google Fonts -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <!-- Include Font Awesome stylesheet from a CDN -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ListStyle.css">
<style>

@charset "ISO-8859-1";


body {
    color: #212121;
      background: url('${pageContext.request.contextPath}/resources/img/abstrait-numerique-grille-fond-noir.jpg') no-repeat center center fixed;
    background-size: cover;
    font-family: 'Varela Round', sans-serif;
    font-size: 14px;
}

.table-wrapper {
    background: #fff;
    padding: 10px 25px;
    margin: 10px 0;
    border-radius: 3px;
    box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
}

.table-title {
    padding-bottom: 15px;
    background: #212121;
    color: #fff;
    padding: 16px 30px;

    border-radius: 3px 3px 0 0;
}

.table-title h2 {
    margin: 5px 0 0;
    font-size: 24px;
}

.table-title .btn-group {
    float: right;
}

.table-title .btn {
    color: #fff;
    float: right;
    font-size: 13px;
    border: none;
    min-width: 50px;
    border-radius: 2px;
    border: none;
    outline: none !important;
    margin-left: 10px;
}

.table-title .btn i {
    float: left;
    font-size: 21px;
    margin-right: 5px;
}

.table-title .btn span {
    float: left;
    margin-top: 2px;
}

table.table tr th, table.table tr td {
    border-color: #e9e9e9;
    padding: 2px 15px;
    vertical-align: middle;
}

table.table tr th:first-child {
    width: 60px;
}

table.table tr th:last-child {
    width: 100px;
}

table.table-striped tbody tr:nth-of-type(odd) {
    background-color: #fcfcfc;
}

table.table-striped.table-hover tbody tr:hover {
    background: #f5f5f5;
}

table.table th i {
    font-size: 13px;
    margin: 0 5px;
    cursor: pointer;
}

table.table td:last-child i {
    opacity: 0.9;
    font-size: 22px;
    margin: 0 5px;
}

table.table td a {
    font-weight: bold;
    color: #566787;
    display: inline-block;
    text-decoration: none;
    outline: none !important;
}

table.table td a:hover {
    color: #2196F3;
}

table.table td a.edit {
    color: #FFC107;
}

table.table td a.edit2 i {
    color: #F44336;
}

table.table td i {
    font-size: 19px;
}

table.table .avatar {
    border-radius: 50%;
    vertical-align: middle;
    margin-right: 10px;
}


   
</style>
</head>
<body>
         <jsp:include page="Dashboard.jsp" />
         

  <!-- Your existing HTML code goes here -->
  <div class="container">
  <div class="table-wrapper">
    <div class="table-title">
      <div class="row">
        <div class="col-sm-6">
          <h2>Manage <b>Teacher</b></h2>
        </div>
        <div class="col-sm-6">
 
 <a href="${pageContext.request.contextPath}/addTeacher" class="btn btn-success" data-toggle="modal" data-target="#addTeacherModal">
  <i class="material-icons">&#xE147;</i> <span>Add New Teacher</span>
</a>
     </div>
      </div>
    </div>
    <table class="table table-striped table-hover">
     <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Matricule</th>
        <th scope="col">Prenom</th>
        <th scope="col"> Nom</th>
        <th scope="col">Date Recrutement</th>
        <th scope="col">Departement Affectation</th>
        <th scope="col">Situation Familiale</th>
        <th scope="col">Conjoint</th>
        <th scope="col">Enfants</th>
        <th scope="col"> Etat Actuel</th>
        
     
        <th scope="col">Actions</th>
    </tr>
</thead>
<tbody>
<c:forEach var="teacher" items="${enseignants}">

    <tr>
        <td data-label="#"> <!-- Add a 'data-label' attribute to associate with the corresponding header -->
            <span class="custom-checkbox">
                <input type="checkbox" id="checkbox1" name="options[]" value="1">
                <label for="checkbox1"></label>
            </span>
        </td>
        <td data-label="Matricule">${teacher.matricule}</td>
        <td data-label="Nom">${teacher.nom}</td>
        <td data-label="Prenom">${teacher.prenom}</td>
        <td data-label="Email">${teacher.dateRecrutement}</td>
        <td data-label="Departement Affectation">
            ${teacher.getDepartement() != null ? (teacher.getDepartement().getDepartementId() == 1 ? 'IFA' : teacher.getDepartement().getDepartementId() == 2 ? 'TLSI' : 'Unknown Department') : 'N/A'}
        
</td>
 <td data-label="Situation Familiale">${teacher.situationFamille}</td>
  <td data-label="Conjoint">${teacher.conjoint}</td>
  <td data-label="Enfants">${teacher.enfants}</td>
    <td data-label="Etat Actuel">${teacher.etatActuel}</td>
  
 
        <td data-label="Actions">
           <a href="${pageContext.request.contextPath}/updateTeacher" class="edit" data-toggle="modal" data-target="#editEmployeeModal"
   onclick="editTeacher('${teacher.matricule}', '${teacher.situationFamille}', '${teacher.conjoint}', '${teacher.enfants}', '${teacher.getDepartement().getDepartementId()}', '${teacher.etatActuel}')">
   <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>

<a href="${pageContext.request.contextPath}/updateTeacherPromotion" class="edit2" data-toggle="modal" data-target="#deleteEmployeeModal"
   onclick="editTeacherPromotion('${teacher.matricule}', '${teacher.dateRecrutement}')">
   <i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>

        </td>
    </tr>
</c:forEach>
</tbody>
     
    </table>
    
   
   
      <!-- Repeat for other cards as needed -->
    </div>
    <!-- machi lazma  -->
   
  </div>

        <jsp:include page="addTeacherModal.jsp" />
        <jsp:include page="editTeacher.jsp" />
        <jsp:include page="editTeacherPromotion.jsp" />   
          

        
</body>  
<script >
function editTeacher(matricule ,situationFamille ,conjoint ,enfants , departementAffectation_id ,etatActuel ) {
    // Set the matricule value in the edit modal
//var url = '${pageContext.request.contextPath}/getTeacherData?matricule=' + encodeURIComponent(matricule);   ,conjoint,enfants , departementAffectation_id 
//'${teacher.situationFamille}','${teacher.conjoint}','${teacher.enfants}','${teacher.departementAffectation_id}')" >
document.getElementById('OFF').value = matricule;
 console.log("here u are debugging"+matricule);
 //console.log(document.getElementById('matriculeInput').value );
 document.getElementById('OFF').textContent = matricule;

// document.getElementById('situationFamilleInput').value = situationFamille;
document.getElementById('conjointInput').value = conjoint;
 document.getElementById('enfantsInput').value = enfants;
// document.getElementById('departementAffectationIdInput').value = departementAffectation_id; 
// document.getElementById('etatActuelInput').value = etatActuel; 

 var selectElement = document.getElementById('situationFamilleInput');

// Loop through each option and set the selected attribute based on the value
for (var i = 0; i < selectElement.options.length; i++) {
  if (selectElement.options[i].value === situationFamille) {
      selectElement.options[i].selected = true;
      break;
  }

}

var selectElement = document.getElementById('departementAffectationIdInput');

//Loop through each option and set the selected attribute based on the value
for (var i = 0; i < selectElement.options.length; i++) {
if (selectElement.options[i].value == departementAffectation_id) {
   selectElement.options[i].selected = true;
   break;
}
}
var selectEtatActuel = document.getElementById('etatActuelInput');

//Assuming possible values are 'Active' and 'Inactive'
//Loop through each option and set the selected attribute based on the value
for (var i = 0; i < selectEtatActuel.options.length; i++) {
if (selectEtatActuel.options[i].value == etatActuel) {
 selectEtatActuel.options[i].selected = true;
 break;
}
}

}


const contextPath = '<%= request.getContextPath() %>';

function fetchNombreechelon(matricule) {
const xhr = new XMLHttpRequest();

const url = contextPath + '/getPromoData?matricule=' + encodeURIComponent(matricule);

xhr.onreadystatechange = function () {
    if (xhr.readyState === XMLHttpRequest.DONE) {
        if (xhr.status === 200) {
        	const responseJson = JSON.parse(xhr.responseText);
            const nombreechelon = responseJson.nombreechelon;
            
            // Use nombreechelon value
            document.getElementById('nombreechelonField').value = nombreechelon;
            console.log("yesss" + nombreechelon);
        } else {
            console.error('Failed to fetch nombreechelon');
        }
    }
};

xhr.open('GET', url, true);
xhr.send();
}
function fetchPromoData(matricule) {
    const xhr = new XMLHttpRequest();

    const url = contextPath + '/GetGradeData?matricule=' + encodeURIComponent(matricule);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                const responseJson = JSON.parse(xhr.responseText);

                // Handle the additional data fields
                const gradepromotion = responseJson.gradepromotion;
                const date = responseJson.date;

                // Use the values in your form
                document.getElementById('gradepromotionField').textContent = gradepromotion;
                document.getElementById('dateField').textContent = date;

                console.log("Received gradepromotion: " + gradepromotion);
                console.log("Received date: " + date);
            } else {
                console.error('Failed to fetch promotion data');
            }
        }
    };

    xhr.open('GET', url, true);
    xhr.send();
}


function editTeacherPromotion(matricule ,dateRecrutement){
document.getElementById('matriculeInput').value = matricule;

document.getElementById('dateRecrutementid').value = dateRecrutement;
console.log("hey rasha " +matricule);

fetchNombreechelon(matricule);
fetchPromoData(matricule)

}



</script>
</html>
