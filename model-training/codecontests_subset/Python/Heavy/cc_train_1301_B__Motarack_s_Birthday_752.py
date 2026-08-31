for i in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    adj= []
    for i in range(0,len(arr)):
        if arr[i] != -1:
            if i-1>=0 and arr[i-1]==-1:
                adj.append(arr[i])
            if i+1<len(arr) and arr[i+1]==-1:
                adj.append(arr[i])

    if len(adj)>0:
        mi = min(adj)
        ma = max(adj)
        k = (mi+ma)//2
        mm = 0
        for i in range(0,len(arr)-1):
            if arr[i]==-1:
                arr[i] = k
            if arr[i+1] == -1:
                arr[i+1] = k
            mm = max(mm,abs(arr[i+1]-arr[i]))

        print(" ".join([str(mm),str(k)]))
    else:
        print(" ".join([str(0),str(1)]))