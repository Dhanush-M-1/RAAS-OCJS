import math
from itertools import combinations
n = int(input())
a = 1
b = n
maxi = n
temp = n
l = []
count = 1
while(n%2==0):
    n=n//2
    count *=2
if(count!=1):
    l.append(count)
for j in range(3,int(math.sqrt(n))+1,2):
    count = 1
    while(n%j==0):
        n=n//j
        count = count * j
    if(count!=1):
        l.append(count)
if(n>2):
    l.append(n)

for i in range(1,len(l)):
    x = combinations(l,i)
    for k in x:
        val = 1
        for j in k:
            val *=j
        if(max(val,temp//val)<maxi):
            maxi = max(val,temp//val)
            a = val
            b = temp//val
print(a,b)
    
