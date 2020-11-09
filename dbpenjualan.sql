-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 28 Sep 2020 pada 15.51
-- Versi server: 10.4.11-MariaDB
-- Versi PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbpenjualan`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `spDelJual` (IN `id` VARCHAR(50))  BEGIN
	DELETE FROM detjual WHERE faktur = id;
	DELETE FROM jual WHERE faktur = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spGetAllSupplier` ()  BEGIN
SELECT * FROM supplier;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `spInsSupplier` (IN `pid` VARCHAR(5), IN `pnama` VARCHAR(20), IN `palamat` VARCHAR(30), IN `ptelp` VARCHAR(12), IN `pemail` VARCHAR(30), IN `ppic` VARCHAR(30))  begin
  insert into supplier values(pid, pnama, palamat, 
         ptelp, pemail, ppic);
END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `fCekStatus` (`id` VARCHAR(5)) RETURNS VARCHAR(20) CHARSET utf8mb4 begin
  declare stat VARCHAR(20); 
  DECLARE st INT;
  
  set st = (select stok FROM barang WHERE idbarang = id);
  
  if st > 100  then SET stat = 'berlebih';		
  ELSEIF (st > 50 and st <= 100) then SET stat = 'cukup';		
  ELSEIF (st > 10 and st <= 50) then SET stat = 'aman';	
  ELSE SET stat = 'kurang';			  	
  end if;
  
  RETURN (stat);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `idbarang` varchar(3) NOT NULL,
  `namabarang` varchar(30) DEFAULT NULL,
  `hargabeli` double DEFAULT 0,
  `hargajual` double DEFAULT 0,
  `stok` int(11) DEFAULT 0,
  `idsupplier` varchar(5) DEFAULT NULL,
  `expired` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`idbarang`, `namabarang`, `hargabeli`, `hargajual`, `stok`, `idsupplier`, `expired`) VALUES
('B01', 'Lenovo Yoga S', 5000000, 5300000, 24, 'SP007', '0000-00-00 00:00:00'),
('B02', 'Asus AMD E205', 3000000, 3300000, 15, 'SP004', '2017-12-02 00:00:00'),
('B03', 'Asus AMD E450', 4000000, 4800000, 14, 'SP002', '2017-12-02 00:00:00'),
('B04', 'Asus AMD 8', 6000000, 6500000, 24, 'SP007', '2017-12-02 00:00:00'),
('B05', 'Acer core i3', 5500000, 6000000, 4, 'SP003', '2017-12-02 00:00:00'),
('B06', 'Acer Core i5', 6500000, 7000000, 4, 'SP004', '2017-06-01 00:00:00'),
('B07', 'Acer Core i7', 9000000, 11200000, 22, 'SP002', '2017-06-01 00:00:00'),
('B08', 'Lenovo intel core', 2000000, 2300000, 2, 'SP002', '2017-06-01 00:00:00'),
('B09', 'Asus core i5', 5000000, 5300000, 15, 'SP006', '2017-06-01 00:00:00'),
('B1', 'ASUS TUF FX505GT', 16500000, 19800000, 20, 'SP006', '2021-10-03 00:00:00'),
('B10', 'Asus Core i7', 9500000, 10000000, 2, 'SP006', '2017-06-01 00:00:00'),
('B11', 'Asus intel inside', 4000000, 4400000, 11, 'SP003', '2017-01-01 00:00:00'),
('B12', 'Aser Intel inside', 3500000, 4000000, 15, 'SP006', '2017-01-01 00:00:00'),
('B13', 'Hp core i3', 4500000, 5100000, 16, 'SP006', '2017-01-01 00:00:00'),
('B14', 'ASUS TUF FX505DD', 9300000, 10299000, 20, 'SP004', '2021-10-03 00:00:00'),
('B15', 'ASUS TUF A15', 13200000, 15100000, 20, 'SP003', '2021-10-03 00:00:00'),
('B16', 'ASUS TUF FX505GT', 16500000, 19800000, 20, 'SP003', '2021-10-03 00:00:00'),
('B17', 'test', 1, 1, 1, 'SP007', '2021-01-02 00:00:00'),
('B18', 'ASUS TUF D501', 1, 1, 1, 'SP007', '2021-01-02 00:00:00');

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `idcustomer` varchar(5) NOT NULL,
  `namacustomer` varchar(20) DEFAULT NULL,
  `telpcustomer` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`idcustomer`, `namacustomer`, `telpcustomer`) VALUES
('MR001', 'Andi Ibnu Subarja', '081389889876'),
('MR002', 'Empat Sekawan PT', '021850000'),
('MR003', 'Bintang Emas PD', '021800000'),
('MR004', 'Nusa Jaya PD', '0813'),
('MR005', 'Triyani akhirina', '021870000'),
('MR006', 'Adi Perkasa', '0822'),
('MR007', 'Setia Kawan', '081286979867'),
('MR008', 'Gerai Ship', '0218768768'),
('MR009', 'Setia Kawan', '081286979867'),
('MR010', 'Gerai Ship', '0218768768'),
('MR021', 'Sudharmadji CV', '022 8769876');

--
-- Trigger `customer`
--
DELIMITER $$
CREATE TRIGGER `delBackUpCustomer` BEFORE DELETE ON `customer` FOR EACH ROW begin
	insert into customer_backup VALUES (OLD.idcustomer, OLD.namacustomer, OLD.telpcustomer);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer_backup`
--

CREATE TABLE `customer_backup` (
  `idcustomer` varchar(5) DEFAULT NULL,
  `namacustomer` varchar(20) DEFAULT NULL,
  `telpcustomer` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `customer_backup`
--

INSERT INTO `customer_backup` (`idcustomer`, `namacustomer`, `telpcustomer`) VALUES
('MR02', 'tes', '0833'),
('jl', 'kljl', '313'),
('klj', 'kljl', '34234'),
('MR004', 'Yusuf', '021860000'),
('qwe', 'asa', 'erq'),
('N09', 'ljl', 'jlk'),
('sdfas', 'sdfasdfasdf', 'asdfa'),
('AAA', 'AAA', 'AAA'),
('asdf', 'asdf', 'asdf'),
('zz', 'zz', 'z'),
('KJL', 'JLKJ', 'LKJL'),
('asdfa', 'sdfasdf', 'asdfas');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detjual`
--

CREATE TABLE `detjual` (
  `faktur` varchar(10) DEFAULT NULL,
  `idbarang` varchar(3) DEFAULT NULL,
  `qty` int(11) DEFAULT 0,
  `harga` double DEFAULT 0,
  `diskon` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `detjual`
--

INSERT INTO `detjual` (`faktur`, `idbarang`, `qty`, `harga`, `diskon`) VALUES
('FJ2002002', 'B09', 3, 5300000, 0),
('FJ2002002', 'B11', 2, 4400000, 0),
('FJ2002002', 'B12', 7, 4000000, 0),
('FJ2002002', 'B06', 4, 7000000, 0),
('FJ2002004', 'B06', 1, 7000000, 0),
('FJ2002006', 'B12', 1, 4000000, 0),
('FJ2002006', 'B10', 1, 10000000, 0),
('FJ2002005', 'B07', 1, 11200000, 0),
('FJ2002003', 'B03', 2, 4800000, 0),
('FJ2002003', 'B05', 1, 6000000, 0),
('FJ2002003', 'B07', 3, 11200000, 0),
('FJ2002003', 'B05', 1, 6000000, 50000),
('FJ2002007', 'B04', 2, 6500000, 0),
('FJ2002007', 'B03', 1, 4800000, 0),
('FJ2006001', 'B13', 2, 5100000, 0),
('FJ2006001', 'B04', 1, 6500000, 0),
('FJ2002001', 'B11', 3, 4400000, 0),
('FJ2006002', 'B10', 1, 10000000, 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `connection` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `payload` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `exception` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `jual`
--

CREATE TABLE `jual` (
  `faktur` varchar(10) NOT NULL,
  `tanggal` datetime DEFAULT NULL,
  `idcustomer` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `jual`
--

INSERT INTO `jual` (`faktur`, `tanggal`, `idcustomer`) VALUES
('FJ2002001', '2020-02-11 00:00:00', 'MR003'),
('FJ2002002', '2020-02-11 00:00:00', 'MR001'),
('FJ2002003', '2020-02-11 00:00:00', 'MR002'),
('FJ2002004', '2020-02-13 00:00:00', 'MR005'),
('FJ2002005', '2020-02-15 00:00:00', 'MR002'),
('FJ2002006', '2020-02-18 00:00:00', 'MR005'),
('FJ2002007', '2020-02-28 00:00:00', 'MR004'),
('FJ2006001', '2020-06-22 00:00:00', 'MR006'),
('FJ2006002', '2020-06-23 00:00:00', 'MR006');

-- --------------------------------------------------------

--
-- Struktur dari tabel `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data untuk tabel `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2019_08_19_000000_create_failed_jobs_table', 1);

-- --------------------------------------------------------

--
-- Struktur dari tabel `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `idsupplier` varchar(5) NOT NULL,
  `namasupplier` varchar(20) DEFAULT NULL,
  `alamatsupplier` varchar(30) DEFAULT NULL,
  `telpsupplier` varchar(12) DEFAULT NULL,
  `emailsupplier` varchar(30) DEFAULT NULL,
  `picsupplier` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`idsupplier`, `namasupplier`, `alamatsupplier`, `telpsupplier`, `emailsupplier`, `picsupplier`) VALUES
('SP002', 'Tiga Roda Bagus PD', 'Depok', '021850000', 'becak@yahoo.com', 'Rasyidah'),
('SP003', 'Batubara Corp', 'Jogjakarta', '021800000', 'batubaracorporation.com', 'Ashraf'),
('SP004', 'Indo Tiga PT', 'Depok', '021860000', 'bertiga@yahoo.com', 'Ahmad'),
('SP006', 'indah Jaya PT', 'Depok', '021880000', 'indahjaya@yahoo.com', 'Indah'),
('SP007', 'Candra Jaya PT', 'Depok', '021890000', 'candrajaya@yahoo.com', 'Candra'),
('SP010', 'Marga Jaya PT', 'Bandung', '08134563421', 'marketing@mjaya.com', 'nandi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_verified_at` timestamp NULL DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vbarangsupplier`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vbarangsupplier` (
`idbarang` varchar(3)
,`namabarang` varchar(30)
,`hargabeli` double
,`hargajual` double
,`stok` int(11)
,`expired` datetime
,`idsupplier` varchar(5)
,`namasupplier` varchar(20)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vcompletejual`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vcompletejual` (
`faktur` varchar(10)
,`tanggal` datetime
,`idcustomer` varchar(5)
,`idbarang` varchar(3)
,`namabarang` varchar(30)
,`harga` double
,`qty` int(11)
,`diskon` double
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vdetjual`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vdetjual` (
`faktur` varchar(10)
,`idbarang` varchar(3)
,`namabarang` varchar(30)
,`harga` double
,`qty` int(11)
,`diskon` double
,`jumlah` double
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `vjual`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `vjual` (
`faktur` varchar(10)
,`tanggal` datetime
,`idcustomer` varchar(5)
,`namacustomer` varchar(20)
,`total` double
);

-- --------------------------------------------------------

--
-- Struktur untuk view `vbarangsupplier`
--
DROP TABLE IF EXISTS `vbarangsupplier`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vbarangsupplier`  AS  select `barang`.`idbarang` AS `idbarang`,`barang`.`namabarang` AS `namabarang`,`barang`.`hargabeli` AS `hargabeli`,`barang`.`hargajual` AS `hargajual`,`barang`.`stok` AS `stok`,`barang`.`expired` AS `expired`,`supplier`.`idsupplier` AS `idsupplier`,`supplier`.`namasupplier` AS `namasupplier` from (`barang` left join `supplier` on(`barang`.`idsupplier` = `supplier`.`idsupplier`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vcompletejual`
--
DROP TABLE IF EXISTS `vcompletejual`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vcompletejual`  AS  select `jual`.`faktur` AS `faktur`,`jual`.`tanggal` AS `tanggal`,`jual`.`idcustomer` AS `idcustomer`,`detjual`.`idbarang` AS `idbarang`,`barang`.`namabarang` AS `namabarang`,`detjual`.`harga` AS `harga`,`detjual`.`qty` AS `qty`,`detjual`.`diskon` AS `diskon` from ((`detjual` join `barang` on(`detjual`.`idbarang` = `barang`.`idbarang`)) join `jual` on(`detjual`.`faktur` = `jual`.`faktur`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vdetjual`
--
DROP TABLE IF EXISTS `vdetjual`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vdetjual`  AS  select `detjual`.`faktur` AS `faktur`,`detjual`.`idbarang` AS `idbarang`,`barang`.`namabarang` AS `namabarang`,`detjual`.`harga` AS `harga`,`detjual`.`qty` AS `qty`,`detjual`.`diskon` AS `diskon`,(`barang`.`hargajual` - `detjual`.`diskon`) * `detjual`.`qty` AS `jumlah` from (`detjual` join `barang` on(`detjual`.`idbarang` = `barang`.`idbarang`)) ;

-- --------------------------------------------------------

--
-- Struktur untuk view `vjual`
--
DROP TABLE IF EXISTS `vjual`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vjual`  AS  select `jual`.`faktur` AS `faktur`,`jual`.`tanggal` AS `tanggal`,`jual`.`idcustomer` AS `idcustomer`,`customer`.`namacustomer` AS `namacustomer`,sum(`vdetjual`.`jumlah`) AS `total` from ((`jual` join `customer` on(`jual`.`idcustomer` = `customer`.`idcustomer`)) join `vdetjual` on(`jual`.`faktur` = `vdetjual`.`faktur`)) group by `jual`.`faktur`,`jual`.`tanggal`,`jual`.`idcustomer`,`customer`.`namacustomer` ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idbarang`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idcustomer`);

--
-- Indeks untuk tabel `detjual`
--
ALTER TABLE `detjual`
  ADD KEY `FK_detjual_jual` (`faktur`),
  ADD KEY `FK_detjual_barang` (`idbarang`);

--
-- Indeks untuk tabel `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`faktur`),
  ADD KEY `FK_jual_customer` (`idcustomer`);

--
-- Indeks untuk tabel `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`idsupplier`);

--
-- Indeks untuk tabel `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `detjual`
--
ALTER TABLE `detjual`
  ADD CONSTRAINT `FK_detjual_barang` FOREIGN KEY (`idbarang`) REFERENCES `barang` (`idbarang`),
  ADD CONSTRAINT `FK_detjual_jual` FOREIGN KEY (`faktur`) REFERENCES `jual` (`faktur`);

--
-- Ketidakleluasaan untuk tabel `jual`
--
ALTER TABLE `jual`
  ADD CONSTRAINT `FK_jual_customer` FOREIGN KEY (`idcustomer`) REFERENCES `customer` (`idcustomer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
