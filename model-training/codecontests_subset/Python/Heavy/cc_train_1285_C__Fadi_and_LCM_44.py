from collections import defaultdict
from itertools import combinations

def prime_factor(num):
    c = defaultdict(int)
    while not num%2:
        c[2]+=1
        num//=2
    for i in range(3,int(num**(0.5))+1,2):
        while not num%i:
            c[i]+=1
            num//=i
    if num>2:
        c[num]+=1
    l = [1]
    for i,j in c.items():
        l.append(pow(i,j))
    return l

def multi(lis):
    curr = 1
    for i in lis:
        curr*=i
    return curr

x = int(input())
l = prime_factor(x)
minim = (1,x)
for i in range(1,(len(l))//2+1):
    for lis in combinations(l,i):
        v = multi(lis)
        w = x//v
        if max(minim)>max(v,w):
            minim = (v,w)
print(*minim)
