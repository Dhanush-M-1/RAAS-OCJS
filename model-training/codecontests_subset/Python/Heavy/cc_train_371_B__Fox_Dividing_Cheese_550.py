from collections import Counter
import math
def primeFactors(n):
  A=[]
  while n % 2 == 0: 
    A.append(2) 
    n = n / 2
  for i in range(3,int(math.sqrt(n))+1,2): 
    while n % i== 0: 
      A.append(i) 
      n = n / i 
  if n > 2: 
    A.append(n)
  return Counter(A)
a,b=map(int,input().split())
DictA=primeFactors(a)
DictB=primeFactors(b)
x=abs(DictA[2]-DictB[2])
y=abs(DictA[3]-DictB[3])
z=abs(DictA[5]-DictB[5])
S=x+y+z
DictA[2]=0
DictB[2]=0
DictA[3]=0
DictB[3]=0
DictA[5]=0
DictB[5]=0
if DictA==DictB:
  print(S)
else:
  print(-1)

