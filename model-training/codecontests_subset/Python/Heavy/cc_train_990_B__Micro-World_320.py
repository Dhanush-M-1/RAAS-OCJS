
from bisect import *

from collections import defaultdict

n,k = map(int,input().split())

l = list(map(int,input().split()))

l.sort()

hash = defaultdict(int)

for i in l:
    hash[i]+=1

la = list(set(l))
la.sort()
count = 0
# print(la)
yo = set()
for j,i in enumerate(la):

    z1 = len(la)-j-1
    if z1>0:
        if i+k in hash:
            yo.add(j)

            count+=1
            continue
        else:
            z2 = bisect_right(la,i+k)

            if z2>j+1 :

                yo.add(j)
                count+=1

ans = 0

for i in range(len(la)):
  if i not in yo:
    ans+=hash[la[i]]

print(ans)





