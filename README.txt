Despa Diana-Alexandra 321CA

Tema 4 - Calculator de buzunar.

	In implementarea temei, am utilizat scheletul de cod atasat enuntului si algoritmul descris in cel de-al doilea link de la referinte, referitor la constructia unui arbore de parsare, cu modificarile de rigoare.
	
	Algoritm
	Folosesc o stiva de operatori si o stiva de operanzi pentru constructia arborelui de parsare.
	Sirul de caractere primit ca parametru de catre functia eval din clasa ExpressionParser este impartit in token-i. Apoi, fiecare token este verificat daca este operator sau operand. In caz ca este operand, se creeaza un nod cu valoarea lui si cu index-ul token-ului in cadrul sirului si nodul este pus in stiva de operanzi. In caz ca token-ul este operator, se creeaza un nou nod in fuctie de tipul acelui operator cu ajutorul unui factory de noduri (clasa NodeFactory - metoda newNode), avand un index corespunzator. 
	Mai departe, acest nod trebuie introdus in stiva de operatori, dar doar in anumite conditii. Daca stiva este vida, sau daca nodul este o paranteza deschisa, el este introdus in stiva. Daca nodul este o paranteza inchisa, se scot operatori din stiva si cate unul sau doi operanzi din stiva lor, in functie de tipul de operator, iar cu acestia se creeaza un subarbore care este apoi pus in stiva operanzilor. Acest proces se repeta recursiv pana cand ultimul nod extras din stiva de operatori este unul cu paranteza deschisa. Atunci nu se mai introduce paranteza inchisa in stiva.
	Altfel, daca nodul ce urmeaza sa fie introdus este un nod exponential care urmeaza unuia de acelasi tip, sau daca prioritatea operatorului din nod este mai mare decat prioritatea nodului din varful stivei, el este adaugat la stiva.
	Altfel, se realizeaza un proces asemanator celui de la cazul paranteza inchisa: se extrag operatori si operanzi cu care se creeaza subarbori. Acest proces se opreste cand stiva operatorilor se goleste, sau in unul dintre cazurile din paragraful anterior("^" consecutive sau prioritate superioara). La final, nodul operator este adaugat la stiva.
	Cand parsarea expresiei se termine, se verifica daca au mai ramas operatori in stiva, iar in caz afirmativ, se formeaza cu ei noi subarbori pana la formarea arborelui complet in stiva de operanzi. Parcurgerea si evaluarea arborelui se realizeaza cu un vizitator, rezultatul intors de o functie a acestuia fiind rezultatul final, intors si de functia eval.

	Pattern-ul Vizitator
	Am implementat cate o clasa pentru fiecare tip de nod: operator si toti operanzii. Aceste clase mostenesc o clasa de baza - BinaryTreeNode, care contine informatiile unui nod, getteri si setteri pentru aceste informatii, si care implementeaza interfata Visitable. Aceasta permite tuturor obiectelor de tip nod sa accepte un vizitator.
	Clasa TreeEvalVisitor implementeaza interfata Visitor si metodele ei pentru fiecare tip de nod. Aceste metode calculeaza in variabila rootVal rezultatul operatiei format cu nodul radacina si subarborii sai.

	Gasirea exceptiilor
	Clasele SyntacticException si EvaluatorException se ocupa de definirea exceptiilor de tip sintactic si respectiv de evaluare sau matematice. Primele sunt verificate in clasa ExpressionParser, pe masura ce este procesata expresia, si atunci cand se creeaza un nou nod operand cu NodeFactory, iar cele din urma sunt verificate in TreeEvalVisitor, pe masura ce sunt evaluati subarborii.