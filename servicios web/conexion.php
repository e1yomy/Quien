<?php
	class conexion
	{
		private $servidor="mysql.hostinger.mx";
		private $contrasena="qwert12345";
		private $usuario="u177163540_root";
		private $BD="u177163540_quien";		
		
		//Se conecta a la base de datos especificada
		public function conectarse() 
		{ 
			try{
				if (!($link=new PDO("mysql:host=$this->servidor; dbname=$this->BD", $this->usuario, $this->contrasena))) 	
				{ 
					echo "Error al intentar conectarse a la base de datos."; 
					exit(); 
				} 
			}catch(PDOException $e){
				echo "ERROR: " . $e->getMessage();
			}
			return $link; 
		} 
		//Se desconecta de la base de datos
		public function desconectarse($link) { 
			$link = null;  
		}		
		//Método que regresa un arreglo como resultado a una consulta a la base de datos
		public function Consultar($query)
		{
			$link=$this->conectarse();//Manda llamar al metodo conectarse de donde le regresa el "link" de conexion a la BD
			$resultado = $link->query($query);//Se ejecuta la consulta
			//$this->desconectarse($link);//se desconecta de la base de datos
			return $resultado;//regresa el resultado
		}

		
		public function Ejecutar($query)
		{
			$link=$this->conectarse();
			if($link->query($query))
			{
				$this->desconectarse($link);
				return true;
			}
			else
			{
				$this->desconectarse($link);
				return false;
			}
			
			return $resultado;
		}
			
	}
?>