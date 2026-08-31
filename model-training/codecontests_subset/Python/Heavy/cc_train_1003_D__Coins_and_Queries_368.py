from math import *
from sys import *
n,q=map(int,stdin.readline().split())
a=list(map(int,stdin.readline().split()))
powers=[int(pow(2,i)) for i in range(32)]
arr=[0]*32
for i in range(n):
    arr[int(log2(a[i]))]+=1
for _ in range(q):
    x=int(stdin.readline())
    ver=True
    ans=0
    for i in range(len(arr)-1,-1,-1):
        if arr[i]!=0 and powers[i]<=x:
            cnt=min(x//powers[i],arr[i])
            x-=(cnt*powers[i])
            ans+=cnt
            if x==0:
                break
    if x==0:
        stdout.write(str(ans)+"\n")
    else:
        stdout.write("-1"+"\n")