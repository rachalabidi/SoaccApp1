<%@ page import="Entiter.Enseignant" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/CenterModal.css">
    <meta charset="ISO-8859-1">
    <title>Teacher</title>
</head>
<body>


    <div id="editEmployeeModal" class="modal fade">
        <div id="editTeacherContainer" class="modal-dialog">
            <div class="modal-content">
             
         
     
                <form action="${pageContext.request.contextPath}/editTeacher" method="post">
                  
   
   
   <%-- <label for="matricule">matricule</label>
                <input  id="matriculeInput" name="matricule" value="${teacher.matricule}" readonly> --%>

                    <div class="modal-header">
                        <h4 class="modal-title">Teacher Information</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
 
                    <div class="modal-body">
                    <input type="hidden" id="OFF" name="matricule" value="${teacher.matricule}" readonly="false">

                        <div class="form-group"> 
                                 
                        
                            <label for="situationFamille">Situation Familiale</label>
                               <select class="form-control" id="situationFamilleInput" name="situationFamille"   onchange="toggleConjointInput()" disabled>
                                   <option value="M" ${teacher.situationFamille eq 'M' ? 'selected' : ''}>Marié(e)</option>
                                   <option value="D" ${teacher.situationFamille eq 'D' ? 'selected' : ''}>Divorcé(e)</option>
                                    <option value="C" ${teacher.situationFamille eq 'C' ? 'selected' : ''}>Célibataire</option>
 <!-- Add more options as needed -->
                                 </select>
                        </div>

                        <div class="form-group">
                            <label>Conjoint</label>
                            <input type="text" class="form-control" id="conjointInput" name="conjoint" value="${teacher.conjoint}" readonly>
                        </div>

                        <div class="form-group">
                            <label>Enfants</label>
                            <input type="text" class="form-control"  id="enfantsInput" name="enfants" value="${teacher.enfants}" readonly>
                        </div>

                 <div class="form-group">
                            <label for="departementAffectationId">Departement Affectation</label>
                           <select class="form-control" id="departementAffectationIdInput" name="departementAffectationId" required disabled>
                                     <option value="1" ${teacher.getDepartement().getDepartementId() == 1 ? 'selected' : ''}>IFA</option>
                                     <option value="2" ${teacher.getDepartement().getDepartementId() == 2 ? 'selected' : ''}>TLSI</option>
                          </select>
                        </div> 

                        <div class="form-group">
                            <label for="etatActuel">Etat Actuel</label>
                              <select class="form-control" id="etatActuelInput" name="etatActuel" required disabled>
    <!-- Assuming the possible values for etatActuel are 'Active' and 'Inactive' -->
                             <option value="Active" ${teacher.etatActuel == 'Active' ? 'selected' : ''}>Active</option>
                             <option value="Inactive" ${teacher.etatActuel == 'Inactive' ? 'selected' : ''}>Inactive</option>
    <!-- Add more options as needed -->
                 </select>           
                              </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-info" onclick="enableEditing()">Edit</button>
                        <button type="submit" class="btn btn-success" style="display:none;">Save</button>
                    </div>
                </form>

            </div>
        </div>
    </div>
<!-- Include jQuery -->

<script>
    function enableEditing() {
        // Enable editing by changing input fields to readonly=false AND select fields
        $('form input').prop('readonly', false);
        $('form select[disabled]').prop('disabled', false);
        
        console.log("hey u "+document.getElementById('matriculeInput').value); 

        // Show the Save button
        $('form button[type="submit"]').show();
    }

    
    </script>
  
</body>
</html>
