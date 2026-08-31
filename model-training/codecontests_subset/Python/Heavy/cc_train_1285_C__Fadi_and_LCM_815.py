t = int(input())
contador = 0
avance = int(t**0.5)
chico = 1
grande = t
mini = []

def mcd(a, b):
       while b:
           a, b = b, a%b
       return a

def mcm(a,b):
    return int(a*b/mcd(a,b))

while (avance > 1) and (contador == 0) :              #### considerá que si lo hacias a lo bruto sin la raiz, l orden se te va a la mierda, y se pasa del segundo
    if t%avance == 0:
        chico = avance
        grande = int(t/chico)
        if mcd(chico,grande) == 1:
            contador += 1
        elif len(mini) == 0:
            mini.append(chico)
            mini.append(grande)
        else:
            for i in mini:
                if mcm(i,grande) == t:
                    chico = i
                    contador += 1
                    break
    avance -= 1        
    
if contador == 0:
    print(1,t)
else:
    print(chico,grande)
