CREATE TABLE TipoUsuario(
idTipoUsuario NVARCHAR2(36) PRIMARY KEY,
TipoDeUsuario NVARCHAR2(50) NOT NULL
);
--Es un rol que están por defecto al iniciar la aplicación por primera vez.
INSERT INTO TipoUsuario (idTipoUsuario,TipoDeUsuario) VALUES('1','Administrador');
--Niveles por defecto para la expo y presentaciones
--Cocinero
--Mesero
--Recepcionista

CREATE TABLE Usuario(
idUsuario NVARCHAR2(36) PRIMARY KEY,
NombreUsuario NVARCHAR2(100) NOT NULL,
ContrasenaUsuario NVARCHAR2(64) NOT NULL,
idTipoUsuario NVARCHAR2(36) NOT NULL,

CONSTRAINT FK_idTipoUsuario_TbUsuario
FOREIGN KEY (idTipoUsuario) REFERENCES TipoUsuario (idTipoUsuario)
);

CREATE TABLE CargoEmpleado(
idCargoEmpleado NVARCHAR2(36) PRIMARY KEY,
CargoEmpleado NVARCHAR2(100) NOT NULL
);
--Es un rol que están por defecto al iniciar la aplicación por primera vez.
INSERT INTO CargoEmpleado (idCargoEmpleado,CargoEmpleado) VALUES('1','Gerente');

CREATE TABLE Empleado(
idEmpleado NVARCHAR2(36) PRIMARY KEY,
NombreEmpleado NVARCHAR2(100) NOT NULL,
ApellidoEmpleado NVARCHAR2(100) NOT NULL,
CorreoEmpleado NVARCHAR2(100) NOT NULL,
TelefonoEmpleado NVARCHAR2(9) NOT NULL,
EdadEmpleado NUMBER NOT NULL,
DUI NVARCHAR2(10) NOT NULL UNIQUE,
Foto NVARCHAR2(200) NOT NULL,
idCargoEmpleado NVARCHAR2(36) NOT NULL,
idUsuario NVARCHAR2(36) NOT NULL,

CONSTRAINT FK_idCargoEmpleado_tbEmpleado
FOREIGN KEY (idCargoEmpleado) REFERENCES CargoEmpleado(idCargoEmpleado),

CONSTRAINT FK_idUsuario_tbEmpleado
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Cliente(
idCliente NVARCHAR2(36)PRIMARY KEY,
NombreCliente NVARCHAR2(100) NOT NULL,
ApellidoCliente NVARCHAR2(100) NOT NULL,
CorreoCliente NVARCHAR2(200) NOT NULL,
DUIcliente CHAR(10) UNIQUE
);

CREATE TABLE Mesa(
idMesa INT PRIMARY KEY,
EstadoMesa NVARCHAR2(50) NOT NULL,
idCliente NVARCHAR2(36)NOT NULL,
idEmpleado NVARCHAR2(36) NOT NULL,

CONSTRAINT FK_idCliente_tbMesa
FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
CONSTRAINT FK_idEmpleado_tbMesa
FOREIGN KEY (idEmpleado) REFERENCES Empleado(idEmpleado)
); 

CREATE TABLE CategoriaProducto(
idCategoriaProducto NVARCHAR2(36)PRIMARY KEY,
CategoriaProducto NVARCHAR2(50) NOT NULL
);

CREATE TABLE Ingredientes(
idIngrediente NVARCHAR2(36)PRIMARY KEY,
NombreIngrediente NVARCHAR2(50) NOT NULL,
CantidadDisponible INT NOT NULL,
Foto NVARCHAR2(200) NOT NULL
);

CREATE OR REPLACE PROCEDURE ActualizarStockIngredientes(
    p_idIngrediente IN TYPE%NVARCHAR2,
    p_cantidadConsumida IN TYPE%INT
) 
AS
BEGIN
    UPDATE Ingredientes
    SET CantidadDisponible = CantidadDisponible - p_cantidadConsumida
    WHERE idIngrediente = p_idIngrediente;
    
    COMMIT;
END;

BEGIN
EXEC ActualizarStockIngredientes(idIngrediente, CantidadConsumida);
END;

CREATE TABLE Producto(
idProducto NVARCHAR2(36)PRIMARY KEY, 
PrecioProducto FLOAT NOT NULL,
Estado NVARCHAR2(100) NOT NULL,
NombreProducto NVARCHAR2(100) NOT NULL,
FotoProducto NVARCHAR2(300) NOT NULL,
DescripcionProducto NVARCHAR2(100) NOT NULL
);

CREATE TABLE Detalle_Producto(
idDetalle_Producto NVARCHAR2(36) PRIMARY KEY,
idProducto NVARCHAR2(36)NOT NULL,
idCategoriaProducto NVARCHAR2(36)NOT NULL,
idIngrediente NVARCHAR2(36)NOT NULL,

CONSTRAINT FK_idProducto_tbDetalle_Producto
FOREIGN KEY (idProducto) REFERENCES Producto(idProducto),
CONSTRAINT FK_idCategoriaProducto_tbDetalle_Producto
FOREIGN KEY (idCategoriaProducto) REFERENCES CategoriaProducto(idCategoriaProducto),
CONSTRAINT FK_idIngrediente_tbDetalle_Producto
FOREIGN KEY (idIngrediente) REFERENCES Ingredientes(idIngrediente)
);

--INNER JOIN De tabla producto, ingrediente y detalle_producto, para obtener los ingredientes que le pertenecen a un producto.
SELECT NombreIngrediente,CantidadDisponible,Foto FROM Detalle_Producto DP
INNER JOIN Ingredientes I ON
DP.idIngrediente = I.idIngrediente
INNER JOIN Producto P ON
DP.idProducto = P.idProducto
WHERE NombreProducto = ?;

--INNER JOIN de tabla categoria, producto y detalle producto para mostrar productos al cliente con filtros, según la categoría que escoja.
--DISTINCT se usa para evitar traer datos duplicados, ya que antes la query estaba bien pero en Detalle_Producto estaban duplicados por la cantida de ingredientes
--pero con DISTINCT solamnete nos trae un valor, que es lo que necesitamos para mostrar los productos según la categoria; Sin DISTINCT se duplican los datos.
SELECT DISTINCT PrecioProducto, Estado,NombreProducto,FotoProducto,DescripcionProducto FROM Detalle_Producto DP
INNER JOIN Producto P ON
DP.idProducto = P.idProducto
INNER JOIN CategoriaProducto CP ON
DP.idCategoriaProducto = CP.idCategoriaProducto
WHERE CategoriaProducto = ?;

CREATE TABLE EstadoPedido(
idEstadoPedido INT PRIMARY KEY,
EstadoPedido NVARCHAR2(50) NOT NULL
);

--Datos de estado predeterminados para el pedido.
--Estado de pedido N#1 será con el que se enviará el pedido al insertarlo.
INSERT INTO EstadoPedido(idEstadoPedido,EstadoPedido) VALUES(1,'En espera');
INSERT INTO EstadoPedido(idEstadoPedido,EstadoPedido) VALUES(2,'Cocinando');
INSERT INTO EstadoPedido(idEstadoPedido,EstadoPedido) VALUES(3,'Entregando');
INSERT INTO EstadoPedido(idEstadoPedido,EstadoPedido) VALUES(4,'Entregado');
INSERT INTO EstadoPedido(idEstadoPedido,EstadoPedido) VALUES(5,'Finalizado');

CREATE TABLE Pedido(
idPedido NVARCHAR2(36) PRIMARY KEY,
idMesa INT NOT NULL,
idEstadoPedido INT NOT NULL,

CONSTRAINT FK_idMesa_tbPedido
FOREIGN KEY (idMesa) REFERENCES Mesa(idMesa),
    
CONSTRAINT FK_idEstadoPedido_tbPedido
FOREIGN KEY (idEstadoPedido) REFERENCES EstadoPedido(idEstadoPedido)
);

CREATE TABLE Detalle_Pedido(
idDetalle_Pedido NVARCHAR2(36) PRIMARY KEY,
idPedido NVARCHAR2(36) NOT NULL,
idProducto NVARCHAR2(36) NOT NULL,
CantidadProducto INT NOT NULL,

CONSTRAINT FK_idPedido_tbDetalle_Pedido
FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),

CONSTRAINT FK_idProducto_tbDetalle_Pedido
FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);

CREATE TABLE Venta(
idVenta NVARCHAR2(36) PRIMARY KEY,
Fecha CHAR(10) NOT NULL,
Total FLOAT NOT NULL
);

CREATE TABLE Auditoria(
Cod NUMBER NOT NULL,
Fecha CHAR(10) NOT NULL,
Total FLOAT NOT NULL
);

CREATE SEQUENCE SEC_Auditoria
START WITH 1 
INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TRG_Auditoria
BEFORE INSERT ON Auditoria
FOR EACH ROW
BEGIN 
SELECT SEC_Auditoria.NEXTVAL INTO: NEW.Cod FROM DUAL;
END;