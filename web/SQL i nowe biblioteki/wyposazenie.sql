SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `wyposazenie` (
  `wyposazenieId` int(11) unsigned NOT NULL,
  `naped4x4` TINYINT(1) NOT NULL,
  `centralny_zamek` TINYINT(1) NOT NULL,
  `czujnik_deszczu` TINYINT(1) NOT NULL,
  `czujnik_parkowania` TINYINT(1) NOT NULL,
  `el_lusterka` TINYINT(1) NOT NULL,
  `el_szyby` TINYINT(1) NOT NULL,
  `klimatyzacja` TINYINT(1) NOT NULL,
  `komputer_pokladowy` TINYINT(1) NOT NULL,
  `pod_przed_szyba` TINYINT(1) NOT NULL,
  `pod_fotele` TINYINT(1) NOT NULL,
  `radio` TINYINT(1) NOT NULL,
  `system_nawigacji` TINYINT(1) NOT NULL,
  `skorzana_tapicerka` TINYINT(1) NOT NULL,
  `tempomat` TINYINT(1) NOT NULL,
  `wsp_kierownicy` TINYINT(1) NOT NULL,
  `kontrola_antyposlizgowa` TINYINT(1) NOT NULL,
  `autoalarm` TINYINT(1) NOT NULL,
  `blok_skrzyni_biegow` TINYINT(1) NOT NULL,
  `esp` TINYINT(1) NOT NULL,
  `immobiliser` TINYINT(1) NOT NULL,
  `poduszki_powietrzne` TINYINT(1) NOT NULL,
  `alufelgi` TINYINT(1) NOT NULL,
  `bagaznik_na_dachu` TINYINT(1) NOT NULL,
  `hak` TINYINT(1) NOT NULL,
  `ksenony` TINYINT(1) NOT NULL,
  `przyc_szyby` TINYINT(1) NOT NULL,
  `szyberdach` TINYINT(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1; 

INSERT INTO wyposazenie (wyposazenieId,naped4x4,centralny_zamek,czujnik_deszczu,czujnik_parkowania,el_lusterka,el_szyby,klimatyzacja,komputer_pokladowy,pod_przed_szyba,pod_fotele,radio,system_nawigacji,skorzana_tapicerka,tempomat,wsp_kierownicy,kontrola_antyposlizgowa,autoalarm,blok_skrzyni_biegow,esp,immobiliser,poduszki_powietrzne,alufelgi,bagaznik_na_dachu,hak,ksenony,przyc_szyby,szyberdach)
VALUES (1,0,1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)