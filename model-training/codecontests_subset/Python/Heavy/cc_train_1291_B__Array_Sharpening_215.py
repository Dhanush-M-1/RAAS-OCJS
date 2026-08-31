for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    t1,t2 = [0 for i in range(n)],[0 for i in range(n)]
    t1[0] = 1
    for i in range(1,n):
        if arr[i]>=i and t1[i-1]==1:
            t1[i]=1
    t2[n-1] = 1
    for i in range(n-2,-1,-1):
        l = n-i-1
        if arr[i]>=l and t2[i+1]==1:
            t2[i] = 1
    f = 0
    for i in range(n):
        if t1[i]==1 and t2[i]==1:
            f =1 
    if f==1:
        print("Yes")
    else:
        print("No")