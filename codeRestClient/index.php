<?php

	$nom = "John Doe";
	$date_du_jour = date("Y-m-d");
	$message = "Salut " . $nom . ". Date: " . $date_du_jour; 

?>

<!Doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Client REST Produit</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	</head>
	<body>

		<div class="container">
			<div class="row">
				<div class="col-4"></div>
				<div class="col-6">
					<h1>Client REST Produit</h1>
					<p>
						<?php echo $message; ?>
					</p>
				</div>
				<div class="col-2"></div>
				
			</div>
			
			<div class="row">
				<table class="table table-bordered">
				  <thead class="thead-dark">
				    <tr>
				      <th class="col-2">Code</th>
				      <th class="col-8">Description</th>
				      <th class="col-2">Prix</th>
				    </tr>
				  </thead>
				  <tbody id="listeProduits">
				  	
				  	<?php /* injection dynamique des produits */ ?>

				  </tbody>
				</table>
			</div>




		</div>
		



		<script>
			$(document).ready(function() {
				// faire les traitements
				var url = 'http://localhost:8080/MesProduitServiceRest/produitWS/produits/';

				$.ajax({
					type: 'GET',
					dataType: 'json',
					url: url,
					success: function(data) {

						var contenus = "";
						for (i in data) {
							var contenu = '<tr>';
							contenu = contenu + "<td>" + data[i]['code'] + "</td>";
							contenu = contenu + "<td>" + data[i]['description'] + "</td>";
							contenu = contenu + "<td>" + data[i]['prix'] + "</td>";
							contenu = contenu + '</tr>';
							contenus = contenus + contenu;
							
						}

						$("#listeProduits").html(contenus);



						/*<tr>
					      <td>1</td>
					      <td>description</td>
					      <td>100</td>
				    	</tr>*/
					},
					error: function() {
						alert("Erreur");
					}
				});




			});

		</script>

	</body>
</html>
