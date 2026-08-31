import operator
from functools import reduce
n=input()
a=[0]*3
for i in[0,1,2]:
 a[i]=reduce(operator.xor,map(int,input().split()))
print(a[0]^a[1])
print(a[1]^a[2])

