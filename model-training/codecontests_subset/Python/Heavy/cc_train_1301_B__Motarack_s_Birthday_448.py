for ttt in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    minus_one=arr.count(-1)
    if n==minus_one:
        print(0,0)
        continue
    res=[]
    for i in range(n):
        if arr[i]==-1:
            if i==0:
                if arr[i+1]!=-1:
                    res.append(arr[i+1])
            elif i==n-1:
                if arr[i-1]!=-1:
                    res.append(arr[i-1])
            else:
                if arr[i-1]!=-1:
                    res.append(arr[i-1])
                if arr[i+1]!=-1:
                    res.append(arr[i+1])
    maxi=max(res)
    mini=min(res)
    mm=(mini+maxi)//2
    for i in range(n):
        if arr[i]==-1:
            arr[i]=mm 
    maxiiii=0
    for i in range(n-1):
        maxiiii=max(maxiiii,abs(arr[i]-arr[i+1]))
    print(maxiiii,mm)