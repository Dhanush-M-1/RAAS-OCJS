import sys
t=int(sys.stdin.readline())
for _ in range(t):
    n=int(sys.stdin.readline())
    arr=list(map(int,sys.stdin.readline().split()))
    a=set()
    for i in range(n):
        if arr[i]==-1:
            if i+1<n and arr[i+1]!=-1:
                a.add(arr[i+1])
            if i-1>=0 and arr[i-1]!=-1:
                a.add(arr[i-1])
    if len(a)<1:
        print(0,0)
    else:
        low,high=min(a),max(a)
        k=(low+high)//2
        #print(k,'k')
        for i in range(n):
            if arr[i]==-1:
                arr[i]=k
        dif=0
        for i in range(n-1):
            dif=max(dif,abs(arr[i]-arr[i+1]))
        print(dif,k)
                
