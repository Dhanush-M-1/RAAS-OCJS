for  i in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    ls=[]
    for i in range(n):
        if arr[i]==-1:
            continue
        if i<n-1 and arr[i+1]==-1 or i>0 and arr[i-1]==-1:
            ls.append(arr[i])
    if ls==[]:
        ls.append(0)
    var=(min(ls)+max(ls))//2
    #print(var)
    m=0
    for i in range(n-1):
        if arr[i]==-1:
            arr[i]=var
        if arr[i+1]==-1:
            arr[i+1]=var
        ans=abs(arr[i]-arr[i+1])
        m=max(m,ans)
    print(m, var)


