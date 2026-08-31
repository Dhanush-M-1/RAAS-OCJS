x = input()

lista = []
for i in range(3):
  lista.append([])
  
for i in range(3):
  lista[i] = list(map(int,input().split()))
  
num1 = sum(lista[0]) - sum(lista[1])
num2 = sum(lista[1]) - sum(lista[2])
print (num1)
print (num2)