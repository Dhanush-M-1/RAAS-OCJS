for _ in range(int(input())):
    N,M = map(int,input().split())
    arr = list(map(int,input().split()))
    brr = list(map(int,input().split()))
    adic={}
    for i in range(len(arr)):
        if(arr[i] not in adic):
            adic[arr[i]]= 1
    flag=1 
    store=0
    for j in range(len(brr)):
        if(brr[j] not in adic):
            flag =0
        else:
            store=brr[j]
            flag=1
            break 
    if(flag==0):
        print('NO')
    else:
        print('YES')
        print(1,store)