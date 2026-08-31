n=int(input())
arr=list(map(int,input().split()))
if n==1:
    print(1,1)
    print((-1)*arr[0])
    print(1,1)
    print(0)
    print(1,1)
    print(0)
else:
    lis=[]
    for i in range(n):
        if arr[i]%n==0:
            lis.append(arr[i]*(-1))
            arr[i]=0
        else:
            lis.append(arr[i]*n*(-1))
            arr[i]+=(arr[i]*n*(-1))
    print(1,n)
    print(" ".join(str(x) for x in lis))
    lis=[]
    for i in range(n-1):
        if arr[i]%(n-1)==0:
            lis.append(arr[i]*(-1))
            arr[i]=0
    print(1,n-1)
    print(" ".join(str(x) for x in lis))
    lis=[]
    for i in range(1,n):
        if arr[i]%(n-1)==0:
            lis.append(arr[i]*(-1))
            arr[i]=0
    print(2,n)
    print(" ".join(str(x) for x in lis))

