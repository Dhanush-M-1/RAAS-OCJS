import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)

t=int(input())
for _ in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    
    lowerLimit=0
    for i in range(n):
        if a[i]<lowerLimit:
            break
        lowerLimit+=1
    if i!=0 and a[i]==a[i-1]:
        a[i]-=1
    ok=True
    for j in range(i,n):
        lowerLimit=min(lowerLimit,a[j])
        if lowerLimit<0:
            ok=False
            break
        lowerLimit-=1
    if ok:
        print('Yes')
    else:
        print('No')