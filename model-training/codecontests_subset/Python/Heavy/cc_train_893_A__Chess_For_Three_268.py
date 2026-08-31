def ingreso():
	juegos=int(input());
	while(juegos!=0):
		juegos=juegos-1;
		juego=int(input());
		comparar(juego);

def comparar(juego):
	global posibles, band;
	if(posibles.count(juego)==0):
		band="NO"
	else:
		posibles=[juego,buscar()];
	

def buscar():
	numero=0;
	global posibles;
	if(posibles.count(1)<=0):
		numero=1;
	elif(posibles.count(2)<=0):
		numero=2;
	else:
		numero=3;	
	return numero;



	

global posibles,aux,band;
band="YES";
posibles=[1,2];
aux=[1,2,3];
ingreso();
print(band);
