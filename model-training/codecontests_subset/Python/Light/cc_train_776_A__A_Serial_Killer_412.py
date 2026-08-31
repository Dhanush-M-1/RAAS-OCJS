lista = input().split()
x = int(input())
vit1 = lista[0]
vit2 = lista[1]
print(vit1, vit2)
for i in range(x):
  lista2 = input().split()
  if vit1 == lista2[0]:
    vit1 = lista2[1]
  if vit2 == lista2[0]:
    vit2 = lista2[1]
  
  print(vit1, vit2)

