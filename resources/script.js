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


function editTeacherPromotion(matricule ,dateRecrutement){
    document.getElementById('matriculeInput').value = matricule;
    
    document.getElementById('dateRecrutementid').value = dateRecrutement;
    console.log("hey rasha " +matricule);
    
    fetchNombreechelon(matricule);
   

}

