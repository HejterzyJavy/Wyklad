-- phpMyAdmin SQL Dump
-- version 3.5.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Czas wygenerowania: 23 Kwi 2014, 19:55
-- Wersja serwera: 5.5.21-log
-- Wersja PHP: 5.4.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Baza danych: `userdb`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `samochod`
--

CREATE TABLE IF NOT EXISTS `samochod` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `marka` varchar(30) NOT NULL,
  `model` varchar(30) NOT NULL,
  `rocznik` int(5) NOT NULL,
  `rodzaj_paliwa` varchar(30) NOT NULL,
  `moc_silnika` int(11) NOT NULL,
  `przebieg` int(11) NOT NULL,
  `pojemnosc_silnika` varchar(11) NOT NULL,
  `skrzynia_biegow` varchar(30) NOT NULL,
  `typ_nadwozia` varchar(30) NOT NULL,
  `sciezka_zdjecie` varchar(60) NOT NULL,
  `dostepnosc` int(5) NOT NULL,
  `cena_doba` int(5) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Zrzut danych tabeli `samochod`
--

INSERT INTO `samochod` (`id`, `marka`, `model`, `rocznik`, `rodzaj_paliwa`, `moc_silnika`, `przebieg`, `pojemnosc_silnika`, `skrzynia_biegow`, `typ_nadwozia`, `sciezka_zdjecie`, `dostepnosc`, `cena_doba`) VALUES
(4, 'Opel', 'Astra II', 2003, 'olej napedowy', 75, 2450111, '1686', 'Manualna', 'Kombi', 'sciezka', 1, 400),
(5, 'Porshe', 'carrera 911', 2008, 'Olej napedowy', 1111, 280000, '1111', 'Manualna', 'ffwef', 'sciezka', 1, 1000),
(7, 'qqqq', 'wwww', 23, 'Benzyna', 123, 3644, '123', 'Manualna', 'eww', '/samochody/eeee.jpg', 1, 321),
(8, 'wef', 'wwww', 333, 'Benzyna', 34, 2349, '423', 'Manualna', 'rr', 'mg/samochody/gg.jpg', 1, 456),
(9, 'Opel', 'Dobry', 1111, 'Benzyna', 999, 56766633, '4343', 'Automatyczna', 'jhg', 'img/samochody/poiu.jpg', 1, 10),
(10, 'fiat', 'bandzior', 1234, 'Olej napedowy', 4324, 234234, '234234', 'Manualna', 'sdf', 'img/samochody/sdf.jpg', 1, 234);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(12) NOT NULL DEFAULT '',
  `haslo` varchar(12) NOT NULL DEFAULT '',
  `adres` varchar(24) NOT NULL DEFAULT '',
  `kod_pocztowy` varchar(6) NOT NULL DEFAULT '',
  `telefon` varchar(12) NOT NULL DEFAULT '',
  `imie` varchar(45) DEFAULT NULL,
  `nazwisko` varchar(45) DEFAULT NULL,
  `pesel` varchar(11) NOT NULL DEFAULT '',
  `dob` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `stanowisko` int(11) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`userid`, `login`, `haslo`, `adres`, `kod_pocztowy`, `telefon`, `imie`, `nazwisko`, `pesel`, `dob`, `email`, `stanowisko`) VALUES
(1, 'gardian', 'ilovejava', 'Hen daleko', '25-002', '77788550', 'Adrian', 'Wojton', '12345678912', '2014-03-25', 'gardian@wp.pl', 0),
(2, '', '', '', '', '', 'aasd', 'asd', '', '2014-03-04', 'teo.grafik@gmail.com', 0),
(3, 'sada', 'sad', 'asda', 'asd', 'asda', 'asd', 'asda', 'asda', '2014-03-04', 'teo.grafik@gmail.com', 0),
(4, 'asd', 'asdad', 'asdasd', 'asasd', '23123', 'weddqw', 'wdwed', '1231234', '2014-03-04', 'gardian92@o2.pl', 0),
(5, '', '', '', '', '', '', '', '', '2014-03-18', 'fsdf', 0),
(6, 'gardian91', 'aaaa', 'sssd', 'dddd', 'asd', 'asdasd', 'asdasd', 'asdasd', '2014-03-04', 'asdasd', 0),
(7, 'dsfsdf', 'sdfsdfsdfsdf', 'sdfsdfsdfs', 'dsfsdf', 'sdfsdf', 'sdfsdf', 'sdfsfd', 'sdfsdf', '2014-03-03', 'fsdf', 0),
(8, 'sdf', 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sdfsdf', 'sdfgdsfg', 'sdfsdf', '2014-03-11', 'fsdf', 0),
(9, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '2014-03-05', 'a', 0),
(10, 'asdNOWE', 'asdad', 'asd', 'asd', '123', 'sdf', 'sdf', '123', '2014-04-16', 'gardian92@o2.pl', 0),
(11, 'gracjan', 'roztocki', 'asdads', 'jhkjn', 'kjn', 'kjnkj', 'kjn', 'kkjn', '2014-04-17', 'gardian92@o2.pl', 0),
(12, 'x', 'x', 'Hen daleko', '25-002', '77788550', 'Adrian', 'Wojton', '12345678912', '2014-03-25', 'gardian@wp.pl', 1);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `wypozyczenie`
--

CREATE TABLE IF NOT EXISTS `wypozyczenie` (
  `id_wypozyczenie` int(11) unsigned NOT NULL,
  `id` int(11) unsigned NOT NULL,
  `userid` int(11) unsigned NOT NULL,
  `do_zaplaty` int(11) unsigned NOT NULL,
  `data_wypozyczenia` date NOT NULL,
  `data_zwrotu` date NOT NULL,
  `status` varchar(30) NOT NULL,
  `opis` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_wypozyczenie`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Zrzut danych tabeli `wypozyczenie`
--

INSERT INTO `wypozyczenie` (`id_wypozyczenie`, `id`, `userid`, `do_zaplaty`, `data_wypozyczenia`, `data_zwrotu`, `status`, `opis`) VALUES
(1, 1, 1, 1200, '2019-09-04', '2019-09-04', 'oczekujace na akceptacje', NULL),
(2, 1, 1, 2000, '3914-07-22', '3914-07-22', 'oczekujace na akceptacje', NULL),
(4, 1, 1, 3333, '3914-07-22', '3914-07-22', 'oczekujace na akceptacje', NULL),
(5, 1, 1, 1111, '1914-08-11', '1914-08-11', 'oczekujace na akceptacje', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
