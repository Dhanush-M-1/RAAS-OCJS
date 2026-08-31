import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)

t=int(input())
for _ in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    
    lowerLimit=0
    broken=False
    for i in range(n):
        if a[i]<lowerLimit:
            broken=True
            brokenIdx=i
            break
        lowerLimit+=1
    if broken==False:
        print('Yes')
    else:
        if a[brokenIdx]==a[brokenIdx-1]:
            a[brokenIdx]-=1
        lowerLimit=0
        ok=True
        for i in range(n-1,brokenIdx-1,-1):
            if a[i]<lowerLimit:
                ok=False
                break
            lowerLimit+=1
        if ok:
            print('Yes')
        else:
            print('No')