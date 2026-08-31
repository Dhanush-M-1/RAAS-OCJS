n,x,y=map(int,input().split())

from math import ceil

r=ceil(n*y/100)

print(max(0,r-x))
