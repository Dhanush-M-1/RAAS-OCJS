import sys, math
input=sys.stdin.readline
n,k=map(int,input().split())
both=[]
a=[]
b=[]
for i in range(n):
    ti,ai,bi=map(int,input().split())
    if ai==1 and bi==1:
        both.append(ti)
    elif ai==1 and bi==0:
        a.append(ti)
    elif ai==0 and bi==1:
        b.append(ti)
both.sort()
a.sort()
b.sort()
bothPointer = 0
aPointer = 0
bPointer = 0
alength = len(a)
blength = len(b)
bothlength = len(both)
ans = [0]*(k+1)
flag = True
for i in range(1,k+1):
    if aPointer<alength and bPointer<blength:
        if bothPointer < bothlength:
            if a[aPointer] + b[bPointer] < both[bothPointer]:
                ans[i] = ans[i-1] + a[aPointer] + b[bPointer]
                aPointer+=1
                bPointer+=1
            else:
                ans[i]=ans[i-1]+both[bothPointer]
                bothPointer+=1
        else:
            ans[i] = ans[i-1] + a[aPointer] + b[bPointer]
            aPointer+=1
            bPointer+=1
    else:
        if bothPointer < bothlength:
            ans[i]=ans[i-1]+both[bothPointer]
            bothPointer+=1
        else:
            flag = False
            break
if flag:
    print(ans[k])
else:
    print(-1)