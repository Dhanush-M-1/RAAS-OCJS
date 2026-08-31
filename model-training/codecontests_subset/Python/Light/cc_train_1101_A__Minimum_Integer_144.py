import math
q=int(input())
l=[None]*q
r=[None]*q
d=[None]*q
for x in range(q):
  l[x],r[x],d[x]=[int(y) for y in input().split()]
for x in range(q):
    if d[x]<l[x]:
        print(d[x])
    else:
       res=int(r[x]/d[x]) +1
       print(res*d[x])   