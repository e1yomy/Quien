<?php
/**
 * Insertar un nuevo alumno en la base de datos
 */
require 'eventos.php';
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Decodificando formato Json
    $body = json_decode(file_get_contents("php://input"), true);
    // Insertar Alumno
    $retorno = Alumnos::insert(
        $body['id'],
        $body['usuario'],
          $body['fechai'],
          $body['horai'],
          $body['fechaf'],
          $body['ciudad'],
          $body['lugar'],
          $body['latitud'],
          $body['longitud'],
          $body['descripcion'],
          $body['disponibilidad']);


    if ($retorno) {
        $json_string = json_encode(array("estado" => 1,"mensaje" => "Creacion correcta"));
		echo $json_string;
    } else {
        $json_string = json_encode(array("estado" => 2,"mensaje" => "No se creo el registro"));
		echo $json_string;
    }
}
?>