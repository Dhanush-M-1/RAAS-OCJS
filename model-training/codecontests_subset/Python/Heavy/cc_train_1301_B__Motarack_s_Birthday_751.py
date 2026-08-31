for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    m = 0
    for i in range(1,n):
        if arr[i]!=-1 and arr[i-1]!=-1:
            m = max(m,abs(arr[i]-arr[i-1]))
    maxx = 0
    minn = 10**9
    for i in range(1,n-1):
        if arr[i]==-1:
            if arr[i-1]!=-1:
                maxx = max(maxx,arr[i-1])
                minn = min(minn,arr[i-1])
            if arr[i+1]!=-1:
                maxx = max(maxx,arr[i+1])
                minn = min(minn,arr[i+1])
    if arr[0]==-1:
        if arr[1]!=-1:
            maxx = max(maxx, arr[1])
            minn = min(minn, arr[1])
    if arr[-1]==-1:
        if arr[-2]!=-1:
            maxx = max(maxx,arr[-2])
            minn = min(minn, arr[-2])
    if m==0:
        if maxx==0 and minn==10**9:
            print(0,1)
        else:
            x = (maxx+minn)//2
            print(max(maxx-x, x-minn),x)
    else:
        b = False
        x = (maxx+minn)//2
        if max(maxx-x,x-minn)>m:
            print(max(maxx-x,x-minn),x)
        else:
            print(m,x)