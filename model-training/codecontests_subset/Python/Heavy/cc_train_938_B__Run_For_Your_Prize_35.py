class food():
    def __init__(self):
        x = True

n = int(input())
prices = [int(i) for i in input().split()]

verificador = [None]*1000000

for i in prices:
    verificador[i-1] = food()

pEu = 0
pAmigo = 1000000 - 1
tempo = 0

if(type(verificador[pEu]) is food):
    n-=1

if(type(verificador[pAmigo]) is food):
    n-=1

while( n > 0 ):
    pEu += 1
    pAmigo -= 1
    tempo +=1
    if(type(verificador[pEu]) is food):
        n-=1
    if(type(verificador[pAmigo]) is food):
        n-=1

print(tempo)


    

