from collections import Counter
n=int(input())
a=[int(x) for x in input().split()]
b=[int(y) for y in input().split()]
c=[int(z) for z in input().split()]
res1=abs(sum(a)-sum(b))
res2=abs(sum(b)-sum(c))
print(res1)
print(res2)