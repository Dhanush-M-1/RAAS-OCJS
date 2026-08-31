from sys import exit
from collections import Counter
n=int(input())
v1=[int(x) for x in input().split()]
v2=[int(x) for x in input().split()]
v3=[int(x) for x in input().split()]
temp=list((Counter(v1)-Counter(v2)).elements())
temp1=list((Counter(v2)-Counter(v3)).elements())
print(''.join(str(x) for x in temp))
print(''.join(str(x) for x in temp1))