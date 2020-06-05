# language: pl
Funkcja: Informacja dla podróżnych o czasie przybycia do stacji docelowej
	W celu bardziej efektywnego planowania podróży
	Jako podróżny
	Chcę wiedzieć, o której godzinie dotrę do stacji docelowej

	Szablon scenariusza: Szacowanie czasu przyjazdu
		Zakładając Następny pociąg odjeżdża o "<departure>" na lini "<line>", Chcę się dostać  z "<from>" do "<to>"

		Gdy Zapytam o godzinę przyjazdu
		Wtedy Powinienem uzyskać czas przyjazdu "<arrive>"

	Przykłady:
		| departure  | line     | from   | to      | arrive
		| 8:03       | Northern | Epping | Central | 8:48
		| 8:07       | Newcastle| Epping | Central | 8:37
		| 8:07       | Newcastle| Epping | Central | 8:37
		| 8:13       | Epping   | Epping | Central | 8:51
