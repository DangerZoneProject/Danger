-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22-Jul-2015 às 04:43
-- Versão do servidor: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `dangerzone`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE IF NOT EXISTS `bairro` (
  `idbairro` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`idbairro`, `nome`, `cidade`, `estado`) VALUES
(1, 'Ouro Preto', 'Olinda', 'Pernambuco');

-- --------------------------------------------------------


-- TABELA USADA NO PROJETO ONLINEE PHP 

CREATE TABLE `ocorrenciaweb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `endereco` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  `latitude` float DEFAULT NULL,
  `longitude` float DEFAULT NULL,
  `tipoOcorrencia` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
--
-- Estrutura da tabela `item_de_rota`
CREATE TABLE IF NOT EXISTS `item_de_rota` (
  `iditem_de_rota` int(11) NOT NULL,
  `horario` datetime NOT NULL,
  `prioridade` int(11) NOT NULL,
  `rua_idruas` int(11) NOT NULL,
  `rota_idrota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ocorrencia`
--

CREATE TABLE IF NOT EXISTS `ocorrencia` (
  `idocorrencias` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `horario` datetime NOT NULL,
  `pontuacao` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `ocorrencia`
--

INSERT INTO `ocorrencia` (`idocorrencias`, `tipo`, `horario`, `pontuacao`) VALUES
(1, 'Roubo', '2015-05-28 08:00:00', 3),
(2, 'Homicídio', '2015-05-31 22:00:00', 5),
(3, 'Atentado Violento Ao Pudor', '2015-05-31 22:00:00', 2),
(4, 'Roubo', '2015-05-30 08:00:00', 3),
(5, 'Homicídio', '2015-05-31 23:00:00', 5),
(6, 'Atentado Violento Ao Pudor', '2015-05-29 15:00:00', 2),
(7, 'Roubo', '2015-05-30 15:00:00', 3),
(8, 'Homicídio', '2015-05-31 13:00:00', 5),
(9, 'Atentado Violento Ao Pudor', '2015-05-29 12:00:00', 2),
(10, 'Roubo', '2015-05-30 11:00:00', 3),
(11, 'Homicídio', '2015-05-31 03:00:00', 5),
(12, 'Atentado Violento Ao Pudor', '2015-05-29 11:00:00', 2),
(13, 'Roubo', '2015-05-30 12:00:00', 3),
(14, 'Homicídio', '2015-05-31 03:00:00', 5),
(15, 'Atentado Violento Ao Pudor', '2015-05-29 13:00:00', 2),
(16, 'Roubo', '2015-05-31 12:00:00', 3),
(17, 'Estupro', '2015-05-25 02:00:00', 4),
(18, 'Roubo', '2015-05-31 17:00:00', 3),
(19, 'Estupro', '2015-05-25 01:00:00', 4),
(20, 'Roubo', '2015-05-31 17:00:00', 3),
(21, 'Estupro', '2015-05-25 01:00:00', 4),
(22, 'Roubo', '2015-05-31 14:00:00', 3),
(23, 'Estupro', '2015-05-27 22:00:00', 4),
(24, 'Roubo', '2015-05-31 19:00:00', 3),
(25, 'Estupro', '2015-05-28 23:00:00', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `ronda`
--

CREATE TABLE IF NOT EXISTS `ronda` (
  `rota_idrota` int(11) NOT NULL,
  `viatura_idviatura` int(11) NOT NULL,
  `horario` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rota`
--

CREATE TABLE IF NOT EXISTS `rota` (
  `idrota` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `rua`
--

CREATE TABLE IF NOT EXISTS `rua` (
  `idruas` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `latitude` varchar(45) NOT NULL,
  `longitude` varchar(45) NOT NULL,
  `bairro_idbairro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `rua`
--

INSERT INTO `rua` (`idruas`, `nome`, `latitude`, `longitude`, `bairro_idbairro`) VALUES
(1, 'Rua Amor Perfeito', '-7.997563', '-34.864231', 1),
(2, 'Rua Atlântico', '-7.996851', '-34.863209', 1),
(3, 'Rua Guaraná', '-7.995755', '-34.862078', 1),
(4, 'Rua Cabo', '-7.998555', '-34.861928', 1),
(5, 'Rua Caroa', '-7.998484', '-34.861039', 1),
(6, 'Rua Boabá', '-7.998795', '-34.861565', 1),
(7, 'Rua Rio Formoso', '-7.997723', '-34.859573', 1),
(8, 'Rua Carmela', '-7.997984', '-34.860201', 1),
(9, 'Rua Ribeirão', '-7.997200', '-34.858978', 1),
(10, 'Rua João Fiqueiredo Maia', '-7.997520', '-34.858609', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `rua_has_ocorrencias`
--

CREATE TABLE IF NOT EXISTS `rua_has_ocorrencias` (
  `ruas_idruas` int(11) NOT NULL,
  `ocorrencias_idocorrencias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `rua_has_ocorrencias`
--

INSERT INTO `rua_has_ocorrencias` (`ruas_idruas`, `ocorrencias_idocorrencias`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(1, 11),
(2, 12),
(3, 13),
(4, 14),
(5, 15),
(6, 16),
(7, 17),
(8, 18),
(9, 19),
(10, 20),
(1, 21),
(2, 22),
(3, 23),
(4, 24),
(5, 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `viatura`
--

CREATE TABLE IF NOT EXISTS `viatura` (
  `idviatura` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `placa` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`idbairro`);

--
-- Indexes for table `item_de_rota`
--
ALTER TABLE `item_de_rota`
  ADD PRIMARY KEY (`iditem_de_rota`,`rota_idrota`), ADD KEY `fk_item_de_rota_rua1_idx` (`rua_idruas`), ADD KEY `fk_item_de_rota_rota1_idx` (`rota_idrota`);

--
-- Indexes for table `ocorrencia`
--
ALTER TABLE `ocorrencia`
  ADD PRIMARY KEY (`idocorrencias`);

--
-- Indexes for table `ronda`
--
ALTER TABLE `ronda`
  ADD PRIMARY KEY (`rota_idrota`,`viatura_idviatura`), ADD KEY `fk_rota_has_viatura_viatura1_idx` (`viatura_idviatura`), ADD KEY `fk_rota_has_viatura_rota1_idx` (`rota_idrota`);

--
-- Indexes for table `rota`
--
ALTER TABLE `rota`
  ADD PRIMARY KEY (`idrota`);

--
-- Indexes for table `rua`
--
ALTER TABLE `rua`
  ADD PRIMARY KEY (`idruas`), ADD KEY `fk_rua_bairro1_idx` (`bairro_idbairro`);

--
-- Indexes for table `rua_has_ocorrencias`
--
ALTER TABLE `rua_has_ocorrencias`
  ADD PRIMARY KEY (`ruas_idruas`,`ocorrencias_idocorrencias`), ADD KEY `fk_ruas_has_ocorrencias_ocorrencias1_idx` (`ocorrencias_idocorrencias`), ADD KEY `fk_ruas_has_ocorrencias_ruas_idx` (`ruas_idruas`);

--
-- Indexes for table `viatura`
--
ALTER TABLE `viatura`
  ADD PRIMARY KEY (`idviatura`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bairro`
--
ALTER TABLE `bairro`
  MODIFY `idbairro` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `item_de_rota`
--
ALTER TABLE `item_de_rota`
  MODIFY `iditem_de_rota` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ocorrencia`
--
ALTER TABLE `ocorrencia`
  MODIFY `idocorrencias` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `rota`
--
ALTER TABLE `rota`
  MODIFY `idrota` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rua`
--
ALTER TABLE `rua`
  MODIFY `idruas` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `viatura`
--
ALTER TABLE `viatura`
  MODIFY `idviatura` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `item_de_rota`
--
ALTER TABLE `item_de_rota`
ADD CONSTRAINT `fk_item_de_rota_rota1` FOREIGN KEY (`rota_idrota`) REFERENCES `rota` (`idrota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_item_de_rota_rua1` FOREIGN KEY (`rua_idruas`) REFERENCES `rua` (`idruas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `ronda`
--
ALTER TABLE `ronda`
ADD CONSTRAINT `fk_rota_has_viatura_rota1` FOREIGN KEY (`rota_idrota`) REFERENCES `rota` (`idrota`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_rota_has_viatura_viatura1` FOREIGN KEY (`viatura_idviatura`) REFERENCES `viatura` (`idviatura`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rua`
--
ALTER TABLE `rua`
ADD CONSTRAINT `fk_rua_bairro1` FOREIGN KEY (`bairro_idbairro`) REFERENCES `bairro` (`idbairro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `rua_has_ocorrencias`
--
ALTER TABLE `rua_has_ocorrencias`
ADD CONSTRAINT `fk_ruas_has_ocorrencias_ocorrencias1` FOREIGN KEY (`ocorrencias_idocorrencias`) REFERENCES `ocorrencia` (`idocorrencias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_ruas_has_ocorrencias_ruas` FOREIGN KEY (`ruas_idruas`) REFERENCES `rua` (`idruas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
