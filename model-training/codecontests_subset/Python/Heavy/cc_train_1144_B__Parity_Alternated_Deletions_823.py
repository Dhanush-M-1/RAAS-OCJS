par = []
impar = []
tam_par = 0
tam_impar = 0
res = 0
n = int(input())
s = input()
s = list(map(int,s.split()))

for i in range(0,n):
  if(s[i]%2):
    impar.append(s[i])
    tam_impar +=1
  else:
    par.append(s[i])
    tam_par += 1


if(abs(tam_impar-tam_par) == 0 or abs(tam_impar-tam_par) ==1):
  res = 0
else:
  if((tam_impar-tam_par)< 0):
    ##par é maior
    par.sort()
    for i in range(0,(tam_par-tam_impar)-1):
      res += par[i]
  else:
    ##impar é maior
    impar.sort()
    for i in range(0,(tam_impar-tam_par)-1):
      res += impar[i]
print(res)