
from collections import defaultdict

def List(): return list(map(int,input().split()))

n = int(input())
l1 = List()
l2 = List()
l3 = List()


d1= defaultdict(list)
d2 = defaultdict(list)
d3 = defaultdict(list)

for i in range(n):
    d1[l1[i]].append(1)

#print(d1)

for i in range(n - 1):
    d2[l2[i]].append(1)

for i in range(n - 2):
    d3[l3[i]].append(1)

#print(d2)
#print(d3)

for i in l1 :
    if d1[i] != d2[i]:
        d2[i].append(1)
        d3[i].append(1)
        print(i)
        break

for i in l1:
    if d1[i] != d3[i]  :
        print(i)
        break



