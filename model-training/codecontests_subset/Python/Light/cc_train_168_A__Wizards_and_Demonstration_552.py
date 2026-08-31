from math import ceil
a=list(map(int,input().split()))
print(max(0,ceil(a[0]*a[2]/100-a[1])))
