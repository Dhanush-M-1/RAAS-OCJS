n=int(input())
from collections import *
l=[]
for _ in range(3):
    l.append(input().split())
print(*list((Counter(l[0])-Counter(l[1])).keys()))
print(*list((Counter(l[1])-Counter(l[2])).keys()))

    
    
