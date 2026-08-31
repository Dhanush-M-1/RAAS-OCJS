import math


n,b=map(int,input().split())
full=n
ost=0
count=0
while full>0:
    count+=full
    ost+=full
    full=0
    if ost>=b:
        full+=(ost//b)
        ost%=b
print(count)