import sys
import math

a=int(input())

b=list(map(int,input().split()))
c=list(map(int,input().split()))
d=list(map(int,input().split()))


print(sum(b)-sum(c))
print(sum(c)-sum(d))
