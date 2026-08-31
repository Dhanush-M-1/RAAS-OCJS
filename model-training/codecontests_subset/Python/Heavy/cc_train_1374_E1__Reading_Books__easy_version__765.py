import sys
from collections import Counter as CO
input=sys.stdin.readline
from collections import defaultdict as dd
n,k=map(int,input().split())
arr=[]
brr=[]
both=[]
for _ in range(n):
    t,a,b=map(int,input().split())
    if(a==1 and b==1):
        both+=[t]
    elif(a==1):
        arr+=[t]
    elif(b==1):
        brr+=[t]
ans=[]
both.sort(reverse=True)
arr.sort(reverse=True)
brr.sort(reverse=True)
for i in range(k):
    if(len(both)>0 and min(len(arr),len(brr))>0):
        if(both[-1]<arr[-1]+brr[-1]):
            ans+=[both.pop()]
        else:
            ans+=[arr.pop()+brr.pop()]
    elif(len(both)==0 and min(len(arr),len(brr))>0):
        ans+=[arr.pop()+brr.pop()]
    elif(len(both)>0 and min(len(arr),len(brr))==0):
        ans+=[both.pop()]
    else:
        break
if(len(ans)<k):
    print(-1)
else:
    print(sum(ans))
             
    
    

    