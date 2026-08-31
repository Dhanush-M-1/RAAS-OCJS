import sys
input=lambda: sys.stdin.readline().rstrip()
import collections
n,k=map(int,input().split())
A=[int(i) for i in input().split()]
C=collections.Counter(A)
AA=sorted(C.keys())
nn=len(AA)
L=[0]
H=[0,C[AA[0]]]
haba=0
for i in range(nn-1):
  haba+=C[AA[i]]
  L.append(L[-1]+haba*(AA[i+1]-AA[i]))
  H.append(H[-1]+C[AA[i+1]])
R=[0]
haba=0
for i in range(1,nn)[::-1]:
  haba+=C[AA[i]]
  R.append(R[-1]+haba*(AA[i]-AA[i-1]))
R=R[::-1]
if C[AA[0]]>=k:
  ans1=0
else:
  ans1=R[0]-(n-k)
if C[AA[-1]]>=k:
  ans2=0
else:
  ans2=L[-1]-(n-k)
ans=min((ans1,ans2))

for i in range(1,nn-1):
  a=AA[i]
  cur=float("inf")
  if C[a]>=k:
    cur=0
  else:
    res=k-C[a]
    if H[i]>=res:
      cur1=L[i]-(H[i]-res)
    else:
      cur1=L[i]+R[i]-(n-H[i+1]-(res-H[i]))
    if n-H[i]>=k:
      cur2=R[i]-(n-H[i+1]-res)
    else:
      cur2=R[i]+L[i]-(H[i]-(k-n+H[i]))
    cur=min(cur1,cur2)
  ans=min(ans,cur)
print(ans)