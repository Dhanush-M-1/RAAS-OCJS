numErros = int(input())
erros = input().split()
firstComp = input().split()
secondComp = input().split()

erros.sort()
firstComp.sort()
secondComp.sort()

erro1 = ""
erro2 = ""
achei1 = False
achei2 = False
for i in range(numErros - 1):
  if(not(achei1) and erros[i] != firstComp[i]):
    erro1 = erros[i]
    achei1 = True
  if(not(achei2) and i < numErros - 2 and firstComp[i] != secondComp[i]):
    erro2 = firstComp[i]
    achei2 = True
  if(achei1 and achei2):
    break

if(erro1 == ""):
  erro1 = erros[-1]
if(erro2 == ""):
  erro2 = firstComp[-1]

print(erro1)
print(erro2)