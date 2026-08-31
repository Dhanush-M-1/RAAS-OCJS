from math import *
from sys import *
n,q=map(int,stdin.readline().split())
a=list(map(int,stdin.readline().split()))
a.sort()
powers=[1]
for i in range(1,32):
    powers.append(2*powers[-1])
arr=[]
for i in range(n):
    tmp=int(log2(a[i]))
    if len(arr)==0:
        arr.append([tmp,1])
    elif arr[-1][0]==tmp:
        arr[-1][1]+=1
    else:
        arr.append([tmp,1])
for _ in range(q):
    x=int(stdin.readline())
    ver=True
    ans=0
    for i in range(len(arr)-1,-1,-1):
        if powers[arr[i][0]]<=x:
            cnt=min(x//powers[arr[i][0]],arr[i][1])
            x-=(cnt*powers[arr[i][0]])
            ans+=cnt
            if x==0:
                break
    if x==0:
        stdout.write(str(ans)+"\n")
    else:
        stdout.write("-1"+"\n")