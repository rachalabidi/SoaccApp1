<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/CenterModal.css">
<style type="text/css">
@charset "ISO-8859-1";

/* addTeacherModal.css */

.modal-dialog {
    display: flex;
    align-items: center;
    justify-content: center;
}

/* If you need to center the modal header, body, and footer individually, you can use the following additional styles: */
.modal-content {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.modal-body {
    flex-grow: 1;
}

.modal .modal-dialog {
    display: flex;
    align-items: center;
    justify-content: center;
    max-width: 700px;
}

.modal .modal-header,
.modal .modal-body,
.modal .modal-footer {
    padding: 20px 30px;
}

.modal .modal-content {
    border-radius: 3px;
}

.modal .modal-footer {
    background: #ecf0f1;
    border-radius: 0 0 3px 3px;
}

.modal .modal-title {
    display: inline-block;
}

.modal .form-control {
    border-radius: 2px;
    box-shadow: none;
    border-color: #dddddd;
    width: 100%; /* Set the width to 100% */
}

.modal textarea.form-control , .modal .text{
    resize: vertical;
    width: 100%; /* Set the width to 100% */
}

.modal .btn {
    border-radius: 2px;
    min-width: 200px;
}

.modal form label {
    font-weight: normal;
}

.table-wrapper {
    overflow-x: auto;
}

.actions {
    display: flex;
    justify-content: space-between;
}

.actions a {
    text-decoration: none;
    font-weight: bold;
}

</style>
<meta charset="ISO-8859-1">
<title>Add Teacher</title>
</head>
<body>
    <div id="addTeacherModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
<form action="${pageContext.request.contextPath}/addTeacher" method="post">

        <div class="modal-header">
          <h4 class="modal-title">Add Teacher</h4>
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        </div>
        <div class="modal-body">
<div class="form-group">
    <label for="matricule">Matricule</label>
    <input type="text" class="form-control" name="matricule" id="matricule" required pattern="^\d{4}\d{4}$" title="Please enter in the format AAAANNNN" placeholder="E.g., 20231234">
</div>


  <div class="form-group">
    <label>Nom</label>
    <input type="text" class="form-control" name="nom" required>
  </div>

  <div class="form-group">
    <label>Prenom</label>
    <input type="text" class="form-control" name="prenom" required>
  </div>

  <div class="form-group">
    <label for="sexe">Sexe</label>
    <select class="form-control" id="sexe" name="sexe" required>
        <option value="F">Femme</option>
        <option value="H">Homme</option>
    </select>
</div>

  <div class="form-group">
    <label>Date de Naissance</label>
    <input type="date" class="form-control" name="dateNaissance" required pattern="\d{4}-\d{2}-\d{2}">
  </div>

  <div class="form-group">
    <label>Lieu de Naissance</label>
    <input type="text" class="form-control" name="lieuNaissance" required>
  </div>

<div class="form-group">
    <label for="situationFamille">Situation Familiale</label>
    <select class="form-control" id="situationFamille" name="situationFamille" required onchange="toggleConjointInput()">
        <option value="" disabled selected>Select one</option>
        <option value="Célibataire">Célibataire</option>
        <option value="Marié(e)">Marié(e)</option>
        <option value="Divorcé(e)">Divorcé(e)</option>
        <!-- Add more options as needed -->
    </select>
</div>

<div class="form-group" id="conjointGroup" style="display: none;">
    <label>Conjoint</label>
    <input type="text" class="form-control" name="conjoint">
</div>

  <div class="form-group">
    <label>Enfants</label>
    <input type="text" class="form-control" name="enfants" required>
  </div>

 <div class="form-group">
    <label for="dateRecrutement">Date de Recrutement</label>
    <input type="date" class="form-control" name="dateRecrutement" id="dateRecrutement" required pattern="\d{4}-\d{2}-\d{2}">
</div>


  <div class="form-group">
    <label>Diplome de Recrutement</label>
    <input type="text" class="form-control" name="diplomeRecrutementId" required pattern="^\d+_[A-Za-z0-9\s]+$" title="Please enter in the format Référence_nomDeDiplome" placeholder="E.g., Référence_nomDeDiplome">
  </div>

 <div class="form-group">
    <label for="departementAffectationId">Departement Affectation</label>
    <select class="form-control" id="departementAffectationId" name="departementAffectationId" required>
        <option value="1">IFA</option>
        <option value="2">TLSI</option>
    </select>
</div>


<div class="form-group">
    <label for="etatActuel">Etat Actuel</label>
    <select class="form-control" id="etatActuel" name="etatActuel" required>
        <option value="Active">Active</option>
        <option value="Inactive">Inactive</option>
    </select>
</div>


  <!-- Remaining HTML code for the modal -->
</div>
        <div class="modal-footer">
          <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
         <button type="submit" class="btn btn-info">Add</button>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
<script>
function toggleConjointInput() {
    var situationFamilleSelect = document.getElementById("situationFamille");
    var conjointGroup = document.getElementById("conjointGroup");

    if (situationFamilleSelect.value === "Marié(e)") {
        conjointGroup.style.display = "block";
        document.querySelector('input[name="conjoint"]').required = true;
    } else {
        conjointGroup.style.display = "none";
        document.querySelector('input[name="conjoint"]').required = false;
    }
    
}
</script>
</html>