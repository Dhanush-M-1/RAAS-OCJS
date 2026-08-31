import io, os
input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
import math
def function(z):
    x=int(math.log(z,2))
    for i in range(x,-1,-1):
        if lis[i]>0:
            a=power[i]
            b=z//a
            c=min(lis[i],b)
            lis[i]-=c
            z-=(a*c)
            arr[0]+=c
            if z==0:
                return True
    return False
n,q=list(map(int,input().split()))
arr=list(map(int,input().split()))
power=[]
for i in range(32):
    power.append(2**i)
coins=[0]*(32)
for i in range(n):
    temp=int(math.log(arr[i],2))
    coins[temp]+=1
for i in range(q):
    lis=[]
    for j in range(32):
        lis.append(coins[j])
    b=int(input())
    a=bin(b)[2:]
    l=len(a)
    num=[]
    p=0
    for j in range(l):
        if a[j]=="1":
            num.append(l-j-1)
            p+=1
    arr=[0]
    s=0
    for j in range(p):
        if function(power[num[j]]):
            continue
        else:
            s+=1
            break
    if s==1:
        print(-1)
    else:
        print(arr[0])