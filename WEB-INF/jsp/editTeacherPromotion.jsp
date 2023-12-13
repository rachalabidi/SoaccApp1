<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Teacher Promotion </title>
 <script>
        document.addEventListener('DOMContentLoaded', function () {
            // Get the elements
            const promotionType = document.getElementById('promotionId');
            const diplomeField = document.getElementById('diplomeField');
            const gradeField = document.getElementById('gradeField');
            const echlonField = document.getElementById('echlonField');
            const Recrutement = document.getElementById('Recrutementid');
            const promotionDetails = document.getElementById('promotionDetails');

            
            // Function to toggle fields based on promotion type
            function toggleFields() {
                const selectedOption = promotionType.value;
                
                promotionDetails.style.display = selectedOption === 'grade' ? 'block' : 'none';
                diplomeField.style.display = selectedOption === 'grade' ? 'block' : 'none';
                gradeField.style.display = selectedOption === 'grade' ? 'block' : 'none';
                if (selectedOption === 'grade') {
                    diplomeField.setAttribute('required', 'true');
                    gradeField.setAttribute('required', 'true');
                    echlonField.removeAttribute('required');
                } else if (selectedOption === 'echlon') {
                    echlonField.setAttribute('required', 'true');
                    diplomeField.removeAttribute('required');
                    gradeField.removeAttribute('required');
                }
                
                if (selectedOption === 'echlon') {
                    echlonField.style.display = 'block';
                    Recrutement.style.display = 'block';
                    echlonField.setAttribute('required', 'true');
                } else {
                    echlonField.style.display = 'none';
                    Recrutement.style.display = 'none';
                    echlonField.removeAttribute('required');
                }
            }
            // Function to fetch nombreechelon based on matricule
           
            // Initial call to set initial state
            toggleFields();

            // Add event listener to promotion type dropdown
            promotionType.addEventListener('change', toggleFields);
        });
    </script>
</head>
<body>
<div id="deleteEmployeeModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
      <form action="${pageContext.request.contextPath}/editTeacherPromotion" method="post">
      <input type="hidden" id="matriculeInput" name="matricule" value="${teacher.matricule}">

    <div class="modal-header">
        <h4 class="modal-title">Edit Teacher Promotion</h4>
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    </div>
    <div class="modal-body">

        <div class="form-group">
            <label for="promotionId">Choose Promotion Type</label>
            <select class="form-control" name="promotionId" id="promotionId" required>
                    <option value="" disabled selected>Select one</option>
            
                <option value="grade">Promotions en Grade</option>
                <option value="echlon">Promotions en Echelon </option>
            </select>
        </div>

        <div class="form-group" id="diplomeField">
            <label>Diplome name</label>
            <input type="text" class="form-control" name="diplomeName"  pattern="^\d+_[A-Za-z0-9\s]+$" title="Please enter in the format Référence_nomDeDiplome" placeholder="E.g., Référence_nomDeDiplome">
        </div>

        <div class="form-group" id="gradeField">
            <label for="gradenId">Grade</label>
            <select class="form-control" name="gradenId" >
            <option value="" disabled selected>Select one</option>
                <option value="Assistant">Assistant</option>
                <option value="MaitreAssistant">Maitre assistant</option>
                <option value="MaitreConférence">Maitre de conférence</option>
                <option value="Professeur">Professeur</option>
               
            </select>
        </div>
       <div id="promotionDetails" >
<div class="form-group">
        <label for="gradepromotion">Gradepromotion</label>
        <H3 value="${gradepromotion}" id="gradepromotionField" ></H3>
    </div>

 
    <div class="form-group">
        <label for="date">Date</label>
        <h3 value="${date}" id="dateField"  ></H3>
    </div></div> 

        <div class="form-group" id="Recrutementid">
            <label>date de Recrutement</label>
            <input type="date" id="dateRecrutementid" class="form-control" name="dateRecrutement" value="${teacher.dateRecrutement}"  readonly>
        </div>
        <div class="form-group" id="echlonField">
            <label>Nbr d'échlon</label>
            <input type="text" id="nombreechelonField" class="form-control" name="nbrEchlon" value="${nombreechelon}" >
        </div>
    </div>
    <div class="modal-footer">
        <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel" onclick="reloadPage()">
        <button type="submit" class="btn btn-info">Add</button>
    </div>
      </form>
    </div>
  </div>
</div>
</body>
<script>
    function reloadPage() {
        location.reload(true); // true means force reload from the server
    }
</script>
</html>