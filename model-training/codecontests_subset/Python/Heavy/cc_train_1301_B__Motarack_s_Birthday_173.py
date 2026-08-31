for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    mi=10**9+1
    mx=-10**9+1
    for i in range(1,n-1):
        if arr[i]!=-1 and arr[i-1]==-1:
            mi=min(mi,arr[i])
            mx=max(mx,arr[i])
        if arr[i]!=-1 and arr[i+1]==-1:
            mi=min(mi,arr[i])
            mx=max(mx,arr[i])
    if arr[0]!=-1 and arr[1]==-1:
        mi=min(mi,arr[0])
        mx=max(mx,arr[0])
    if arr[n-1]!=-1 and arr[n-2]==-1:
        mi=min(mi,arr[n-1])
        mx=max(mx,arr[n-1])
    a=(mi+mx)//2
    for i in range(n):
        if arr[i]==-1:
            arr[i]=a
    #print(arr)
    res=-10**9+1
    for i in range(n-1):
        res=max(res,abs(arr[i]-arr[i+1]))
    print(res,a)
        
    