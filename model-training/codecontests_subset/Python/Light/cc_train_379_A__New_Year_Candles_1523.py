licznik = 0
def robienie(a,b):
    d = a - b*(a//b)
    c = a//b
    global licznik
    if c>0:
        licznik+=c
        return robienie(c+d,b)
    else: return licznik
x = input()
lista = x.split(" ")
wynik = int(lista[0]) + robienie(int(lista[0]),int(lista[1]))
print(wynik)