for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    i = 0
    j = 1
    k = n-1
    t = 0
    while j!=k:
        if arr[i] + arr[j] <= arr[k]:
            print(i+1,j+1,k+1)
            t = -1
            break
        k-=1
    if t==0:
        print(-1)
