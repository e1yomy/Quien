<?php
/**
 * Obtiene todas las alumnos de la base de datos
 */
require 'evento.php';
if ($_SERVER['REQUEST_METHOD'] == 'GET') {
    // Manejar petición GET
    $evento = evento::getAll();
    if ($eventos) {
        $datos["estado"] = 1;
        $datos["evento"] = $evento;
        print json_encode($datos);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Ha ocurrido un error"
        ));
    }
}
