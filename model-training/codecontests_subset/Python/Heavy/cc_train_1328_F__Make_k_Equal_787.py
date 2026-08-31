# t=int(input())
t=1
for j in range(t):
    n,k=list(map(int,input().strip().split()))
    a=list(map(int,input().strip().split()))
    arr=[]
    for i in range(2*10**5+2):
        arr.append([])
    for i in a:
        x=0
        xx=i
        arr[xx].append(x)
        while(xx):
            xx=xx//2
            x+=1
            arr[xx].append(x)
    op=sum(arr[0])
    # print(arr)
    for i in arr:
        
        if(len(i)<k):
            continue
        x=i.copy()
        x.sort()
        op=min(op,sum(x[:k]))
    print(op)
        