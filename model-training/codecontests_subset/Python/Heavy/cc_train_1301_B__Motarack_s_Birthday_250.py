from sys import stdin,stdout,setrecursionlimit
for _ in range(int(stdin.readline())):
    n=int(stdin.readline())
    # n,k=list(map(int,stdin.readline().split()))
    a=list(map(int,stdin.readline().split()))
    mn=float('inf')
    mx=float('-inf')
    for i in range(n):
        if a[i]==-1:continue
        if (i-1>=0 and a[i-1]==-1) or (i+1<n and a[i+1]==-1):
            mx=max(mx,a[i])
            mn=min(mn,a[i])
    if mx==float('-inf'):
        print(0,1)
        continue
    place=(mn+mx)//2;diff=0
    for i in range(1,n):
        left=a[i-1] if a[i-1]!=-1 else place
        cur=a[i] if a[i]!=-1 else place
        diff=max(diff,abs(cur-left))
    print(diff,place)