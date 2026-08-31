from collections import Counter
from functools import reduce
from itertools import combinations
from operator import mul

x = int(input())

xx = x
c = Counter()
for i in range(2,int(x**0.5)+1):
    while xx%i==0:
        c[i]+=1
        xx//=i
    if xx==1:
        break

if xx>1:
    c[xx]+=1


mn, aa,bb = x, x, 1
for i in range(1,len(c)//2+1):
    for com in combinations(c.keys(),i):
        a = reduce(mul,(j**c[j] for j in com),1)
        b = x//a
        if max(a,b)<mn:
            mn,aa,bb = max(a,b),a,b

print (aa,bb)

# print(c)
