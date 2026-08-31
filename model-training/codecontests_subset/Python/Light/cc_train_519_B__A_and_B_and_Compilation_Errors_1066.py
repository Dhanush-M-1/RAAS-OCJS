n=input()
from functools import reduce as r
ll=lambda:list(map(int,input().split()))
l=r(lambda a,b:a^b,ll())
b=r(lambda a,b:a^b,ll())
c=r(lambda a,b:a^b,ll())
print(l^b)
print(b^c)