from sys import stdin
import math
A = list(map(int,stdin.readline().split()))
n = A[0]
k = A[1]
oneone=list()
onezero=list()
zeroone=list()

for t in range(0,n):
    B = list(map(int,stdin.readline().split()))
    if B[1]==1 and B[2]==1:
        oneone.append(B[0])
    elif B[1]==1 and B[2]==0:
        onezero.append(B[0])
    elif B[1]==0 and B[2]==1:
        zeroone.append(B[0])

zeroone.sort()
onezero.sort()
ans=0
DD=list()

for K in range(0,min(len(zeroone),len(onezero))):
       DD.append(zeroone[K]+onezero[K])

oneone=oneone+DD
oneone.sort()
QQ=0

if len(oneone)<k:
       print(-1)
       QQ=1
else:
   for t in range(0,k):
          ans+=oneone[t]

if QQ==0:
   print(ans)