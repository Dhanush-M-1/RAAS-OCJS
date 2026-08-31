for _ in range(int(input())):
    n=int(input())
    arr=list(map(int,input().split()))
    '''if arr==sorted(arr) or arr==sorted(arr,reverse=True):
        print('YES')
        continue'''
    i=1
    while i<n and arr[i]>arr[i-1]:
        i+=1
    while i<n and arr[i]<arr[i]-1:
        i-=1
    if i==n:
        print('YES')
        continue
    i=1
    for i in range(1,n):
        if arr[i]>=arr[i-1]:
            break
    if i==n:
        print('YES')
        continue
    i,j=0,n-1
    flag=True
    while i<j:
        if arr[i]<i or arr[j]<i:
            flag=False
            break
        i+=1
        j-=1
    if i<j:
        print('NO')
        continue
    #print(flag)
    #print(i,j)
    if i==j:
        #print('here')
        if arr[i]<i:
            flag=False
    if i>j:
        if arr[i]==arr[j] and arr[i]==j:
            flag=False
    if flag:
        print('YES')
    else:
        #print('here')
        print('NO')
