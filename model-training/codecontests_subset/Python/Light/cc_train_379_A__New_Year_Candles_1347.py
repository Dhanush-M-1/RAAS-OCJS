a,b=map(int,input().split())
s=0
c=0
from math import floor
new=a
old=c
while new>0:
    s=s+new
    old=old+new
    new=0
    new=floor(old/b)
    old=old-b*new
print(s)
    
