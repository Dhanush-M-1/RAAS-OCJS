from math import sqrt
from math import inf

def sub(n):
  b=0
  barr=[]
  while(b<(1<<n)):
    #print(b)
    arr=[0]*n
    for i in range(n):
      if (b&(1<<i)):
        arr[i]=1
    barr+=[arr]
    #print(arr)
    b+=1
  return barr

def pf(n):
  if n==1:
    return [1]
  arr=[]
  x=1
  if n%2==0:
    while(n%2==0):
      n=n//2
      x=x*2
    arr+=[x]
  for i in range(3,int(sqrt(n))+1,2):
    x=1
    if (n%i==0):
      while(n%i==0):
        n=n//i
        x=x*i
      arr+=[x]
  if n!=1:
    arr+=[n]
  return arr

x=int(input())
parr=pf(x)
n=len(parr)
mini=inf
barr=sub(n)
sol=[]
for i in range(len(barr)):
  a=1
  b=1
  for j in range(n):
    if barr[i][j]==0:
      a=a*parr[j]
    else:
      b=b*parr[j]
  #print(a,b)
  m=max(a,b)
  if m<mini:
    mini=m
    sol=[a,b]
#print(mini)
print(sol[0],sol[1])