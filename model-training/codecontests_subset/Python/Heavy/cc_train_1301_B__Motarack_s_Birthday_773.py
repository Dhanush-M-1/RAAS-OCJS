for _ in range(int(input())):
    n= int(input())
    arr=list(map(int,input().split()))
    m=[]
    diff=0
    if arr[0]==-1 and arr[1]!=-1:
        m.append(arr[1])
    if arr[-1]==-1 and arr[-2]!=-1:
        m.append(arr[-2])
    for i in range(1,n-1):
        if arr[i]==-1:
            if arr[i-1]!=-1:
                m.append(arr[i-1])
            if arr[i+1]!=-1:
                m.append(arr[i+1])
        else:
            if arr[i-1]!=-1:
                diff=max(diff,abs(arr[i]-arr[i-1]))
            if arr[i+1]!=-1:
                diff=max(diff,abs(arr[i]-arr[i+1]))
    if len(m)==0:
        print(0,69)
    else:
        ma=max(m)
        mi=min(m)
        val=(ma+mi)//2
        diff=max(diff,abs(val-ma),abs(val-mi))
        print(diff,val)
        
        
