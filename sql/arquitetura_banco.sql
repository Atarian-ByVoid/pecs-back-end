-- Tabela de Clinicas
CREATE TABLE Clinicas (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    EnderecoID INT,
    FOREIGN KEY (EnderecoID) REFERENCES EnderecosClinicas(ID)
);

-- Tabela de Usuarios
CREATE TABLE Usuarios (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    Email VARCHAR(100),
    Senha VARCHAR(100),
    ClinicaID INT,
    EnderecoID INT,
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID),
    FOREIGN KEY (EnderecoID) REFERENCES EnderecosUsuarios(ID)
);

-- Tabela de Endereços
CREATE TABLE Enderecos (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    Rua VARCHAR(255),
    Numero VARCHAR(10),
    Complemento VARCHAR(100),
    Cidade VARCHAR(100),
    Estado VARCHAR(100),
    CEP VARCHAR(20),
    EntidadeID INT,
    EntidadeTipo ENUM('Usuario', 'Paciente', 'Clinica'),
    FOREIGN KEY (EntidadeID) REFERENCES Usuarios(ID) ON DELETE CASCADE,
    FOREIGN KEY (EntidadeID) REFERENCES Pacientes(ID) ON DELETE CASCADE,
    FOREIGN KEY (EntidadeID) REFERENCES Clinicas(ID) ON DELETE CASCADE
);

-- Tabela de Telefones
CREATE TABLE Telefones (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    Numero VARCHAR(20),
    Tipo VARCHAR(50),
    Descricao VARCHAR(100),
    EntidadeID INT,
    EntidadeTipo ENUM('Usuario', 'Paciente', 'Clinica'),
    FOREIGN KEY (EntidadeID) REFERENCES Usuarios(ID) ON DELETE CASCADE,
    FOREIGN KEY (EntidadeID) REFERENCES Pacientes(ID) ON DELETE CASCADE,
    FOREIGN KEY (EntidadeID) REFERENCES Clinicas(ID) ON DELETE CASCADE
);

-- Tabela de Pacientes
CREATE TABLE Pacientes (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    Nome VARCHAR(100),
    DataNascimento DATE,
    Genero ENUM('Masculino', 'Feminino', 'Outro'),
    Email VARCHAR(100),
    ClinicaID INT,
    EnderecoID INT,
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID),
    FOREIGN KEY (EnderecoID) REFERENCES EnderecosPacientes(ID)
);

-- Tabela de Consultas
CREATE TABLE Consultas (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    PacienteID INT,
    MedicoID INT,
    DataHora TIMESTAMP,
    Observacoes TEXT,
    ClinicaID INT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (MedicoID) REFERENCES Usuarios(ID),
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID)
);

-- Tabela de Diagnosticos
CREATE TABLE Diagnosticos (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    ConsultaID INT,
    Descricao TEXT,
    ClinicaID INT,
    FOREIGN KEY (ConsultaID) REFERENCES Consultas(ID),
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID)
);

-- Tabela de Prescricoes
CREATE TABLE Prescricoes (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    ConsultaID INT,
    Medicamento VARCHAR(100),
    Dosagem VARCHAR(50),
    ClinicaID INT,
    FOREIGN KEY (ConsultaID) REFERENCES Consultas(ID),
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID)
);

-- Tabela de AcessoPacientes
CREATE TABLE AcessoPacientes (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    UsuarioID INT,
    PacienteID INT,
    FOREIGN KEY (UsuarioID) REFERENCES Usuarios(ID),
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID)
);

-- Tabela de AtividadesPaciente
CREATE TABLE AtividadesPaciente (
    CriadoEm TIMESTAMP,
    AlteradoEm TIMESTAMP,
    DeletadoEm TIMESTAMP,
    ID SERIAL PRIMARY KEY,
    PacienteID INT,
    DataHora TIMESTAMP,
    Tipo VARCHAR(100),
    Descricao TEXT,
    ClinicaID INT,
    FOREIGN KEY (PacienteID) REFERENCES Pacientes(ID),
    FOREIGN KEY (ClinicaID) REFERENCES Clinicas(ID)
);